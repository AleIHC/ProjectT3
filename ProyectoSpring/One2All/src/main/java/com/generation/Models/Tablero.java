/*package com.generation.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tableros")
public class Tablero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String fuentes;

    @OneToMany(mappedBy ="tablero",cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
    private List<Usuario> usuarios;

    @Column(updatable= false)
    private Date createdAt;
    private Date updatedAt;

    public Tablero() {
    }

    public Tablero(String color, String fuentes) {
        this.color = color;
        this.fuentes = fuentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuentes() {
        return fuentes;
    }

    public void setFuentes(String fuentes) {
        this.fuentes = fuentes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

*/