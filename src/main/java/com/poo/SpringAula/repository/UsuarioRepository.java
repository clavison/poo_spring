package com.poo.SpringAula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.SpringAula.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
