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
@Table(name="cirurgia")
public class Cirurgia extends ProcedimentoClinico {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private final TipoProcedimentoClinico tipoProcedimento = TipoProcedimentoClinico.CIRURGIA;
	
	@Column
	private String resultado;


	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}


	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * @return the resultado
	 */
	public TipoProcedimentoClinico getTipoProcedimentoClinico() {
		return tipoProcedimento;
	}
}
