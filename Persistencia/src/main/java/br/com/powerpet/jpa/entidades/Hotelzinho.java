/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="hotelzinho")
public class Hotelzinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_hotelzinho")
	private Integer id;
	
	@OneToOne
	private Animal pet;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dataCheckin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dataCheckout;
	
	private String observacoes;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the pet
	 */
	public Animal getPet() {
		return pet;
	}

	/**
	 * @param pet the pet to set
	 */
	public void setPet(Animal pet) {
		this.pet = pet;
	}

	/**
	 * @return the dataCheckin
	 */
	public Date getDataCheckin() {
		return dataCheckin;
	}

	/**
	 * @param dataCheckin the dataCheckin to set
	 */
	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	/**
	 * @return the dataCheckout
	 */
	public Date getDataCheckout() {
		return dataCheckout;
	}

	/**
	 * @param dataCheckout the dataCheckout to set
	 */
	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	/**
	 * @return the observacoes
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * @param observacoes the observacoes to set
	 */
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
