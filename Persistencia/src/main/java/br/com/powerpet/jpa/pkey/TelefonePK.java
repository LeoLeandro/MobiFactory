/**
 * 
 */
package br.com.powerpet.jpa.pkey;

import java.io.Serializable;

/**
 * @author Leonardo
 *
 */
public class TelefonePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer DDD;
	
	private Integer numero;
	
	public TelefonePK(){}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof TelefonePK) {
			TelefonePK pk = (TelefonePK) obj;
			
			if(!pk.getDDD().equals(this.DDD)) {
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
		return this.DDD.hashCode() + this.numero.hashCode();
	}

	/**
	 * @return the dDD
	 */
	public Integer getDDD() {
		return DDD;
	}

	/**
	 * @param dDD the dDD to set
	 */
	public void setDDD(Integer dDD) {
		DDD = dDD;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
