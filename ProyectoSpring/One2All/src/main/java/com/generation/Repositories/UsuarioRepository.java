package com.generation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
