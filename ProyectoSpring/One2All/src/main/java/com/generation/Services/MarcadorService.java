package com.generation.Services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.Models.Marcador;
import com.generation.Repositories.MarcadorRepository;

@Service
public class MarcadorService {
	@Autowired
	MarcadorRepository marcadorRepository;
	
public void saveMarcador(@Valid Marcador marcador) {
		
		marcadorRepository.save(marcador);
	}
	public List<Marcador> findAll() {
		// TODO Auto-generated method stub
		return marcadorRepository.findAll();
	}
	public Marcador buscarId(Long id) {

		return marcadorRepository.findById(id).get();
	}
	
	public void eliminarPorId(long id) {
		marcadorRepository.deleteById(id);
		
	}

}
