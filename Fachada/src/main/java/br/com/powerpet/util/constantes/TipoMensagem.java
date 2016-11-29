/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoMensagem {

	ERRO ("ERRO"),
	ALERTA ("ALERTA"),
	SUCESSO ("SUCESSO");
	
	private String tipoMensagem;
	
	private TipoMensagem(String tipo) {
		this.setTipoMensagem(tipo);
	}

	/**
	 * @return the tipoMensagem
	 */
	public String getTipoMensagem() {
		return tipoMensagem;
	}

	/**
	 * @param tipoMensagem the tipoMensagem to set
	 */
	public void setTipoMensagem(String tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}
}
