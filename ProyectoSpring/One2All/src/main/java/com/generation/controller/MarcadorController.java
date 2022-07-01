package com.generation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Marcador;
import com.generation.services.MarcadorService;

@Controller
@RequestMapping("/marcador")
public class MarcadorController {
	
	@Autowired
	MarcadorService marcadorService;
	
	// Pasamos un objeto vacio
		@RequestMapping("")
		public String auto(@ModelAttribute("marcador") Marcador marcador) {
			return "marcador.jsp";
		}
		@PostMapping("/guardar")
		public String guardarMarcador(@ModelAttribute("marcador") Marcador marcador, BindingResult resultado, Model model) {
			// capturamos si existe un ingreso de error en los datos
			if (resultado.hasErrors()) {
				model.addAttribute("msgError", "Debe realizar el ingreso de datos");
				return "marcador.jsp";
			} else {
				// capturamos el objeto auto con atributos llenos
				System.out.println(marcador.toString());

				// enviar el objeto al service
				marcadorService.saveMarcador(marcador);
				// obtener una lista de marcadores
				List<Marcador> listaMarcadores= marcadorService.findAll();
				// pasamos la lista de marcadores al jsp
				model.addAttribute("marcadoresCapturados", listaMarcadores);
				return "mostrarMarcadores.jsp";// pagina a desplegar

			}

		}
		
		// mostrar el listado de autos
		@RequestMapping("/mostrar")
		public String mostrar(Model model) {
			// obtener una lista de elefantes
			List<Marcador> listaMarcadores = marcadorService.findAll();
			// pasamos la lista de elefantes al jsp
			model.addAttribute("marcadoresCapturados", listaMarcadores);
			return "mostrarMarcadores.jsp";
		}
		
		@RequestMapping("/editar/{id}")//editar para despliegue de todos los elefantes
		public String editar(@PathVariable("id") Long id, Model model) {
			System.out.println("el id es:" + id);
			Marcador marcador= marcadorService.buscarId(id);
			model.addAttribute("marcador", marcador);
			return "editarMarcador.jsp";//redireccionar a otra url
		}
		
		//localhost:9080/elefante/actualizar/{id} -> actualizar para la persistencia en BD
		@PostMapping("editar/actualizar/{id}")
		public String actualizarMarcador(@PathVariable("id") Long id ,@Valid @ModelAttribute("marcador") Marcador marcador, BindingResult resultado, Model model) {
			System.out.println("EL id a actualizar es:" + id);
			// capturamos si existe un ingreso de error en los datos
			
			if (resultado.hasErrors()) {
				model.addAttribute("msgError", "Debe realizar el ingreso de datos");
				return "editarMarcador.jsp";
			} else {
				// capturamos el objeto auto con atributos llenos
				System.out.println(marcador.toString());

				// enviar el objeto al service
				marcadorService.saveMarcador(marcador);
				// obtener una lista de autos
				List<Marcador> listaMarcadores= marcadorService.findAll();
				// pasamos la lista de autos al jsp
				model.addAttribute("marcadoresCapturados", listaMarcadores);
				return "mostrarMarcadores.jsp";// pagina a desplegar

			}

		}
		
		@RequestMapping("/eliminar/{id}")
		public String eliminarMarcador (@PathVariable("id")long id) {
		
		marcadorService.eliminarPorId(id);
	
		return "redirect:/marcador/mostrar";
		
		
		}

}