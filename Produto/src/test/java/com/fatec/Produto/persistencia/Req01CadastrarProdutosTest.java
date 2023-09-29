package com.fatec.Produto.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.Produto.model.Produtos;
import com.fatec.Produto.model.ProdutosRepository;
@SpringBootTest
class Req01CadastrarProdutosTest {
	@Autowired
	ProdutosRepository repository;
	@Test
	void cdt01_Cadastrar_produto_com_sucesso() {
		//dado que nao existe nenhum registro cadastrado
		repository.deleteAll();
		//quando o usuario cadastra um produto
		Produtos produto = new Produtos();
		produto.setDescricao("Eletrobomba 110v para maquina de lavar");
		produto.setCategoria("maquina de lavar");
		produto.setCusto(51.66);
		produto.setQuantidaNoEstoque(10);
		Produtos p = repository.save(produto);
		//entao o produto fica disponivel para consulta
		assertEquals(1, repository.count());
		assertNotNull (p);
	}
	@Test
	void ct02_cadastrar_produto_com_descricao_invalida() {
		try {
			Produtos produto = new Produtos();
			produto.setDescricao("");
			fail("Deveria deparar uma exception");
		}catch(IllegalArgumentException e) {
			assertEquals("A descricao não pode ser branco", e.getMessage());
		}
	}

}
