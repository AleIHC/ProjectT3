package com.generation.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //OneToMany Marcadores
    @OneToMany(mappedBy ="categoria",cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<Marcador> marcadores;

    //ManyToMany UsuariosCategorias
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_categorias",//nombre tabla relacional
            joinColumns = @JoinColumn(name = "categoria_id"),//desde la entidad actual
            inverseJoinColumns = @JoinColumn(name = "usuario_id")//la otra entidad o tabla
    )
    private List<Usuario> usuarios;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    //Constructor vacio
    public Categoria() {
    }

    //Constructor con parametros

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Marcador> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(List<Marcador> marcadores) {
        this.marcadores = marcadores;
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
