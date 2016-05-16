package br.com.constantino.enterprise.dao;

import java.util.List;

import br.com.constantino.enterprise.entities.Rede;

public class RedeDAO extends AbstractDAO {

	public void inserir(Rede rede) {
		em.getTransaction().begin();
		em.persist(rede);
		em.getTransaction().commit();
	}
	
	public List<Rede> buscarPeloCodigo(Integer id) {
		return em.createQuery("select r from Rede r", Rede.class).getResultList();
	}
}
