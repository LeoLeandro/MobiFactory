/**
 * 
 */
package br.com.powerpet.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.powerpet.util.constantes.TipoRegistroFinanceiro;


/**
 * @author Leonardo
 *
 */
@Entity
@Table(name="registroFinanceiro")
public class RegistroFinanceiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_financas")
	private Integer id;
	
	@Column(nullable=false)
	private TipoRegistroFinanceiro tipoRegistro;
	
	@Column(nullable=false)
	private BigDecimal valor;
	
	@Column(nullable=false)
	private Integer quantidade;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;
}
