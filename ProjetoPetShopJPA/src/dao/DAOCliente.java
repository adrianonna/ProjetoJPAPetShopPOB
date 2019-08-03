package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fachada.Fachada;
import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Produto;
import modelo.Raca;
import modelo.Servico;


public class DAOCliente  extends DAO<Cliente> {
	//Leitura POR nome 
	public Cliente read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Cliente c where c.nome= '"+ nome + "'");
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
	public List<Cliente> readAll () {
		try {
			Query q = manager.createQuery("select c from Cliente c");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	//CONSULTAS
//	
//	public  String consultarClientePorParteNome(String caracteres) {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		q.descend("nome").constrain(caracteres).like();
//		List<Cliente> result = q.execute(); 
//		
//		String texto = "\nConsultar cliente por parte do nome: "+caracteres;
//		if (result.isEmpty())  
//			texto += "\nConsulta vazia";
//		else 
//			for(Cliente c: result)texto += "\n" + c;
//		return texto;
//	}
//	
//	public String consultarClientePorNome(String nome) {
//		Query q = manager.createQuery("select c from Cliente c where c.nome = '"+ nome + "'");
//		return (String) q.getSingleResult();
//		return "\nConsultar cliente -  nao encontrado";
//	}
//	
//	public  Cliente consultarClientePorNomeObj(String nome) throws  Exception {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		q.descend("nome").constrain(nome);
//		List<Cliente> result = q.execute(); 
//		if (result.size() == 0)
//			throw new Exception("\nConsultar cliente -  nao encontrado");
//		return result.get(0);
//	}
//	
	public Cliente consultarClientePorTelefone(String n) throws  Exception {
		try {
			String telefone = (String) n;
			Query q = manager.createQuery("select c from Cliente c where c.telefone= '"+ telefone + "'");
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
//	
	public ArrayList<Animal> consultarAnimaisDoCliente(String nomeCliente) {
		Query q = manager.createQuery("select a from Animal a "
									+ "join Cliente c on c.id = a.cliente.id "
									+ "where c.nome= '"+ nomeCliente + "'");
		return (ArrayList<Animal>) q.getResultList();
	}
//		
//	public int consultarTotalClientes() {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		int total = q.execute().size(); 
//		return total;
//	}
//	
//	public List<Animal> consultaAnimalPorCliente(String cli) {
//		Query q = manager.query();
//		q.constrain(Animal.class);
//		q.descend("c").constrain(cli); 
//		List<Animal> result = q.execute(); 
//		return result;
//	}
//	
//	public int consultarUltimoIdCliente() {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		List<Cliente> resultados = q.execute();	
//		if (resultados.size()>0) 
//			return resultados.get(resultados.size()-1).getId();
//		else
//			return 0;
//	}

}