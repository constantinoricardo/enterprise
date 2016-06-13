package br.com.constantino.enterprise.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.constantino.enterprise.entities.Produto;

public class ProdutoDAO extends AbstractDAO {
	
	public void inserir(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	public void alterar(Produto produto) {
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

	public List<Produto> getProdutos() {
		String jpql = "select p from Produto p";
		Query query = em.createQuery(jpql, Produto.class);
		return query.getResultList();
	}
}
