package com.saulusribeiro.controlepedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saulusribeiro.controlepedidos.domain.Categoria;
import com.saulusribeiro.controlepedidos.domain.Cidade;
import com.saulusribeiro.controlepedidos.domain.Cliente;
import com.saulusribeiro.controlepedidos.domain.Endereco;
import com.saulusribeiro.controlepedidos.domain.Estado;
import com.saulusribeiro.controlepedidos.domain.Produto;
import com.saulusribeiro.controlepedidos.domain.enums.TipoCliente;
import com.saulusribeiro.controlepedidos.respositories.CategoriaRepository;
import com.saulusribeiro.controlepedidos.respositories.CidadeRepository;
import com.saulusribeiro.controlepedidos.respositories.ClienteRepository;
import com.saulusribeiro.controlepedidos.respositories.EnderecoRepository;
import com.saulusribeiro.controlepedidos.respositories.EstadoRepository;
import com.saulusribeiro.controlepedidos.respositories.ProdutoRepository;

@SpringBootApplication
public class ControlePedidosBackendApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;



		
	public static void main(String[] args) {
		SpringApplication.run(ControlePedidosBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(1,"Informatica");
		Categoria cat2 = new Categoria(2,"Escritorio");
		
		Produto prod1 = new Produto(null,"Computador",2000.00);
		Produto prod2 = new Produto(null,"Impressora",800.00);
		Produto prod3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
	
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cidade1 = new Cidade(null,"Uberlândia",est1);
		Cidade cidade2 = new Cidade(null,"São Paulo",est2);
		Cidade cidade3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(cidade1));
		est2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(est1 , est2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new 
				Cliente(null,"Maria Silva","maria.silva@gmail.com", "36378912377",TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("32735566","32223434"));
		Endereco end1 = new Endereco(null,"Rua Flores","300","Apto 303","Jardim","38330834",cliente1,cidade1);
		Endereco end2 = new Endereco(null,"Avenida Flores","400","Apto 304","Jardim","38330834",cliente1,cidade2);
		cliente1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}
