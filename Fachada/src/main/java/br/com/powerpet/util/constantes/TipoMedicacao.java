/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoMedicacao {

	VERMIFUGO (0, "Vermifugo"),
	VACINA (1, "Vacina"),
	ANTICONCEPCIONAL (2, "Anticoncepcional"),
	ANTIPULGAS (3, "Antipulga");
	
	private Integer valor;
	private String descricao;
	
	private TipoMedicacao(Integer valor, String descricao) {
		this.setValor(valor);
		this.setDescricao(descricao);
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
