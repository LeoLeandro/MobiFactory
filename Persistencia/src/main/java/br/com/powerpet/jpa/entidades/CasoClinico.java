/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="caso_clinico")
public class CasoClinico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_caso_clinico")
	private Integer id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;

	private String observacoes;
	
	@OneToMany(mappedBy = "casoClinico", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<ProcedimentoClinico> procedimentosRealizados;

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
	 * @return the dataDoRegistro
	 */
	public Date getDataRegistro() {
		return dataRegistro;
	}

	/**
	 * @param dataRegistro the dataDoRegistro to set
	 */
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
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
	 * @return the procedimentosRealizados
	 */
	public Collection<ProcedimentoClinico> getProcedimentosRealizados() {
		return procedimentosRealizados;
	}

	/**
	 * @param procedimentosRealizados the procedimentosRealizados to set
	 */
	public void setProcedimentosRealizados(Collection<ProcedimentoClinico> procedimentosRealizados) {
		this.procedimentosRealizados = procedimentosRealizados;
	}
	
}
