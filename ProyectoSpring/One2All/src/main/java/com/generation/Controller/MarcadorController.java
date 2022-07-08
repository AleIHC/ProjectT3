package com.generation.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.Models.Categoria;
import com.generation.Models.Marcador;
import com.generation.Services.CategoriaService;
import com.generation.Services.MarcadorService;

@Controller
@RequestMapping("/marcador")
public class MarcadorController {
	
	@Autowired
	MarcadorService marcadorService;


	@Autowired
	CategoriaService categoriaService;
	
	// Pasamos un Marcador vacio al form del marcador.jsp
		@RequestMapping("")
		public String auto(@ModelAttribute("marcador") Marcador marcador,Model model) {

			//Creamos lista de categorias disponibles
			List<Categoria> listaCategorias = categoriaService.findAll();

			//Pasamos atributo "listaCategorias" al marcador.jsp
            model.addAttribute("listaCategorias", listaCategorias);
			return "marcador.jsp";
		}
		@PostMapping("/guardar")
		public String guardarMarcador(@ModelAttribute("marcador") Marcador marcador, 
		BindingResult resultado, Model model) {
			// capturamos si existe un ingreso de error en los datos
			if (resultado.hasErrors()) {
				model.addAttribute("msgError", "Ingrese todos los datos");
				return "marcador.jsp";
			} 
			else {

				// enviar el objeto al service
				marcadorService.saveMarcador(marcador);
				// obtener una lista de marcadores y categorias
				List<Categoria> listaCategorias =categoriaService.findAll();
				List<Marcador> listaMarcadores= marcadorService.findAll();

				// pasamos la lista de marcadores al mostrarMarcadores.jsp
				model.addAttribute("marcadoresCapturados", listaMarcadores);
				model.addAttribute("categoriasCapturadas", listaCategorias);
				return "mostrarMarcadores.jsp";// página a desplegar

			}

		}
		
		// En esta ruta solo se muestran los marcadores registrados en la base de datos
		@RequestMapping("/mostrar")
		public String mostrar(Model model) {
			// obtener una lista de marcadores y de categorias
			List<Categoria> listaCategorias =categoriaService.findAll();
			List<Marcador> listaMarcadores = marcadorService.findAll();
			// pasamos estas listas al mostrarMarcadores.jsp
			model.addAttribute("marcadoresCapturados", listaMarcadores);
			model.addAttribute("categoriasCapturadas", listaCategorias);
			return "mostrarMarcadores.jsp";
		}
		
		@RequestMapping("/editar/{id}")//editar para despliegue de todos los marcadores
		public String editar(@PathVariable("id") Long id, Model model) {
			System.out.println("el id es:" + id);
			Marcador marcador= marcadorService.buscarId(id);
			model.addAttribute("marcador", marcador);
			return "editarMarcador.jsp";//redireccionar a otra url
		}
		
		//actualizar para la persistencia en BD
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
		
		//Eliminar Marcador
		@RequestMapping("/eliminar/{id}")
		public String eliminarMarcador (@PathVariable("id")long id) {
		
		marcadorService.eliminarPorId(id);
	
		return "redirect:/marcador/mostrar";
		
		
		}

		@PostMapping("/buscar")
		public String buscar(@RequestParam(value = "id") Integer id,Model model){
			
			List<Marcador> listaMarcadores = marcadorService.buscarCategoria(id);
			model.addAttribute("marcadoresCapturados", listaMarcadores);

			return "mostrarMarcadores.jsp";

		}

}