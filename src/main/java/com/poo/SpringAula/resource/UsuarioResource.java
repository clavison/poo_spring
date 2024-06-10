package com.poo.SpringAula.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.SpringAula.model.Cidade;
import com.poo.SpringAula.model.Usuario;
import com.poo.SpringAula.services.CidadeService;
import com.poo.SpringAula.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	CidadeService cidadeService;
	
	@GetMapping
	public List<Usuario> listaTodos(){
		return service.listaTodosUsuarios();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorCodigo(@PathVariable Integer id){
		return service.buscaPorCodigo(id);
	}
	
	@GetMapping("/cidade/{id}")
	public List<Usuario> buscarPorCidade(@PathVariable Integer id){
		Cidade c = cidadeService.buscaPorCodigo(id);
		return service.listaPorCidade(c);
	}
	
	@PostMapping
	public Usuario cadastra(@RequestBody Usuario u) {
		return service.insereUsuario(u);
	}
	
	@PutMapping("/{id}")
	public Usuario altera(@PathVariable Integer id, @RequestBody Usuario u) {
		Usuario antigo = service.buscaPorCodigo(id);
		antigo.setNome(u.getNome());
		antigo.setCidade(u.getCidade());
		return service.alteraUsuario(antigo);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathVariable Integer id) {
		Usuario antigo = service.buscaPorCodigo(id);
		service.excluiUsuario(antigo);
	}

}
