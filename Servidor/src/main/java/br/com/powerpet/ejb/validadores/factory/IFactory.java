/**
 * 
 */
package br.com.powerpet.ejb.validadores.factory;

import br.com.power.pet.ejb.util.TipoEntidade;
import br.com.powerpet.ejb.validadores.IValidador;

/**
 * @author Leonardo
 *
 */
public interface IFactory {

	public IValidador criarValidador(TipoEntidade tipoEntidade);
	
}
