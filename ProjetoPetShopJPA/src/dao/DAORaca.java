package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Produto;
import modelo.Raca;

public class DAORaca extends DAO<Raca>{
	//Leitura POR nome 
	public Raca read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Raca c where c.nome= '"+ nome + "'");
			return (Raca) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

