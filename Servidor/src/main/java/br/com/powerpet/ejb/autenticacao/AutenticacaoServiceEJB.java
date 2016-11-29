package br.com.powerpet.ejb.autenticacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.power.pet.ejb.util.TipoEntidade;
import br.com.powerpet.dto.usuario.UsuarioDTO;
import br.com.powerpet.ejb.validadores.IValidador;
import br.com.powerpet.ejb.validadores.factory.AbstractValidadorFactory;
import br.com.powerpet.excecoes.UsuarioInvalidoException;
import br.com.powerpet.jpa.dao.service.UsuarioServiceDao;
import br.com.powerpet.servico.autenticacao.IAutenticacaoServicoEJBLocal;
import br.com.powerpet.servico.autenticacao.IAutenticacaoServicoEJBRemoto;
import br.com.powerpet.util.constantes.MensagemExcecao;

/**
 * Session Bean implementation class AutenticacaoServiceEJB
 */
@Stateless(mappedName = "AutenticacaoServiceEJB")
public class AutenticacaoServiceEJB implements IAutenticacaoServicoEJBRemoto, IAutenticacaoServicoEJBLocal {
	
	@Inject
	private UsuarioServiceDao usuarioServiceDao;
	
	@Inject
	private AbstractValidadorFactory validadorFactory;
	
    /**
     * Default constructor. 
     */
    public AutenticacaoServiceEJB() {}

	@Override
	public void inserirUsuario(UsuarioDTO usuarioDTO, boolean primeiroAcesso) throws UsuarioInvalidoException {
		IValidador validador = this.validadorFactory.criarValidador(TipoEntidade.USUARIO);
		validador.validar(usuarioDTO, primeiroAcesso);
		
		if(primeiroAcesso) {
			this.usuarioServiceDao.inserirUsuario(usuarioDTO);
		} else {
			this.usuarioServiceDao.inserirUsuarioCompleto(usuarioDTO);
		}
	}

	@Override
	public void removerUsuario(UsuarioDTO usuarioDTO) throws UsuarioInvalidoException {
		if(usuarioDTO != null && usuarioDTO.getEmail() != null) {
			if(this.usuarioServiceDao.buscarUsuarioPorEmail(usuarioDTO.getEmail()) != null) {
				this.usuarioServiceDao.removerUsuario(usuarioDTO);
			} else {
				throw new UsuarioInvalidoException(MensagemExcecao.USUARIO_INEXISTENTE.getMensagem());
			}
		} else {
			throw new UsuarioInvalidoException(MensagemExcecao.USUARIO_INVALIDO.getMensagem());
		}
	}

	@Override
	public void atualizarUsuario(UsuarioDTO usuarioDTO) throws UsuarioInvalidoException {
		IValidador validador = this.validadorFactory.criarValidador(TipoEntidade.USUARIO);
		validador.validar(usuarioDTO, false);
		
		this.usuarioServiceDao.atualizarUsuario(usuarioDTO);
	}

	@Override
	public UsuarioDTO buscarUsuarioPorEmail(String email) throws UsuarioInvalidoException {
		if(email == null || email.isEmpty()) {
			throw new UsuarioInvalidoException(MensagemExcecao.EMAIL_USUARIO_NULO_OU_INVALIDO.getMensagem());
		}
		
		UsuarioDTO dto = this.usuarioServiceDao.buscarUsuarioPorEmail(email);
		if(dto == null) {
			throw new UsuarioInvalidoException(MensagemExcecao.USUARIO_INEXISTENTE.getMensagem());
		}
		
		return dto;
	}

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		List<UsuarioDTO> dtos = this.usuarioServiceDao.listarUsuarios();
		return dtos;
	}

}
