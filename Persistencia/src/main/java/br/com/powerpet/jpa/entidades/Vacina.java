/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.powerpet.util.constantes.TipoMedicacao;

/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="vacina")
public class Vacina extends Medicamento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private final TipoMedicacao tipoMedicacao = TipoMedicacao.VACINA;

	/**
	 * @return the tipoMedicacao
	 */
	public TipoMedicacao getTipoMedicacao() {
		return tipoMedicacao;
	}
	
}
