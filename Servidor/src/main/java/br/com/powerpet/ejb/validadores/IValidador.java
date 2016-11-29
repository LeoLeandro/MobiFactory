/**
 * 
 */
package br.com.powerpet.ejb.validadores;

import br.com.powerpet.dto.util.IDTO;
import br.com.powerpet.excecoes.UsuarioInvalidoException;

/**
 * @author Leonardo
 *
 */
public interface IValidador {

	public boolean validar(IDTO dto, boolean primeiroAcesso) throws UsuarioInvalidoException;
	
}
