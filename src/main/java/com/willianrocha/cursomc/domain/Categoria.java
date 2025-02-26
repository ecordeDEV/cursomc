package com.willianrocha.cursomc.domain;

import java.util.Objects;
import java.io.Serializable;

public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String Nome;
	
	public Categoria() {}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		Nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
