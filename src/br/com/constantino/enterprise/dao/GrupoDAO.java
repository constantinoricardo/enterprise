package br.com.constantino.enterprise.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.constantino.enterprise.entities.Grupo;

public class GrupoDAO extends AbstractDAO {
	
	public List<Grupo> listar() {
		return em.createQuery("select g from Grupo g", Grupo.class).getResultList();
	}
	
	public List<Grupo> retornaListaGrupoOne(Integer id) {
		System.out.println(id);
		String jpql = "select g from Grupo g where g.id = :id";
		Query query = this.em.createQuery(jpql, Grupo.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public Grupo pegaGrupoPorId(Integer id) {
		return em.find(Grupo.class, id);
	}
	
	public void remover(Integer id) {
		Grupo grupo = this.pegaGrupoPorId(id);
		
		em.getTransaction().begin();
		em.remove(grupo);
		em.getTransaction().commit();
	}
	
	public void inserir(Grupo grupo) {
		em.getTransaction().begin();
		em.persist(grupo);
		em.getTransaction().commit();
	}
	
	public void alterar(Grupo grupo) {
		em.getTransaction().begin();
		em.merge(grupo);
		em.getTransaction().commit();
	}
}
