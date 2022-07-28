package com.generation.services;

import javax.validation.Valid;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void guardarUsuario(@Valid Usuario usuario) {
         
        usuarioRepository.save(usuario);
    }

}
