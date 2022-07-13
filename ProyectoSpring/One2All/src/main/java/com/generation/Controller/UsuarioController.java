package com.generation.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.Models.Categoria;
import com.generation.Models.Marcador;
import com.generation.Models.Usuario;
import com.generation.Services.CategoriaService;
import com.generation.Services.UsuarioService;

@Controller
@RequestMapping("/registro")
public class UsuarioController {

    @Autowired
    UsuarioService  usuarioService;

    @Autowired
    CategoriaService  categoriaService;

    @RequestMapping("")
    public String registro(@ModelAttribute("usuario") Usuario usuario){

        return "registroUsuario.jsp"; //ruta para desplegar jsp, pasamos objeto Usuario vacío al form
    }

    @PostMapping("/usuario")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
    BindingResult resultado,Model model,
    @ModelAttribute("categoria") Categoria categoria) {
        
        if(resultado.hasErrors()){
            model.addAttribute("msgError", "Ingrese datos correctamente");
            return "registroUsuario.jsp";
        }

        else{
            usuarioService.guardarUsuario(usuario);
            model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
            List<Categoria> listaCategorias = categoriaService.findAll();
            model.addAttribute("listaCategorias", listaCategorias.size());
            return "registrarCategoria.jsp";
        }
    }

    @RequestMapping("/usuario/login")
    public String loginUsuario(@RequestParam(value = "correo")String correo,
    @RequestParam(value = "password") String password, 
    Model model, HttpSession session 
    ) {
        //Validar que los parámetros no sean null o vacíos
        if(correo == null || password == null || correo.isEmpty() || password.isEmpty()){
            model.addAttribute("msgError", "Todos los campos son obligatorios");
            return "login.jsp";
        } //Validar que coincida con la BD
        
        boolean usuarioValidado = usuarioService.validarUsuario(correo, password);
        return "";
    }

    /*public String enviarAMarcador(@ModelAttribute("categoria") Categoria categoria,
    @ModelAttribute("usuario") Usuario usuario,
    @ModelAttribute("marcador") Marcador marcador){

        return "marcador.jsp";
    }*/


}
