/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="cliente")
public class Cliente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dataNascimento;
	
	private Boolean temPendencia;
	
	@OneToMany(mappedBy = "dono", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Animal> pets;

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the temPendencia
	 */
	public Boolean getTemPendencia() {
		return temPendencia;
	}

	/**
	 * @param temPendencia the temPendencia to set
	 */
	public void setTemPendencia(Boolean temPendencia) {
		this.temPendencia = temPendencia;
	}

	/**
	 * @return the pets
	 */
	public Collection<Animal> getPets() {
		return pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(Collection<Animal> pets) {
		this.pets = pets;
	}
	
}
