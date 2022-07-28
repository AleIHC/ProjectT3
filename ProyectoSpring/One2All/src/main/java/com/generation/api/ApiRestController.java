package com.generation.api;

import com.generation.models.Marcador;
import com.generation.services.MarcadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api")
public class ApiRestController {
    //inyeccion de dependencia
    @Autowired
    MarcadorService marcadorService;

    //localhost:9080/api/obtener/marcadores
    @RequestMapping("/obtener/marcadores")
    public List<Marcador> obtenerListaMarcadores() {
        List<Marcador> listaMarcadores = marcadorService.findAll();//obtener lista de marcadores
        return listaMarcadores;
    }

    //localhost:9080/api/guardar/marcadores
    @PostMapping(value = "/guardar/marcadores")
    public ResponseEntity<Marcador> guardarMarcador(@RequestBody Marcador marcador){
        marcadorService.saveMarcador(marcador);
        return new ResponseEntity<Marcador>(marcador, HttpStatus.OK);
    }

    //localhost:9080/api/eliminar/{id}
    @PostMapping(value = "/eliminar/{id}")
    public ResponseEntity<Marcador> eliminarMarcador(@PathVariable Long id){
        try{
            marcadorService.eliminarPorId(id);
            return new ResponseEntity<Marcador>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Marcador>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
