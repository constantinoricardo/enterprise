package br.com.constantino.enterprise.dao;

import java.util.List;

import br.com.constantino.enterprise.entities.Grupo;

public class GrupoDAO extends AbstractDAO {
	
	public List<Grupo> listar() {
		return em.createQuery("select g from Grupo g", Grupo.class).getResultList();
	}
	
	public void inserir(Grupo grupo) {
		em.getTransaction().begin();
		em.persist(grupo);
		em.getTransaction().commit();
	}
}
