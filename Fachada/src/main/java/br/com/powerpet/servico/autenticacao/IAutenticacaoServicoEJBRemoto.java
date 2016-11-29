/**
 * 
 */
package br.com.powerpet.servico.autenticacao;

import java.util.List;

import javax.ejb.Remote;

import br.com.powerpet.dto.usuario.UsuarioDTO;
import br.com.powerpet.excecoes.UsuarioInvalidoException;

/**
 * @author Leonardo
 *
 */
@Remote
public interface IAutenticacaoServicoEJBRemoto {

	public void inserirUsuario(UsuarioDTO usuarioDTO, boolean primeiroAcesso) throws UsuarioInvalidoException;
	
	public void removerUsuario(UsuarioDTO usuarioDTO) throws UsuarioInvalidoException;
	
	public void atualizarUsuario(UsuarioDTO usuarioDTO) throws UsuarioInvalidoException;
	
	public UsuarioDTO buscarUsuarioPorEmail(String email) throws UsuarioInvalidoException;
	
	public List<UsuarioDTO> listarUsuarios();
	
}
