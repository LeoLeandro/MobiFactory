/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoSanguineo {

	A (0, "A"),
	B (1, "B"),
	AB (2, "AB"),
	O (3, "O"),
	A_NEG (4, "A-"),
	B_NEG (5, "B-"),
	AB_NEG (6, "AB-"),
	O_NEG (7, "0-");
	
	private Integer valor;
	private String descricao;
	
	private TipoSanguineo(Integer valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
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
	
}
