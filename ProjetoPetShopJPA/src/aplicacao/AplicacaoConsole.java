package aplicacao;
import java.time.LocalDate;

import fachada.Fachada;


public class AplicacaoConsole {

	public AplicacaoConsole(){	
		Fachada.inicializar();
		cadastrar();
//		apagar();
//		atualizar();
//		listar();
//		consultar();
		Fachada.finalizar();
	}


	public void cadastrar(){
		try {		
			
			// cadastro raças
			Fachada.cadastrarRaca("rottweiler", "grande", "cachorro");
			Fachada.cadastrarRaca("border collie", "medio", "cachorro");
			Fachada.cadastrarRaca("boxer", "grande", "cachorro");
			Fachada.cadastrarRaca("pug", "pequeno", "cachorro");
			Fachada.cadastrarRaca("persa", "pequeno", "gato");
			
			// cadastro produtos
			Fachada.cadastrarProduto("bravecto", 150.0);
			Fachada.cadastrarProduto("racao pedigree equilibrio natural 3kg", 45.0);
			Fachada.cadastrarProduto("racao pedigree equilibrio natural 1kg", 20.0);
			Fachada.cadastrarProduto("shampoo anti-pulgas", 18.0);
			Fachada.cadastrarProduto("brinquedo anti-stress de borracha", 10.0);
			Fachada.cadastrarProduto("osso grande", 25.0);
						
			// cadastro serviços
			Fachada.cadastrarServico("banho e tosa menor", 48.0);
			Fachada.cadastrarServico("banho e tosa medio", 60.0);
			Fachada.cadastrarServico("banho e tosa maior", 80.0);
			Fachada.cadastrarServico("banho menor", 20.0);
			Fachada.cadastrarServico("banho medio", 35.0);
			Fachada.cadastrarServico("banho maior", 46.0);
			Fachada.cadastrarServico("corte de unhas", 10.0);
			Fachada.cadastrarServico("hospedagem", 50.0);
				
			// cadastro clientes
			Fachada.cadastrarCliente("Renatha Victor", "(83) 98800-0000");
			Fachada.cadastrarCliente("Adriano Amaral", "(83) 98800-0001");
			Fachada.cadastrarCliente("Adriano Ney", "(83) 98800-0002");
			Fachada.cadastrarCliente("Joao Silva", "rua sem nome, 45, mangabeira", "(83) 98811-0000", "joaosilva@email.com");
			Fachada.cadastrarCliente("Maria Silva", "rua qualquer, 145, bancarios", "(83) 98001-0000", "mariasilva@email.com");
			
			// cadastro animais
			Fachada.cadastrarAnimal("Zoe", "border collie");
			Fachada.cadastrarAnimal("Bob", "boxer");
			Fachada.cadastrarAnimal("Pandhora", "rottweiler");
			Fachada.cadastrarAnimal("Smelly cat", "persa");

			// adicionar animal ao cliente
			Fachada.adicionarAnimalDoCliente("Zoe", "Renatha Victor");
			Fachada.adicionarAnimalDoCliente("Bob", "Joao Silva");
			Fachada.adicionarAnimalDoCliente("Smelly cat", "Maria Silva");
			Fachada.adicionarAnimalDoCliente("Pandhora", "Maria Silva");
		
			// criar atendimento
			Fachada.cadastrarAtendimento(LocalDate.now(), "Funcionario1", "Zoe");
			Fachada.cadastrarAtendimento(LocalDate.now(), "Funcionario1", "Bob");
			Fachada.cadastrarAtendimento(LocalDate.now(), "Funcionario2", "Pandhora");
			Fachada.cadastrarAtendimento(LocalDate.now(), "Funcionario3", "Smelly cat");
								
			// adicionar produto ao atendimento
			Fachada.adicionarProdutoAtendimento(1, "bravecto");
			Fachada.adicionarProdutoAtendimento(1, "brinquedo anti-stress de borracha");
			Fachada.adicionarProdutoAtendimento(1, "shampoo anti-pulgas");
			Fachada.adicionarProdutoAtendimento(1, "racao pedigree equilibrio natural 1kg");
			
			Fachada.adicionarProdutoAtendimento(2, "bravecto");
			Fachada.adicionarProdutoAtendimento(2, "shampoo anti-pulgas");
			
			Fachada.adicionarProdutoAtendimento(3, "bravecto");
			Fachada.adicionarProdutoAtendimento(3, "shampoo anti-pulgas");
			Fachada.adicionarProdutoAtendimento(3, "racao pedigree equilibrio natural 1kg");
			
			Fachada.adicionarProdutoAtendimento(4, "bravecto");
			Fachada.adicionarProdutoAtendimento(4, "racao pedigree equilibrio natural 3kg");
			Fachada.adicionarProdutoAtendimento(4, "brinquedo anti-stress de borracha");	
			
			
			// adicionar serviço ao atendimento
			Fachada.adicionarServicoAtendimento(1, "banho e tosa maior");
			Fachada.adicionarServicoAtendimento(1, "corte de unhas");
			Fachada.adicionarServicoAtendimento(1, "hospedagem");
			Fachada.adicionarServicoAtendimento(2, "banho menor");
			Fachada.adicionarServicoAtendimento(2, "hospedagem");
			Fachada.adicionarServicoAtendimento(3, "banho menor");
			Fachada.adicionarServicoAtendimento(4, "banho maior");
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/************************/
	public void atualizar(){
		try {
			Fachada.alterarEnderecoCliente("Joao Silva", "rua qualquer 123");
			
			Fachada.alterarPrecoServico("banho maior", 44.0);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/************************/
	public void apagar(){
		try {
			System.out.println(Fachada.excluirCliente("Adriano Ney"));
			
			System.out.println(Fachada.excluirProduto("racao pedigree equilibrio natural 3kg"));
			
			System.out.println(Fachada.excluirServico("banho e tosa medio"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/************************/
	public void listar(){
		try {
			// listar racas
			System.out.println(Fachada.listarRaca());
			// listar produtos
			System.out.println(Fachada.listarProdutos());
			// listar servicos
			System.out.println(Fachada.listarServicos());
			// listar clientes
			System.out.println(Fachada.listarClientes());
			// listar animais
			System.out.println(Fachada.listarAnimais());		
			// listar atendimento
			System.out.println(Fachada.listarAtendimento());
		} catch (Exception e) {
			System.out.println(e);
		}
	}



	/************************/
	public void consultar(){
		try {
			// Consulta cliente
//			System.out.println(Fachada.consultarClientePorNome("Adriano Amaral"));
//			System.out.println(Fachada.consultarClientePorParteNome("Lucas"));
//			System.out.println(Fachada.consultarClientePorParteNome("Adriano"));
			
			
			// Consulta telefone
//			System.out.println(Fachada.consultarClientePorTelefone("(83) 98800-0000"));
//
//			// Consultar animal do cliente
//			System.out.println(Fachada.consultarAnimaisDoCliente("Maria Silva"));
//			System.out.println(Fachada.consultarAnimaisDoCliente("Renatha Victor"));
//			System.out.println("\n");
//
//			// Consultar cliente do animal
//			System.out.println(Fachada.consultarClienteDoAnimal("Zoe"));
//			System.out.println(Fachada.consultarClienteDoAnimal("Bob"));
//			System.out.println(Fachada.consultarClienteDoAnimal("Pandhora"));
//			System.out.println(Fachada.consultarClienteDoAnimal("Smelly cat"));
//			System.out.println("\n");
//
//			// Consultar valor do atendimento
//			System.out.println(Fachada.consultarValorAtendimento(1));
//			System.out.println(Fachada.consultarValorAtendimento(2));
//			System.out.println(Fachada.consultarValorAtendimento(3));
//			System.out.println(Fachada.consultarValorAtendimento(4));
//			System.out.println("\n");
//
//			System.out.println(Fachada.consultarAtendimentoMaisConsumiu());
			
//			//animais que consumiram mais produtos por atendimento
//			System.out.println(Fachada.consultarClienteMaisConsumiu());
//			System.out.println("\n");
//
//			//clientes que compraram o produto tal
//			System.out.println(Fachada.consultarClientesPorProduto("racao pedigree equilibrio natural 1kg"));
//
//
//			//clientes que compraram o servico tal
//			System.out.println(Fachada.consultarClientesPorServico("banho maior"));
//
//			// servicos do animal
			System.out.println(Fachada.consultarServicoAnimal("Zoe"));
//
//			// clientes que fizerem pedidos com mais de dois produtos
//			System.out.println(Fachada.consultarAtendimentoQuantidadeProdutos(2));
//
//			System.out.println(Fachada.consultarDonoERacaAnimal("bob"));
//
//			// as 3 consultas
//			System.out.println(" === AS TRES CONSULTAS === ");
//			System.out.println(Fachada.consultarClientesQueTenhamCompradoProdutoEServico("bravecto", "banho maior"));

//			System.out.println(Fachada.consultarClientesPorServicoOuProduto("banho menor"));

//			System.out.println(Fachada.consultarRacaConsumiuProduto("bravecto", "banho menor"));

		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new AplicacaoConsole();
	}
	//=================================================

}
