/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leonardo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="procedimento_clinico")
public abstract class ProcedimentoClinico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_procedimento")
	private Integer id;
	
	@Column(nullable=false)
	private String nomeProcedimento;
	
	@Id
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataProcedimento;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=true)
	private Integer duracao;
	
	@ManyToOne
	private Funcionario responsavel;
	
	private String observacao;
	
	@ManyToOne(cascade=CascadeType.ALL, optional=false)
	private CasoClinico casoClinico;

	/**
	 * @return the nomeProcedimento
	 */
	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	/**
	 * @param nomeProcedimento the nomeProcedimento to set
	 */
	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	/**
	 * @return the dataProcedimento
	 */
	public Date getDataProcedimento() {
		return dataProcedimento;
	}

	/**
	 * @param dataProcedimento the dataProcedimento to set
	 */
	public void setDataProcedimento(Date dataProcedimento) {
		this.dataProcedimento = dataProcedimento;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the casoClinico
	 */
	public CasoClinico getCasoClinico() {
		return casoClinico;
	}

	/**
	 * @param casoClinico the casoClinico to set
	 */
	public void setCasoClinico(CasoClinico casoClinico) {
		this.casoClinico = casoClinico;
	}
	
}
