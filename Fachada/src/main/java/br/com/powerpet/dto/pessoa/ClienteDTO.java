/**
 * 
 */
package br.com.powerpet.dto.pessoa;

import java.util.Collection;
import java.util.Date;

import br.com.powerpet.dto.animal.AnimalDTO;

/**
 * @author Leonardo
 *
 */
public class ClienteDTO extends PessoaDTO {

	private Date dataNascimento;
	
	private Boolean temPendencia;
	
	private Collection<AnimalDTO> pets;

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
	public Collection<AnimalDTO> getPets() {
		return pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(Collection<AnimalDTO> pets) {
		this.pets = pets;
	}
	
}
