package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
