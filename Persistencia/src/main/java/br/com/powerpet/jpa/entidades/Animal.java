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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.powerpet.util.constantes.PorteAnimal;
import br.com.powerpet.util.constantes.TipoAnimal;
import br.com.powerpet.util.constantes.TipoSanguineo;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="animal")
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_animal")
	private Integer id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String sexo;
	
	@Column(nullable=false)
	private Integer idade;
	
	@Column(nullable=false)
	private TipoAnimal tipo;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@Column
	private String pedrigree;
	
	@Column
	private String pelagem;
	
	@Column(nullable=false)
	private String especie;
	
	@Column(nullable=false)
	private PorteAnimal porte;
	
	@Column(nullable=false)
	private TipoSanguineo tipoSanguineo;
	
	@OneToMany
	private Collection<Foto> fotos;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<CasoClinico> casosClinicos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "id_cliente", insertable = false, updatable = false),
		@JoinColumn(name = "documento", insertable = false, updatable = false)
	})
	private Cliente dono;

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**
	 * @return the tipo
	 */
	public TipoAnimal getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}

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
	 * @return the pedrigree
	 */
	public String getPedrigree() {
		return pedrigree;
	}

	/**
	 * @param pedrigree the pedrigree to set
	 */
	public void setPedrigree(String pedrigree) {
		this.pedrigree = pedrigree;
	}

	/**
	 * @return the pelagem
	 */
	public String getPelagem() {
		return pelagem;
	}

	/**
	 * @param pelagem the pelagem to set
	 */
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	/**
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * @return the porte
	 */
	public PorteAnimal getPorte() {
		return porte;
	}

	/**
	 * @param porte the porte to set
	 */
	public void setPorte(PorteAnimal porte) {
		this.porte = porte;
	}

	/**
	 * @return the tipoSanguineo
	 */
	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	/**
	 * @param tipoSanguineo the tipoSanguineo to set
	 */
	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	/**
	 * @return the casoClinico
	 */
	public Collection<CasoClinico> getCasosClinicos() {
		return casosClinicos;
	}

	/**
	 * @param casoClinico the casoClinico to set
	 */
	public void setCasosClinicos(Collection<CasoClinico> casosClinicos) {
		this.casosClinicos = casosClinicos;
	}

	/**
	 * @return the dono
	 */
	public Cliente getDono() {
		return dono;
	}

	/**
	 * @param dono the dono to set
	 */
	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	/**
	 * @return the fotos
	 */
	public Collection<Foto> getFotos() {
		return fotos;
	}

	/**
	 * @param fotos the fotos to set
	 */
	public void setFotos(Collection<Foto> fotos) {
		this.fotos = fotos;
	}
	
}
