package br.com.constantino.enterprise.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.constantino.enterprise.dao.EstabelecimentoDAO;
import br.com.constantino.enterprise.dao.GrupoDAO;
import br.com.constantino.enterprise.dao.RedeDAO;
import br.com.constantino.enterprise.entities.Estabelecimento;
import br.com.constantino.enterprise.entities.Grupo;
import br.com.constantino.enterprise.entities.Rede;
import br.com.constantino.enterprise.utils.Messages;

@ManagedBean
public class EstabelecimentoController {

	private Estabelecimento estabelecimento = new Estabelecimento();
	private List<Grupo> grupos;
	private String botao = "Salvar";

	public EstabelecimentoController() {
		GrupoDAO grupoDAO = new GrupoDAO();
		this.grupos = grupoDAO.listar();
	}
	
	public List<Estabelecimento> getEstabelecimentos() {
		EstabelecimentoDAO dao = new EstabelecimentoDAO();
		return dao.listar();
	}
	
	public void carregarCombo(Estabelecimento estabelecimento) {
		if (estabelecimento.getRede() != null) {
			GrupoDAO grupoDAO = new GrupoDAO();
			RedeDAO redeDAO = new RedeDAO();						
			Integer rede_id = estabelecimento.getRede().getId();
			Rede rede = redeDAO.buscarPeloCodigo(rede_id);
			this.grupos = grupoDAO.retornaListaGrupoOne(rede.getGrupo().getId());
		}
	}
	
	public String editar(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
		this.botao = "Atualizar";
		return "index.xhtml";
	}
	
	public String excluir(Integer id) {
		EstabelecimentoDAO dao = new EstabelecimentoDAO();
		dao.deletar(id);		
		return "listar.xhtml";
	}
	
	public void salva(Estabelecimento estabelecimento) {
		EstabelecimentoDAO dao = new EstabelecimentoDAO();						
		
		if (estabelecimento.getCNPJ().trim().equals(""))			
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "CNPJ é obrigatório.", "CNPJ é obrigatório.");		
		else if (estabelecimento.getNomeFantasia().trim().equals(""))			
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "Nome Fantasia é obrigatório", "Nome Fantasia é obrigatório");		
		else if (estabelecimento.getRazaoSocial().trim().equals(""))			
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "Razão Social é obrigatório", "Razão Social é obrigatório");		
		else if (estabelecimento.getRede() != null && estabelecimento.getGrupo() == null) {			
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "Grupo é obrigatório se a rede for escolhida", "Grupo é obrigatório");			
			carregarCombo(estabelecimento);				
		} else if (estabelecimento.getRede() == null && estabelecimento.getGrupo() == null)			
			Messages.getMessagem(FacesMessage.SEVERITY_ERROR, "Rede é obrigatório", "Rede é obrigatório");		
		else {
			
			if (estabelecimento.getId() == null) {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Estabecimento cadastrado com sucesso.", "Estabecimento cadastrado com sucesso.");
				dao.inserir(estabelecimento);			
			} else {
				Messages.getMessagem(FacesMessage.SEVERITY_INFO, "Estabecimento alterado com sucesso.", "Estabecimento alterado com sucesso.");
				dao.alterar(estabelecimento);
			}
		}
	}
			
	public List<Grupo> getGrupos() {					
		return this.grupos;
	}
	
	public List<Rede> getRedes() {				
		
		RedeDAO redeDAO = new RedeDAO();
		return redeDAO.getRedes();
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getBotao() {
		return botao;
	}

	public void setBotao(String botao) {
		this.botao = botao;
	}
		
}