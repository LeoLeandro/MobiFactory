/**
 * 
 */
package br.com.powerpet.jpa.teste;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import br.com.powerpet.jpa.dao.impl.ClienteDaoImpl;
import br.com.powerpet.jpa.dao.impl.EnderecoDaoImpl;
import br.com.powerpet.jpa.dao.impl.TelefoneDaoImpl;
import br.com.powerpet.jpa.entidades.Animal;
import br.com.powerpet.jpa.entidades.Cliente;
import br.com.powerpet.jpa.entidades.Endereco;
import br.com.powerpet.jpa.entidades.Telefone;
import br.com.powerpet.util.constantes.PorteAnimal;
import br.com.powerpet.util.constantes.TipoAnimal;
import br.com.powerpet.util.constantes.TipoPessoa;
import br.com.powerpet.util.constantes.TipoSanguineo;

/**
 * @author Leonardo
 *
 */
public class PessoaDaoTest {

	private TelefoneDaoImpl telefoneDao = new TelefoneDaoImpl();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	private EnderecoDaoImpl enderecoDao = new EnderecoDaoImpl();
	
	@Test
	public void test() {
		this.testarInsersao();
	}

	private boolean testarInsersao() {
		
		Cliente pessoa = new Cliente();
		
		pessoa.setNome("Leonardo");
		pessoa.setTipoPessoa(TipoPessoa.FISICA);
		pessoa.setDocumento("07417614400");
		pessoa.setDataNascimento(new Date());
		pessoa.setTemPendencia(false);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Capitão Aurélio de Araújo");
		endereco.setNumero(380);
		endereco.setComplemento("Apto 502 C");
		endereco.setBairro("Iputinga");
		endereco.setCEP("50731230");
		endereco.setCidade("Recife");
		endereco.setEstado("PE");
		
		pessoa.setEndereco(endereco);
		
		Telefone telefone = new Telefone();
		telefone.setDDD(81);
		telefone.setNumero(985061693);
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);
		pessoa.setTelefones(telefones);
		
		Animal pet_1 = new Animal();
		pet_1.setNome("bruce");
		pet_1.setDataNascimento(new Date());
		pet_1.setDono(pessoa);
		pet_1.setEspecie("vira-lata");
		pet_1.setFotos(null);
		pet_1.setIdade(5);
		pet_1.setPedrigree("sei lá");
		pet_1.setPelagem("marrom");
		pet_1.setPorte(PorteAnimal.GRANDE);
		pet_1.setSexo("masculino");
		pet_1.setTipo(TipoAnimal.CACHORRO);
		pet_1.setTipoSanguineo(TipoSanguineo.O);
		
		ArrayList<Animal> pets = new ArrayList<Animal>();
		pets.add(pet_1);
		
		pessoa.setPets(pets);
		
		enderecoDao.inserir(endereco);
//		clienteDao.inserir(pessoa);
		
		this.enderecoDao.fecharConexao();
		
		return true;
	}
	
}
