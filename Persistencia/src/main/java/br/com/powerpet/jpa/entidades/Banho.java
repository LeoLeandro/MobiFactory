/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="banho")
public class Banho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_banho")
	private Integer id;
	
	private String observacoes;
	
	@OneToOne
	private Funcionario responsavel;
	
	@OneToOne
	private Animal pet;
	
	@OneToMany
	private Collection<Produto> produtos;
	
	@Id
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataBanho;

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

	/**
	 * @return the responsavel
	 */
	public Funcionario getResponsavel() {
		return responsavel;
	}

	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
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
	 * @return the produtos
	 */
	public Collection<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the dataBanho
	 */
	public Date getDataBanho() {
		return dataBanho;
	}

	/**
	 * @param dataBanho the dataBanho to set
	 */
	public void setDataBanho(Date dataBanho) {
		this.dataBanho = dataBanho;
	}
}
