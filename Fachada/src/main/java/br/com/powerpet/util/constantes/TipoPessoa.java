/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoPessoa {

	FISICA (0),
	JURIDICA (1);

	private Integer valor;

	TipoPessoa(Integer valor) {
		this.setValor(valor);
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
}
