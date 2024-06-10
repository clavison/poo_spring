package com.poo.SpringAula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.SpringAula.model.Cidade;
import com.poo.SpringAula.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByCidade(Cidade c);

}
