/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="exame")
public class Exame extends ProcedimentoClinico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

}
