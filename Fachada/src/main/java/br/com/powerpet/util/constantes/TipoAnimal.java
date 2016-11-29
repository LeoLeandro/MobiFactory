/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoAnimal {

	CACHORRO (0, "Cachorro"),
	GATO (1, "Gato"),
	OUTRO (2, "Outro");	
	
	private Integer valor;
	private String descricao;
	
	private TipoAnimal(Integer valor, String descricao) {
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
