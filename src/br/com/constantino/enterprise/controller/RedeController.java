package br.com.constantino.enterprise.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.constantino.enterprise.dao.GrupoDAO;
import br.com.constantino.enterprise.dao.RedeDAO;
import br.com.constantino.enterprise.entities.Grupo;
import br.com.constantino.enterprise.entities.Rede;
import br.com.constantino.enterprise.utils.Messages;

@ManagedBean
public class RedeController {
	
	private Rede rede = new Rede();	
	private String botao = "Salvar";
	
	public void salva(Rede rede) {		
		RedeDAO dao = new RedeDAO();
		
		if (rede.getNome().trim().equals("")) {
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "O nome é obrigatório", 
					"Por favor, o nome é de preenchimento obrigatório!");	
		}
		else if (rede.getGrupo() == null) {
	    
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "O grupo é obrigatório", 
					"Por favor, o grupo é de preenchimento obrigatório!");
		} else {
			
			if (rede.getId() == null) {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Rede cadastrada com sucesso!!!", "Rede cadastrada.");			
				dao.inserir(rede);
			} else {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Rede alterada com sucesso!!!", "Rede cadastrada.");
				dao.alterar(rede);
			}
		}
	}
	
	public String excluir(Integer id) {
		RedeDAO dao = new RedeDAO();
		dao.deletar(id);
		return "listar.xhtml";
	}
	
	public String editar(Rede rede) {
		this.rede = rede;
		this.botao = "Atualizar";
		return "index.xhtml";
	}
	
	public List<Grupo> getGrupos() {
		GrupoDAO grupoDAO = new GrupoDAO();
		return grupoDAO.listar();
	}
	
	public List<Rede> getRedes() {
		RedeDAO dao = new RedeDAO();
		return dao.getRedes();
	}

	public Rede getRede() {
		return rede;
	}

	public void setRede(Rede rede) {
		this.rede = rede;
	}

	public String getBotao() {
		return botao;
	}

	public void setBotao(String botao) {
		this.botao = botao;
	}

}