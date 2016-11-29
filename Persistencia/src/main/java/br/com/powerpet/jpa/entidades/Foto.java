/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="foto")
public class Foto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Lob 
	@Basic(fetch= FetchType.EAGER) 
	@Column(columnDefinition="bytea")
	private byte[] imagem;

	public Foto() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Foto other = (Foto) obj;
		if (this.id != other.id) {
			return false;
		}
		if (!Arrays.equals(this.imagem, other.imagem)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.id;
		hash = 31 * hash + Arrays.hashCode(this.imagem);
		return hash;
	}

}
