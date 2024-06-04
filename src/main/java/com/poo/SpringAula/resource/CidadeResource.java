package com.poo.SpringAula.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.SpringAula.model.Cidade;
import com.poo.SpringAula.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	
	@GetMapping
	public List<Cidade> listaTodas(){
		return service.listaTodasCidades();
	}
	
	@GetMapping("/{id}")
	public Cidade buscarPorCodigo(@PathVariable Integer id){
		return service.buscaPorCodigo(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Cidade buscarPorNome(@PathVariable String nome){
		return service.buscaPorNome(nome);
	}
	
	@PostMapping
	public Cidade cadastra(@RequestBody Cidade c) {
		return service.insereCidade(c);
	}

}
