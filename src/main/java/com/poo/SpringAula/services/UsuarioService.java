package com.poo.SpringAula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.SpringAula.model.Usuario;
import com.poo.SpringAula.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public Usuario insereUsuario(Usuario u) {
		return repository.save(u);
	}
	
	public Usuario alteraUsuario(Usuario u) {
		return repository.save(u);
	}
	
	public Usuario buscaPorCodigo(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public void excluiUsuario(Usuario u) {
		repository.delete(u);
	}
	
	public List<Usuario> listaTodosUsuarios(){
		return repository.findAll();
	}

}
