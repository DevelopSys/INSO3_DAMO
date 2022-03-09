package com.example.listas.utils;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Juego implements Serializable {

    private String nombre;
    private int imagen;

    public Juego(String nombre, int imagen) {
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
}
