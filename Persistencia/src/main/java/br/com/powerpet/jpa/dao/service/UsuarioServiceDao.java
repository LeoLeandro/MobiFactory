/**
 * 
 */
package br.com.powerpet.jpa.dao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.powerpet.dto.pessoa.ClienteDTO;
import br.com.powerpet.dto.pessoa.FornecedorDTO;
import br.com.powerpet.dto.pessoa.FuncionarioDTO;
import br.com.powerpet.dto.pessoa.PessoaDTO;
import br.com.powerpet.dto.usuario.UsuarioDTO;
import br.com.powerpet.dto.util.EnderecoDTO;
import br.com.powerpet.dto.util.TelefoneDTO;
import br.com.powerpet.jpa.dao.impl.UsuarioDaoImpl;
import br.com.powerpet.jpa.entidades.Cliente;
import br.com.powerpet.jpa.entidades.Endereco;
import br.com.powerpet.jpa.entidades.Fornecedor;
import br.com.powerpet.jpa.entidades.Funcionario;
import br.com.powerpet.jpa.entidades.Pessoa;
import br.com.powerpet.jpa.entidades.Telefone;
import br.com.powerpet.jpa.entidades.Usuario;
import br.com.powerpet.util.constantes.TipoUsuario;

/**
 * @author Leonardo
 *
 */
public class UsuarioServiceDao {

	private UsuarioDaoImpl daoImpl;
	
	public UsuarioServiceDao() {
		this.daoImpl = new UsuarioDaoImpl();
	}
	
