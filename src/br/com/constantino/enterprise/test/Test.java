package br.com.constantino.enterprise.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.constantino.enterprise.dao.ProdutoDAO;
import br.com.constantino.enterprise.entities.Produto;

public class Test {

	public static void main(String[] args) {
				
		ArrayList<Integer> ids = new ArrayList<Integer>();
		String[] produtosEscolhidos = new String[3];
				
		produtosEscolhidos[0] = "1";
		produtosEscolhidos[1] = "11";
		produtosEscolhidos[2] = "13";
							
		
		for (String produtoId : produtosEscolhidos) {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Integer id = Integer.parseInt(produtoId);
			ids.add(id);
		}	
		
//		List lista = Arrays.asList(ids);
		
		System.out.println(ids);
	}
}
