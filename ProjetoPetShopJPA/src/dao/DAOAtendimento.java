
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Servico;
import modelo.Produto;
import modelo.Raca;


public class DAOAtendimento extends DAO<Atendimento>{
	//Leitura POR id 
	public Atendimento read (Object chave) {
		try {
			Integer id = (Integer) chave;
			Query q = manager.createQuery("select c from Atendimento c where c.id= "+ id + "");
			return (Atendimento) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<Atendimento> readAll () {
		try {
			Query q = manager.createQuery("select a from Atendimento a");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	// CONSULTAS 
	
	public ArrayList<Cliente> consultarClientesQueTenhamCompradoProdutoEServico(String nomeProd, String nomeServ) {
		try {
			Query prod = manager.createQuery("select pro.id from Produto pro "+
												"where pro.nome ='"+ nomeProd + "'");
			
			Query serv = manager.createQuery("select serv.id from Servico serv "+
												"where serv.nome ='"+ nomeServ + "'");			
			
			Query q = manager.createQuery(
										"select ate from Atendimento ate" + 
										" join Animal an" + 
										" on an.id = ate.animal.id" + 
										" join Cliente cl" + 
										" on cl.id = an.cliente.id"+
										" where '" + serv.getSingleResult() + "' = (select serv.id from Servico serv)");
//										" where '" + serv.getSingleResult() + "' = (select serv.id from Servico serv where '"+ serv.getSingleResult() +"'= serv.id)");
			
			
			
			Query cli = manager.createQuery(
											"select cli from Cliente cli "+
											"join Animal ani "+
											"on ani.cliente.id = cli.id "+
											"join Atendimento ate "+
											"on ate.animal.id = ani.id");
						
//			Query ate = manager.createQuery(
//										"select ate from Atendimento ate" + 
//										" join Animal an" + 
//										" on an.id = ate.animal.id" + 
//										" join Cliente cl" + 
//										" on cl.id = an.cliente.id");
			
			
			
			System.out.println("PROD AQUIIII "+prod.getSingleResult());
			System.out.println("SERV AQUIIII "+serv.getSingleResult());
			
			System.out.println("ESSE AQUIIII "+q.getResultList());
			
//			int id_serv = (int) serv.getSingleResult();
//			
//			List<Atendimento> list_aten = ate.getResultList();
//			for (Atendimento at : list_aten) {
//				Servico at_ser = at.getServicos().get(id_serv);
//			}
			
			return (ArrayList<Cliente>) cli.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
//	public ArrayList<Cliente> consultarClientesPorServicoOuProduto(String nome) {
//		
//
//		
//		Query q1 = manager.query();
//		Query q2 = manager.query();
//		q1.constrain(Atendimento.class);
//		q2.constrain(Atendimento.class);
//		q1.descend("servicos").descend("nome").constrain(nome);
//		q2.descend("produtos").descend("nome").constrain(nome);
//		if (!q1.execute().isEmpty()) {
//			List<Atendimento> resultados = q1.execute();
//			ArrayList<Cliente> clientes = new ArrayList<>();
//			for(Atendimento aten : resultados) {
//				clientes.add(aten.getAnimal().getCliente()); 
//			}
//			return clientes;
//		}else {
//			List<Atendimento> resultados = q2.execute();
//			ArrayList<Cliente> clientes = new ArrayList<>();
//			for(Atendimento aten : resultados) {
//				clientes.add(aten.getAnimal().getCliente()); 
//			}
//			return clientes;
//		}
//	}
	
//	public String consultarRacaConsumiuProduto(String nomeProduto, String nomeServico) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("produtos").descend("nome").constrain(nomeProduto);
//		q.descend("servicos").descend("nome").constrain(nomeServico);
//		List<Atendimento> resultados = q.execute();
//		String texto = "";
//		for (Atendimento atendimento : resultados) {
//			texto += atendimento.getAnimal().getRaca().getDescricao() + " | ";
//		}
//		return ""+ texto;
//	}
//
//	
//	
//	public ArrayList<Cliente> consultarClientesPorProduto(String nome) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("produtos").descend("nome").constrain(nome);
//		List<Atendimento> resultados = q.execute();
//		ArrayList<Cliente> clientes = new ArrayList<>();
//		for(Atendimento aten : resultados) {
//			clientes.add(aten.getAnimal().getCliente()); 
//		}
//		return clientes;
//	}
//	

	
//	public double consultarValorAtendimento(int id) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("cod").constrain(id);
//		List<Atendimento> atendimentos = q.execute();	//retorna uma lista com a quantidade de elementos iguais a consulta
//		Atendimento aten = atendimentos.get(0);
//		return aten.getPrecoTotal();
//	}
//	
//	public Atendimento consultarClienteMaisConsumiu() {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("precoTotal").orderDescending();
//		List<Atendimento> atendimentos = q.execute();
//		return atendimentos.get(0);
//	}
//	
//	public ArrayList<Cliente> consultarClientesPorServico(String nome) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("servicos").descend("nome").constrain(nome);
//		List<Atendimento> resultados = q.execute();
//		ArrayList<Cliente> clientes = new ArrayList();
//		for(Atendimento aten : resultados) {
//			clientes.add(aten.getAnimal().getCliente()); 
//		}
//		return clientes;
//	}
//	
//	public List<Atendimento> consultarClientesPorServicoEProduto(String serv, String prod) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("servicos").descend("nome").constrain(serv);
//		q.descend("produtos").descend("nome").constrain(prod);
//		List<Atendimento> resultados = q.execute();
//		return resultados;
//	}
//		
//	public int consultarUltimoAtendimento() {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		List<Atendimento> resultados = q.execute();	
//		if (resultados.size()>0)
//			return resultados.get(resultados.size()-1).getCod();
//		else
//			return 0;
//	}
//	
//	public List<Atendimento> consultarAtendimentoQuantidadeProdutos(int qtd){
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.constrain(new Filtro(qtd));
//		List<Atendimento> result = q.execute();
//		return result;
//
//	}

	
}

//@SuppressWarnings("serial")
//class Filtro  implements Evaluation {
//	private int n;
//	public Filtro (int n) {this.n=n;}
//	public void evaluate(Candidate candidate) {
//		Atendimento aten = (Atendimento) candidate.getObject();
//		candidate.include(aten.getProdutos().size() >= n);
//	}
//}
