package com.miportfolio.backenddlpf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1 , max = 50, message = "No cumple con la longuitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1 , max = 50, message = "No cumple con la longuitud")
    private String apellido;
    
    @NotNull
    private String descripcionP;
    
    private String img;

    //Constructor

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String descripcionP, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionP = descripcionP;
        this.img = img;
    }
    
    //G&S
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
}