package com.fatec.Produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produtos {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String descricao;
	private String categoria;
	private double custo;
	private int quantidaNoEstoque;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if (descricao == null) {
			throw new IllegalArgumentException("A descricao não pode ser branco");
		} else {
			if (descricao.isBlank()) {
				throw new IllegalArgumentException("A descricao não pode ser branco");
			} else {
				this.descricao = descricao;
			}
		}
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public int getQuantidaNoEstoque() {
		return quantidaNoEstoque;
	}
	public void setQuantidaNoEstoque(int quantidaNoEstoque) {
		this.quantidaNoEstoque = quantidaNoEstoque;
	}
	
}