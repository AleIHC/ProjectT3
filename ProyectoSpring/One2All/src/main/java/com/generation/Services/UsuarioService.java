package com.generation.Services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.Models.Usuario;
import com.generation.Repositories.UsuarioRepository;
//import org.springframework.security.crypto.bcrypt.BCrypt;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void guardarUsuario(@Valid Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    /*public boolean saveUsuario(Usuario usuario) {
		Usuario existeUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
		//Si no existe, lo creamos
		if(existeUsuario == null) {
			
			String passEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			usuario.setPassword(passEncriptado);
			
			usuarioRepository.save(usuario);
			return false;
		}// Si existe retornamos un boolean true
		else {
			return true;
		}
    }
    
        public boolean validarUsuario(String correo, String password) {
            /**Validaciones del service**/
            
            //Verificar email
            /*boolean error = true;
            Usuario existeUsuario = usuarioRepository.findByCorreo(correo);
            if(existeUsuario == null) { //Si usuario es igual a null, no existe, es un error de ingreso
                error = true;
            } else {//Verificar password contra password con datos encriptados
                if(BCrypt.checkpw(password, existeUsuario.getPassword())) {
                    //Password y email iguales a los encriptados
                    error =false;
                } else {
                    error = true;
                }
            }
            return error;
        }*/



}
