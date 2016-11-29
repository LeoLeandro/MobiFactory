/**
 * 
 */
package br.com.powerpet.util.constantes;


/**
 * @author Leonardo
 *
 */
public enum TipoRegistroFinanceiro {

	VENDA ("Venda"),
	COMPRA ("Compra");
	
	private String tipoRegistro;
	
	private TipoRegistroFinanceiro(String tipo) {
		this.setTipoRegistro(tipo);
	}

	/**
	 * @return the tipoRegistro
	 */
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	
}
