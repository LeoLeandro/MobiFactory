/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.powerpet.util.constantes.TipoProcedimentoClinico;

/**
 * @author Leonardo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="medicacao")
public class Medicacao extends ProcedimentoClinico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private final TipoProcedimentoClinico tipoProcedimento = TipoProcedimentoClinico.MEDICACAO;
	
	@Column
	private Integer dosagem;
	
	@OneToMany
	private Collection<Medicamento> medicamento;
	
	/**
	 * @return the dosagem
	 */
	public Integer getDosagem() {
		return dosagem;
	}

	/**
	 * @param dosagem the dosagem to set
	 */
	public void setDosagem(Integer dosagem) {
		this.dosagem = dosagem;
	}
	
	/**
	 * @return the tipoProcedimento
	 */
	public TipoProcedimentoClinico getTipoProcedimentoClinico() {
		return tipoProcedimento;
	}

	/**
	 * @return the medicamento
	 */
	public Collection<Medicamento> getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Collection<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}
	
}
