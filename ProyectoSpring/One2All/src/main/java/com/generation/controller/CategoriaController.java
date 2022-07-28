package com.generation.controller;

import javax.validation.Valid;

import com.generation.models.Categoria;
import com.generation.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;

    @RequestMapping("")
    public String registro(@ModelAttribute("categoria") Categoria categoria){
        return "registrarCategoria.jsp"; //ruta para desplegar jsp, pasamos objeto categoria vacío al form
    }

    @PostMapping("/registro")
    public String registrarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria,
    BindingResult resultado,Model model) {
        
        if(resultado.hasErrors()){
            model.addAttribute("msgErrorCategoria", "Ingrese una categoría válida");
            return "registrarCategoria.jsp";
        }

        else{

            categoriaService.guardarCategoria(categoria);
            return "redirect:/marcador";            }
    }


    /*public String enviarAMarcador(@ModelAttribute("categoria") Categoria categoria,
    @ModelAttribute("categoria") categoria categoria,
    @ModelAttribute("marcador") Marcador marcador){

        return "marcador.jsp";
    }*/
}



