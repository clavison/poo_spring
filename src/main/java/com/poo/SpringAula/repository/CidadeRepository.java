package com.poo.SpringAula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.SpringAula.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	public Cidade findByNome(String nome);
}
