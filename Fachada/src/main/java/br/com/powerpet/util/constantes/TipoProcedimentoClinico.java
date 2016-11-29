/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum TipoProcedimentoClinico {

	ANAMNESE (0, "Anamnese"),
	DIAGNOSTICO (1, "Diagnóstico"),
	RECEITUARIO (2, "Receituário"),
	LAUDO_CLINICO (3, "Laudo Clínico"),
	EXAMES (4, "Exames"),
	CIRURGIA (5, "Cirurgia"),
	MEDICACAO (6, "Medicação");
	
	private Integer valor;
	private String descricao;
	
	private TipoProcedimentoClinico(Integer valor, String descricao) {
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
