package br.com.constantino.enterprise.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.constantino.enterprise.entities.Produto;

public class ProdutoDAO extends AbstractDAO {		
	
	public void merge(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}
	
	public void deletar(Integer id) {
		Produto produto = this.buscarProdutoPorId(id);
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	public Produto buscarProdutoPorId(Integer id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarListaProdutoPorId(ArrayList<Integer> lista) {
		
		String jpql = "select p from Produto p where p.id IN (:ids)";
		Query query = em.createQuery(jpql, Produto.class);
		query.setParameter("ids", lista);
		
		return query.getResultList();
		
	}

	public List<Produto> getProdutos() {
		String jpql = "select p from Produto p";
		Query query = em.createQuery(jpql, Produto.class);
		return query.getResultList();
	}
}
