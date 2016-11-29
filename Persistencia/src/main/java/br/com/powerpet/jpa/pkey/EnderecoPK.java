/**
 * 
 */
package br.com.powerpet.jpa.pkey;

import java.io.Serializable;

/**
 * @author Leonardo
 *
 */
public class EnderecoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	
	private Integer numero;
	
	public EnderecoPK(){}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof EnderecoPK) {
			EnderecoPK pk = (EnderecoPK) obj;
			
			if(!pk.getLogradouro().equals(this.logradouro)) {
				return false;
			}
			
			if(!pk.getNumero().equals(this.numero)) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.logradouro.hashCode() + this.numero.hashCode();
	}

	/**
	 * @return the logradouroPK
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouroPK the logradouroPK to set
	 */
	public void setLogradouro(String logradouroPK) {
		this.logradouro = logradouroPK;
	}

	/**
	 * @return the numeroPK
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numeroPK the numeroPK to set
	 */
	public void setNumero(Integer numeroPK) {
		this.numero = numeroPK;
	}

}
