/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum PorteAnimal {

	PEQUENO (0, "Pequeno"),
	MEDIO (1, "Médio"),
	GRANDE (2, "Grande"),
	GIGANTE (3, "Gigante");
	
	private Integer valor;
	private String descricao;
	
	private PorteAnimal(Integer valor, String descricao) {
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
