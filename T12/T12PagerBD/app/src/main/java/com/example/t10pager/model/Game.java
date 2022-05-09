package com.example.t10pager.model;

import java.io.Serializable;

public class Game implements Serializable {

    private String nombre;
    private int imagen;

    public Game(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Game{" +
                "nombre='" + nombre + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
