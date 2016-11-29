/**
 * 
 */
package br.com.powerpet.util.constantes;


/**
 * @author Leonardo
 *
 */
public enum TipoProduto {

	RACAO ("Ração"),
	ACESSORIO ("Acessório"),
	HIGIENE ("Higiene"),
	MEDICAMENTO ("Medicamento");
	
	private String nomeProduto;
	
	private TipoProduto(String nomeProduto) {
		this.setNomeProduto(nomeProduto);
	}

	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
}
