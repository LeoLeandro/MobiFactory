/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoUsuario {

	CLIENTE (0),
	FUNCIONARIO (1),
	ADMINISTRADOR (2);
	
	private Integer valor;
	
	private TipoUsuario(Integer valor) {
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
