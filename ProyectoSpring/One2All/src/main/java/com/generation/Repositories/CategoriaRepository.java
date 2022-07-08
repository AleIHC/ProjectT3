package com.generation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
