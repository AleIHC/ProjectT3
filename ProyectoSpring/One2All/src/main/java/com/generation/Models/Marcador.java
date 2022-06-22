package com.generation.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="marcadores")
public class Marcador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, max=60)
	private String nombreMarcador;
	
	private String urlMarcador;
	
	private String descripcionMarcador;
	
	private int prioridad;

	public Marcador() {
		super();
	}

	public Marcador(Long id, @Size(min = 3, max = 60) String nombreMarcador, String urlMarcador,
			String descripcionMarcador, int prioridad) {
		super();
		this.id = id;
		this.nombreMarcador = nombreMarcador;
		this.urlMarcador = urlMarcador;
		this.descripcionMarcador = descripcionMarcador;
		this.prioridad = prioridad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreMarcador() {
		return nombreMarcador;
	}

	public void setNombreMarcador(String nombreMarcador) {
		this.nombreMarcador = nombreMarcador;
	}

	public String getUrlMarcador() {
		return urlMarcador;
	}

	public void setUrlMarcador(String urlMarcador) {
		this.urlMarcador = urlMarcador;
	}

	public String getDescripcionMarcador() {
		return descripcionMarcador;
	}

	public void setDescripcionMarcador(String descripcionMarcador) {
		this.descripcionMarcador = descripcionMarcador;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	
	
}
