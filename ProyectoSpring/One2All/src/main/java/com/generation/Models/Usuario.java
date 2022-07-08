package com.generation.Models;

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

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="usuarios_marcadores", //nombre de tabla relacional 
            joinColumns = @JoinColumn(name="usuario_id"), //desde a entidad actual
            inverseJoinColumns = @JoinColumn(name="marcador_id") //desde la otra entidad
    )
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
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", correo="
				+ correo + "]";
	}
	
	
}
