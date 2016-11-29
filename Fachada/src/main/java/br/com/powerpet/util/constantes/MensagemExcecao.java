/**
 * 
 */
package br.com.powerpet.util.constantes;

/**
 * @author Leonardo
 *
 */
public enum MensagemExcecao {
	
	USUARIO_INVALIDO (TipoMensagem.ERRO.getTipoMensagem() + ": O usuário está nulo!"),
	NOME_USUARIO_NULO_OU_INVALIDO (TipoMensagem.ERRO.getTipoMensagem() + ": O nome do usuário está nulo ou inválido!"),
	SENHA_USUARIO_NULA_OU_INVALIDA (TipoMensagem.ERRO.getTipoMensagem() + ": A senha do usuário está nula ou inválida"),
	SENHA_MENOR_LIMITE_MINIMO (TipoMensagem.ERRO.getTipoMensagem() + ": A senha não deve ter menos de " + PossiveisValores.LIMITE_MINIMO_SENHA + " caracteres!"),
	SENHA_MAIOR_LIMITE_MAXIMO (TipoMensagem.ERRO.getTipoMensagem() + ": A senha não deve ter mais de " + PossiveisValores.LIMITE_MAXIMO_SENHA + " carateres!"),
	EMAIL_USUARIO_NULO_OU_INVALIDO (TipoMensagem.ERRO.getTipoMensagem() + ": O email do usuário está nulo ou inválido"),
	FORMATO_EMAIL_USUARIO_INVALIDO (TipoMensagem.ERRO.getTipoMensagem() + ": O formato do email está incorreto!"),
	USUARIO_INEXISTENTE (TipoMensagem.ERRO.getTipoMensagem() + ": O usuário procurado não existe!");
	
	private String mensagem;
	
	MensagemExcecao(String msg) {
		this.setMensagem(msg);
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
