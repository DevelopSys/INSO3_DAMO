package com.example.t9fragments.utils;

public class Juego {

    private String nombre, desarrollador;

    public Juego(String nombre, String desarrollador) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
