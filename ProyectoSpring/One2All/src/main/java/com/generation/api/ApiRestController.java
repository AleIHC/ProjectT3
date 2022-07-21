package com.generation.api;

import com.generation.models.Marcador;
import com.generation.services.MarcadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api")
public class ApiRestController {
    //inyeccion de dependencia
    @Autowired
    MarcadorService marcadorService;

    //localhost:9080/api/marcadores
    @RequestMapping("/marcadores")
    public List<Marcador> obtenerListaMarcadores() {
        List<Marcador> listaMarcadores = marcadorService.findAll();//obtener lista de marcadores
        return listaMarcadores;
    }


}
