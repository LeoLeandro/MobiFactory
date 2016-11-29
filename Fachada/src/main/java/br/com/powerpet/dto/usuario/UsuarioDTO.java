/**
 * 
 */
package br.com.powerpet.dto.usuario;

import br.com.powerpet.dto.pessoa.PessoaDTO;
import br.com.powerpet.dto.util.IDTO;
import br.com.powerpet.util.constantes.TipoUsuario;

/**
 * @author Leonardo
 *
 */
public class UsuarioDTO implements IDTO {

	private String nome;
	
	private String senha;
	
	private String email;
	
	private TipoUsuario tipoUsuario;
	
	private PessoaDTO pessoa;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tipoUsuario
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the pessoa
	 */
	public PessoaDTO getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
}
