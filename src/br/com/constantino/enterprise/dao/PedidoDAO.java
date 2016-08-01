package br.com.constantino.enterprise.dao;

import br.com.constantino.enterprise.entities.Pedido;

public class PedidoDAO extends AbstractDAO {

	public void merge(Pedido pedido) {
		em.getTransaction().begin();
		em.merge(pedido);
		em.getTransaction().commit();
	}
}
