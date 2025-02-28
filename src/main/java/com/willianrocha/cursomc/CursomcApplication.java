package com.willianrocha.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.willianrocha.cursomc.domain.Categoria;
import com.willianrocha.cursomc.domain.Cidade;
import com.willianrocha.cursomc.domain.Cliente;
import com.willianrocha.cursomc.domain.Endereco;
import com.willianrocha.cursomc.domain.Estado;
import com.willianrocha.cursomc.domain.Produto;
import com.willianrocha.cursomc.domain.enums.TipoCliente;
import com.willianrocha.cursomc.repositories.CategoriaRepository;
import com.willianrocha.cursomc.repositories.CidadeRepository;
import com.willianrocha.cursomc.repositories.ClienteRepository;
import com.willianrocha.cursomc.repositories.EnderecoRepository;
import com.willianrocha.cursomc.repositories.EstadoRepository;
import com.willianrocha.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

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
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			Categoria cat1 = new Categoria(null, "Informática");
			Categoria cat2 = new Categoria(null, "Escritório");
			
			Produto p1 = new Produto(null, "Computador", 2000.00);
			Produto p2 = new Produto(null, "Impressora", 209.90);
			Produto p3 = new Produto(null, "Mouse", 29.99);
			
			cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
			cat2.getProdutos().addAll(Arrays.asList(p2));
			
			p1.getCategorias().addAll(Arrays.asList(cat1));
			p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
			p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

			Estado est1 = new Estado(null, "Minas Gerais");
			Estado est2 = new Estado(null, "São Paulo");
			
			Cidade c1 = new Cidade(null, "Uberlândia", est1);
			Cidade c2 = new Cidade(null, "Campinas", est2);
			Cidade c3 = new Cidade(null, "São Paulo", est2);
			
			est1.getCidades().addAll(Arrays.asList(c1));
			est2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
			Cliente cli1 = new Cliente(null, "Maria Silva", "maria@maria.com.br", "000.333.444-11", TipoCliente.PESSOAFISICA);
			cli1.getTelefones().addAll(Arrays.asList("(12) 8888-99999", "(12) 9999-99999"));
			
			Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 2", "Jardim", "34567000", cli1, c1);
			Endereco e2 = new Endereco(null, "Rua Flores", "300", "Apt 2", "Jardim", "11567000", cli1, c2);
			
			cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}