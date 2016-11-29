/**
 * 
 */
package br.com.powerpet.jpa.dao;

import java.util.List;

/**
 * @author Leonardo
 *
 */
public interface IDao<T> {

	void inserir(T entidade);
	void atualizar(T entidade);
	void remover(T entidade);
	T buscarPorID(Class entidade, Integer id);
	List<T> buscarTodos(Class entidade);
	
}
