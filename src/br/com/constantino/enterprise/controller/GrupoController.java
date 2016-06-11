package br.com.constantino.enterprise.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.constantino.enterprise.dao.GrupoDAO;
import br.com.constantino.enterprise.entities.Grupo;
import br.com.constantino.enterprise.utils.Messages;

@ManagedBean
public class GrupoController {
	
	private Grupo grupo = new Grupo();	
	private List<Grupo> grupos;
	private String botao = "Salvar";
		
	public List<Grupo> getGrupos() {
		GrupoDAO dao = new GrupoDAO();
		grupos = dao.listar();
		return grupos;
	}

	public void salva(Grupo grupo) {
		GrupoDAO dao = new GrupoDAO();				
		
		if (grupo.getNome().trim().equals("")) {
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "O nome é obrigatório", 
					"Por favor, o nome é de preenchimento obrigatório!");						
		} else {								
			
			if (grupo.getId() == null) {			
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Grupo Cadastrado com sucesso!", "Parabéns");		
				dao.inserir(grupo);
			} else {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Grupo Alterado com sucesso!", "Parabéns");
				dao.alterar(grupo);
			}
		}
	}
	
	public String editar(Grupo grupo) {				
		this.grupo = grupo;	
		this.botao = "Atualizar";
		return "index.xhtml";
	}
	
	public String excluir(Integer id) {
		GrupoDAO dao = new GrupoDAO();
		dao.remover(id);
		return "listar.xhtml";			
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getBotao() {
		return botao;
	}

	public void setBotao(String botao) {
		this.botao = botao;
	}
	
	
	
	
}
