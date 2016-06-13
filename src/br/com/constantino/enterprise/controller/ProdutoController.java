package br.com.constantino.enterprise.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.constantino.enterprise.dao.ProdutoDAO;
import br.com.constantino.enterprise.entities.Produto;
import br.com.constantino.enterprise.utils.Messages;

@ManagedBean
public class ProdutoController {
	
	private Produto produto = new Produto();
	private String botao = "Salvar";
	private List<Produto> produtos;
	
	public void salva(Produto produto) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		if (produto.getNome().trim().equals("")) {
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "O nome do produto é obrigatório!", "Produto");
		} else if (produto.getPreco() == null) {
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "O preço do produto é obrigatório", "Preço");
		} else {
			
			if (produto.getId() == null) {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso!", "Preço");
				dao.inserir(produto);
			} else {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Produto alterado com sucesso!", "Preço");
				dao.alterar(produto);
			}
			
		}		
	}
	
	public List<Produto> getProdutos() {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.getProdutos();
	}
	
	public String excluir(Integer id) {
		ProdutoDAO dao = new ProdutoDAO();
		dao.deletar(id);
		return "listar.xhtml";
	}
	
	public String editar(Produto produto) {
		this.produto = produto;
		this.botao = "Atualizar";
		return "index.xhtml";
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getBotao() {
		return botao;
	}
	public void setBotao(String botao) {
		this.botao = botao;
	}
	
	

}
