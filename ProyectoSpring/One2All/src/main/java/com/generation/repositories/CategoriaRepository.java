package com.generation.repositories;

import com.generation.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
