/**
 * 
 */
package br.com.powerpet.dto.pessoa;

import java.util.List;

import br.com.powerpet.dto.util.EnderecoDTO;
import br.com.powerpet.dto.util.IDTO;
import br.com.powerpet.dto.util.TelefoneDTO;
import br.com.powerpet.util.constantes.TipoPessoa;

/**
 * @author Leonardo
 *
 */
public class PessoaDTO implements IDTO {

	private String nome;

	private TipoPessoa tipoPessoa;

	private String documento;

	private List<TelefoneDTO> telefones;

	private EnderecoDTO endereco;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipoPessoa
	 */
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the telefones
	 */
	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	/**
	 * @return the endereco
	 */
	public EnderecoDTO getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
