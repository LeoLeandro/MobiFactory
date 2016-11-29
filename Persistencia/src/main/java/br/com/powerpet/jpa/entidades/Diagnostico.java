/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.powerpet.util.constantes.TipoProcedimentoClinico;

/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="diagnostico")
public class Diagnostico extends ProcedimentoClinico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private final TipoProcedimentoClinico tipoProcedimento = TipoProcedimentoClinico.DIAGNOSTICO;
	
	/**
	 * @return the tipoProcedimento
	 */
	public TipoProcedimentoClinico getTipoProcedimentoClinico() {
		return tipoProcedimento;
	}
	
}