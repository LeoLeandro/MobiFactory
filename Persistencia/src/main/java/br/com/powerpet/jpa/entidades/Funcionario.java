/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="funcionario")
public class Funcionario extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dataNascimento;
	
	@Column(nullable=false)
	private BigDecimal salario;
	
	@Column(nullable=false, unique=true)
	private Integer carteiraTrabalho;
	
	@Column(nullable=false, unique=true)
	private Integer pis;
	
	@Column(nullable=false)
	private String funcao;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDemissao;

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
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * @return the carteiraTrabalho
	 */
	public Integer getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	/**
	 * @param carteiraTrabalho the carteiraTrabalho to set
	 */
	public void setCarteiraTrabalho(Integer carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	/**
	 * @return the pis
	 */
	public Integer getPis() {
		return pis;
	}

	/**
	 * @param pis the pis to set
	 */
	public void setPis(Integer pis) {
		this.pis = pis;
	}

	/**
	 * @return the funcao
	 */
	public String getFuncao() {
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	/**
	 * @return the dataAdmissao
	 */
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	/**
	 * @param dataAdmissao the dataAdmissao to set
	 */
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	/**
	 * @return the dataDemissao
	 */
	public Date getDataDemissao() {
		return dataDemissao;
	}

	/**
	 * @param dataDemissao the dataDemissao to set
	 */
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	
}
