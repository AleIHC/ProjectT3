package com.generation.Services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.Models.Usuario;
import com.generation.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void guardarUsuario(@Valid Usuario usuario) {
         
        usuarioRepository.save(usuario);
    }



}
