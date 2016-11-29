/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.powerpet.jpa.pkey.TelefonePK;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="telefone")
@IdClass(value=TelefonePK.class)
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_telefone")
	private Integer id;
	
	@Id
	@Column(nullable=false)
	private Integer DDD;
	
	@Id
	@Column(nullable=false)
	private Integer numero;

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
