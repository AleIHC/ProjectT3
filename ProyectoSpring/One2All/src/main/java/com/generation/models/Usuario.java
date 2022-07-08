package com.generation.models;

import javax.persistence.*;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=6,max = 20)
	private String nombreUsuario;

	@Size(min=6)
	@NotNull
	private String password;

	@Size(min=9,max = 20)
	private String correo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tablero_id")//nombre de la columna
	private Tablero tablero;//dato que esta asociado a esa columna(instancia tablero)

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datoPersonal_id")//nombre de la columna
	private DatoPersonal datoPersonal;//dato que esta asociado a esa columna(instancia datoPersonal)

	//ManyToMany UsuariosCategorias
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "usuarios_categorias",//nombre tabla relacional
			joinColumns = @JoinColumn(name="usuario_id"),//desde la entidad actual
			inverseJoinColumns = @JoinColumn(name = "categoria_id")//la otra entidad o tabla
	)
	private List<Categoria> categorias;

	@ManyToMany(mappedBy = "usuarios",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Marcador> marcadores;

	public Usuario() {
		super();
	}
	public Usuario(Long id, @Size(min = 3, max = 20) String nombreUsuario, @Size(min = 6) String password,
			@Size(min = 3, max = 20) String correo) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.correo = correo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}

	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Marcador> getMarcadores() {
		return marcadores;
	}

	public void setMarcadores(List<Marcador> marcadores) {
		this.marcadores = marcadores;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", correo="
				+ correo + "]";
	}
	
	
}