	/**
	 * Insere um usuário sem o objeto pessoa vinculado
	 * Usado no primeiro acesso, antes de informar os dados adicionais (dados da pessoa)
	 * @param usuarioDTO
	 */
	public void inserirUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.converteDTOParaEntidade(usuarioDTO);
		this.daoImpl.inserir(usuario);
	}
	
	/**
	 * Insere o usuário junto com a pessoa
	 * @param usuarioDTO
	 */
	public void inserirUsuarioCompleto(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.converteDTOParaEntidade(usuarioDTO);
		usuario.setPessoa(this.converteDTOPessoa(usuarioDTO));
		this.daoImpl.inserir(usuario);
	}
	
	/**
	 * 
	 * @param usuarioDTO
	 */
	public void atualizarUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.converteDTOParaEntidade(usuarioDTO);
		usuario.setPessoa(this.converteDTOPessoa(usuarioDTO));
		this.daoImpl.atualizar(usuario);
	}
	
	/**
	 * 
	 * @param usuarioDTO
	 */
	public void removerUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.converteDTOParaEntidade(usuarioDTO);
		usuario.setPessoa(this.converteDTOPessoa(usuarioDTO));
		this.daoImpl.remover(usuario);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<UsuarioDTO> listarUsuarios() {
		List<Usuario> usuarios = this.daoImpl.buscarTodos(Usuario.class);
		List<UsuarioDTO> usuariosDTO = null;
		
		if(usuarios == null || usuarios.isEmpty()) {
			usuariosDTO = new ArrayList<UsuarioDTO>();	
		} else {
			usuariosDTO = this.converteEntidadeParaDTO(usuarios);			
		}
		
		return usuariosDTO;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public UsuarioDTO buscarUsuarioPorEmail(String email) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		Usuario usuario = this.daoImpl.buscarPor(Usuario.class, email);
		usuarioDTO = this.converteEntidadeParaDTO(usuario);
		
		return usuarioDTO;
	}
	
	/**
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private Usuario converteDTOParaEntidade(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());
		
		return usuario;
	}

	/**
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private Pessoa converteDTOPessoa(UsuarioDTO usuarioDTO) {
		
		Pessoa pessoa = null;

		Endereco endereco = this.converteDTOEndereco(usuarioDTO);
		List<Telefone> telefones = this.converteDTOTelefone(usuarioDTO.getPessoa().getTelefones());
		
		if(usuarioDTO.getTipoUsuario().equals(TipoUsuario.CLIENTE)) {
			pessoa = new Cliente();
			
			((Cliente)pessoa).setDataNascimento(((ClienteDTO)usuarioDTO.getPessoa()).getDataNascimento());
			((Cliente)pessoa).setDocumento(((ClienteDTO)usuarioDTO.getPessoa()).getDocumento());
			((Cliente)pessoa).setNome(((ClienteDTO)usuarioDTO.getPessoa()).getNome());
			((Cliente)pessoa).setTipoPessoa(((ClienteDTO)usuarioDTO.getPessoa()).getTipoPessoa());
			((Cliente)pessoa).setTemPendencia(((ClienteDTO)usuarioDTO.getPessoa()).getTemPendencia());
			((Cliente)pessoa).setEndereco(endereco);
			((Cliente)pessoa).setTelefones(telefones);
			
		} else if(usuarioDTO.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR) || usuarioDTO.getTipoUsuario().equals(TipoUsuario.FUNCIONARIO)) {
			pessoa = new Funcionario();
			
			((Funcionario)pessoa).setDataNascimento(((FuncionarioDTO)usuarioDTO.getPessoa()).getDataNascimento());
			((Funcionario)pessoa).setDataAdmissao(((FuncionarioDTO)usuarioDTO.getPessoa()).getDataAdmissao());
			((Funcionario)pessoa).setDataDemissao(((FuncionarioDTO)usuarioDTO.getPessoa()).getDataDemissao());
			((Funcionario)pessoa).setCarteiraTrabalho(((FuncionarioDTO)usuarioDTO.getPessoa()).getCarteiraTrabalho());
			((Funcionario)pessoa).setDocumento(((FuncionarioDTO)usuarioDTO.getPessoa()).getDocumento());
			((Funcionario)pessoa).setFuncao(((FuncionarioDTO)usuarioDTO.getPessoa()).getFuncao());
			((Funcionario)pessoa).setNome(((FuncionarioDTO)usuarioDTO.getPessoa()).getNome());
			((Funcionario)pessoa).setPis(((FuncionarioDTO)usuarioDTO.getPessoa()).getPis());
			((Funcionario)pessoa).setSalario(((FuncionarioDTO)usuarioDTO.getPessoa()).getSalario());
			((Funcionario)pessoa).setTipoPessoa(((FuncionarioDTO)usuarioDTO.getPessoa()).getTipoPessoa());
			((Funcionario)pessoa).setEndereco(endereco);
			((Funcionario)pessoa).setTelefones(telefones);
			
		}
		
		return pessoa;
	}

	/**
	 * @param telefones
	 * @return
	 */
	private List<Telefone> converteDTOTelefone(List<TelefoneDTO> telefonesDTO) {
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		for(TelefoneDTO dto : telefonesDTO) {
			Telefone telefone = new Telefone();
			telefone.setDDD(dto.getDDD());
			telefone.setNumero(dto.getNumero());
			
			telefones.add(telefone);
		}
		
		return telefones;
	}

	/**
	 * @param usuarioDTO
	 * @return
	 */
	private Endereco converteDTOEndereco(UsuarioDTO usuarioDTO) {
		Endereco endereco = new Endereco();
		endereco.setBairro(usuarioDTO.getPessoa().getEndereco().getBairro());
		endereco.setCEP(usuarioDTO.getPessoa().getEndereco().getCEP());
		endereco.setCidade(usuarioDTO.getPessoa().getEndereco().getCidade());
		endereco.setComplemento(usuarioDTO.getPessoa().getEndereco().getComplemento());
		endereco.setEstado(usuarioDTO.getPessoa().getEndereco().getEstado());
		endereco.setLogradouro(usuarioDTO.getPessoa().getEndereco().getLogradouro());
		endereco.setNumero(usuarioDTO.getPessoa().getEndereco().getNumero());
		
		return endereco;
	}
	
	/**
	 * 
	 * @param usuarios
	 * @return
	 */
	private UsuarioDTO converteEntidadeParaDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(usuario.getEmail());
		dto.setNome(usuario.getNome());
		dto.setSenha(usuario.getSenha());
		dto.setTipoUsuario(usuario.getTipoUsuario());
		dto.setPessoa(this.convertePessoaParaDTO(usuario.getPessoa()));
		
		return usuarioDTO;
	}
	
	/**
	 * 
	 * @param usuarios
	 * @return
	 */
	private List<UsuarioDTO> converteEntidadeParaDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for(Usuario usuario : usuarios) {
			
			UsuarioDTO dto = new UsuarioDTO();
			dto.setEmail(usuario.getEmail());
			dto.setNome(usuario.getNome());
			dto.setSenha(usuario.getSenha());
			dto.setTipoUsuario(usuario.getTipoUsuario());
			
			dto.setPessoa(this.convertePessoaParaDTO(usuario.getPessoa()));

			usuariosDTO.add(dto);
		}
		
		return usuariosDTO;
	}

	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	private PessoaDTO convertePessoaParaDTO(Pessoa pessoa) {
		
		PessoaDTO pessoaDTO = null;
		
		List<TelefoneDTO> telefonesDTO = this.converteTelefoneParaDTO(pessoa.getTelefones());
		EnderecoDTO enderecoDTO = this.converteEnderecoParaDTO(pessoa.getEndereco());
		
		if(pessoa instanceof Cliente) {
			pessoaDTO = new ClienteDTO();
			((ClienteDTO)pessoaDTO).setDataNascimento(((Cliente)pessoa).getDataNascimento());
			((ClienteDTO)pessoaDTO).setDocumento(((Cliente)pessoa).getDocumento());
			((ClienteDTO)pessoaDTO).setNome(((Cliente)pessoa).getNome());
			((ClienteDTO)pessoaDTO).setTemPendencia(((Cliente)pessoa).getTemPendencia());
			((ClienteDTO)pessoaDTO).setTipoPessoa(((Cliente)pessoa).getTipoPessoa());
			
		} else if(pessoa instanceof Funcionario) {
			pessoaDTO = new FuncionarioDTO();
			((FuncionarioDTO)pessoaDTO).setCarteiraTrabalho(((Funcionario)pessoa).getCarteiraTrabalho());
			((FuncionarioDTO)pessoaDTO).setDataAdmissao(((Funcionario)pessoa).getDataAdmissao());
			((FuncionarioDTO)pessoaDTO).setDataDemissao(((Funcionario)pessoa).getDataDemissao());
			((FuncionarioDTO)pessoaDTO).setDataNascimento(((Funcionario)pessoa).getDataNascimento());
			((FuncionarioDTO)pessoaDTO).setDocumento(((Funcionario)pessoa).getDocumento());
			((FuncionarioDTO)pessoaDTO).setFuncao(((Funcionario)pessoa).getFuncao());
			((FuncionarioDTO)pessoaDTO).setNome(((Funcionario)pessoa).getNome());
			((FuncionarioDTO)pessoaDTO).setPis(((Funcionario)pessoa).getPis());
			((FuncionarioDTO)pessoaDTO).setSalario(((Funcionario)pessoa).getSalario());
			((FuncionarioDTO)pessoaDTO).setTipoPessoa(((Funcionario)pessoa).getTipoPessoa());
			
		} else if(pessoa instanceof Fornecedor) {
			pessoaDTO = new FornecedorDTO();
			((FornecedorDTO)pessoaDTO).setDocumento(((Fornecedor)pessoa).getDocumento());
			((FornecedorDTO)pessoaDTO).setNome(((Fornecedor)pessoa).getNome());
			((FornecedorDTO)pessoaDTO).setTipoPessoa(((Fornecedor)pessoa).getTipoPessoa());
		}
		
		pessoaDTO.setTelefones(telefonesDTO);
		pessoaDTO.setEndereco(enderecoDTO);
		
		return pessoaDTO;
	}

	/**
	 * 
	 * @param endereco
	 * @return
	 */
	private EnderecoDTO converteEnderecoParaDTO(Endereco endereco) {
		EnderecoDTO dto = new EnderecoDTO();
		
		dto.setBairro(endereco.getBairro());
		dto.setCEP(endereco.getCEP());
		dto.setCidade(endereco.getCidade());
		dto.setComplemento(endereco.getComplemento());
		dto.setEstado(endereco.getEstado());
		dto.setLogradouro(endereco.getLogradouro());
		dto.setNumero(endereco.getNumero());
		
		return dto;
	}

	/**
	 * 
	 * @param telefones
	 * @return
	 */
	private List<TelefoneDTO> converteTelefoneParaDTO(List<Telefone> telefones) {
		
		List<TelefoneDTO> telefonesDTO = new ArrayList<TelefoneDTO>();
		
		for(Telefone telefone : telefones) {
			TelefoneDTO dto = new TelefoneDTO();
			dto.setDDD(telefone.getDDD());
			dto.setNumero(telefone.getNumero());
			
			telefonesDTO.add(dto);
		}
		
		return telefonesDTO;
	}
}
