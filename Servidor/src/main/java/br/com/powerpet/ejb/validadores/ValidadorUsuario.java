/**
 * 
 */
package br.com.powerpet.ejb.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.powerpet.dto.usuario.UsuarioDTO;
import br.com.powerpet.dto.util.IDTO;
import br.com.powerpet.excecoes.UsuarioInvalidoException;
import br.com.powerpet.util.constantes.MensagemExcecao;
import br.com.powerpet.util.constantes.PossiveisValores;

/**
 * @author Leonardo
 *
 */
public class ValidadorUsuario implements IValidador {

	@Override
	public boolean validar(IDTO dto, boolean primeiroAcesso) throws UsuarioInvalidoException {
		UsuarioDTO usuarioDTO = (UsuarioDTO) dto;
		
		boolean valido = false;
		
		if(usuarioDTO == null) {
			throw new UsuarioInvalidoException(MensagemExcecao.USUARIO_INVALIDO.getMensagem());
			
		} else if(usuarioDTO.getNome() == null || usuarioDTO.getNome().isEmpty()) {
			throw new UsuarioInvalidoException(MensagemExcecao.NOME_USUARIO_NULO_OU_INVALIDO.getMensagem());
		
		} else if(usuarioDTO.getSenha() == null || usuarioDTO.getSenha().isEmpty()) {
			throw new UsuarioInvalidoException(MensagemExcecao.SENHA_USUARIO_NULA_OU_INVALIDA.getMensagem());
			
		} else if(usuarioDTO.getSenha().length() < PossiveisValores.LIMITE_MINIMO_SENHA) {
			throw new UsuarioInvalidoException(MensagemExcecao.SENHA_MENOR_LIMITE_MINIMO.getMensagem());
			
		} else if(usuarioDTO.getSenha().length() > PossiveisValores.LIMITE_MAXIMO_SENHA) {
			throw new UsuarioInvalidoException(MensagemExcecao.SENHA_MAIOR_LIMITE_MAXIMO.getMensagem());
			
		} else if(usuarioDTO.getEmail() == null || usuarioDTO.getEmail().isEmpty()) {
			throw new UsuarioInvalidoException(MensagemExcecao.EMAIL_USUARIO_NULO_OU_INVALIDO.getMensagem());
				
		} else if(!this.validarEmail(usuarioDTO.getEmail())) {
			throw new UsuarioInvalidoException(MensagemExcecao.FORMATO_EMAIL_USUARIO_INVALIDO.getMensagem());
			
		} else {
			valido = true;			
		}
		
		if(!primeiroAcesso) {
			//TODO: VALIDAR PESSOA
		}
		
		return valido;
	}
	
	private boolean validarEmail(String email) {
		String padrao = "^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9]\\.)*([a-zA-Z0-9])*\\.";
		Pattern pattern = Pattern.compile(padrao); 
        Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

}
