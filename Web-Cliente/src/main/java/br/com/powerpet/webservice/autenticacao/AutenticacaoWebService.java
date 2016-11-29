/**
 * 
 */
package br.com.powerpet.webservice.autenticacao;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.powerpet.dto.usuario.UsuarioDTO;
import br.com.powerpet.excecoes.UsuarioInvalidoException;
import br.com.powerpet.servico.autenticacao.IAutenticacaoServicoEJBRemoto;
import br.com.powerpet.webservice.util.JSONResposta;

/**
 * @author Leonardo
 *
 */
@Path("autenticacao")
public class AutenticacaoWebService {

	@EJB
	private IAutenticacaoServicoEJBRemoto autenticacaoEJB;
	
	@GET
	@Path("novoUsuario")
	@Produces("application/json")
	@Consumes("application/json")
	public JSONResposta cadastrarUsuario(UsuarioDTO usuarioDTO) {
		JSONResposta resposta = null;
		
		try {
			this.autenticacaoEJB.inserirUsuario(usuarioDTO, true);
		} catch (UsuarioInvalidoException e) {
			e.printStackTrace();
		}
		
		return resposta;
	}
	
}
