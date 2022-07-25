package com.generation.models;


import javax.persistence.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")//nombre de la columna
	@JsonBackReference
	private Categoria categoria;//dato que esta asociado a esa columna(instancia auto)

	//ManyToMany
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="usuarios_marcadores", //nombre de tabla relacional
			joinColumns = @JoinColumn(name="usuario_id"), //desde a entidad actual
			inverseJoinColumns = @JoinColumn(name="marcador_id") //desde la otra entidad
	)
	private List<Usuario> usuarios;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
