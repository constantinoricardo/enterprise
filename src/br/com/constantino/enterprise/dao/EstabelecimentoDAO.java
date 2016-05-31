package br.com.constantino.enterprise.dao;

import java.util.List;

import br.com.constantino.enterprise.entities.Estabelecimento;

public class EstabelecimentoDAO extends AbstractDAO {

	public void inserir(Estabelecimento estabelecimento) {
		em.getTransaction().begin();
		em.persist(estabelecimento);
		em.getTransaction().commit();
	}
	
	public List<Estabelecimento> listar() {
		return this.em.createQuery("select e from Estabelecimento e", Estabelecimento.class).getResultList();
	}
	
}
