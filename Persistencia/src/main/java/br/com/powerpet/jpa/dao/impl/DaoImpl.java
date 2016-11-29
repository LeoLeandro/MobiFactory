/**
 * 
 */
package br.com.powerpet.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.powerpet.jpa.dao.IDao;

/**
 * @author Leonardo
 * @param <T>
 *
 */
public class DaoImpl<T> implements IDao<T> {

	private EntityManager entityManager;
	private EntityManagerFactory factory; 

	private void criar() {
		this.factory = Persistence.createEntityManagerFactory("MiAu");
		this.entityManager = this.factory.createEntityManager();
		this.entityManager.getTransaction().begin();
	}

	private void commit() {
		this.entityManager.getTransaction().commit();
	}
	
	public void fecharConexao() {
		this.entityManager.close();
		this.factory.close();
	}

	public void inserir(T entidade) {
		this.criar();
		this.entityManager.persist(entidade);
		this.commit();
	}

	public void atualizar(T entidade) {
		this.criar();
		this.entityManager.merge(entidade);
		this.fecharConexao();
	}

	public void remover(T entidade) {
		this.criar();
		this.entityManager.remove(entidade);
		this.fecharConexao();
	}

	@SuppressWarnings("unchecked")
	public T buscarPorID(Class entidade, Integer id) {
		this.criar();
		T objeto = (T) this.entityManager.find(entidade, id);
		this.fecharConexao();
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public T buscarPor(Class entidade, Object chave) {
		this.criar();
		T objeto = (T) this.entityManager.find(entidade, chave);
		this.fecharConexao();
		return objeto;
	}

	public List<T> buscarTodos(Class entidade) {
		this.criar();
		
		Query query = this.entityManager.createQuery("SELECT e FROM " + 
				entidade.getSimpleName().toString() + " e");

		return (List<T>) query.getResultList();
	}

}
