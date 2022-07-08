package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import com.generation.models.Categoria;
import com.generation.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    
    public void guardarCategoria(@Valid Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

}
