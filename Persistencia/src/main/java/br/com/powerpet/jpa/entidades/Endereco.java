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

import br.com.powerpet.jpa.pkey.EnderecoPK;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="endereco")
@IdClass(value=EnderecoPK.class)
public class Endereco implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_endereco")
	private Integer id;
	
	@Id
	@Column(nullable=false)
	private String logradouro;
	
	@Id
	@Column(nullable=false)
	private Integer numero;
	
	@Column(nullable=false)
	private String bairro;
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String estado;
	
	@Id
	@Column(nullable=false)
	private String CEP;
	
	private String complemento;

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cEP
	 */
	public String getCEP() {
		return CEP;
	}

	/**
	 * @param cEP the cEP to set
	 */
	public void setCEP(String cEP) {
		CEP = cEP;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
