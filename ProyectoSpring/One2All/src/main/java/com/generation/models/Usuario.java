package com.generation.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, max=20)
	private String nombreUsuario;
	@Size(min=6)
	private String password;
	@Size(min=3, max=20)
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", correo="
				+ correo + "]";
	}
	
	
}
