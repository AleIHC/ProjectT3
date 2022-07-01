package com.generation.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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
	private Categoria categoria;//dato que esta asociado a esa columna(instancia auto)

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

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
