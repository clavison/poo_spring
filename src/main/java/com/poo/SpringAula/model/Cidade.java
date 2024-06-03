package com.poo.SpringAula.model;

public class Cidade {
	
	private int id;
	private String nome;
	private String Uf;
	
	@Override
	public String toString() {
		return getNome()+"("+getUf()+")";
	}
	
	public Cidade() {
		
	}
	
	public Cidade(int id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		Uf = uf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return Uf;
	}
	public void setUf(String uf) {
		Uf = uf;
	}
	
	

}
