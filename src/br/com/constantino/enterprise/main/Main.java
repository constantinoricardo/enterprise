package br.com.constantino.enterprise.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//

public class Main {
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprisedatabase");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Tables this database created!!!");
		
	}

}
