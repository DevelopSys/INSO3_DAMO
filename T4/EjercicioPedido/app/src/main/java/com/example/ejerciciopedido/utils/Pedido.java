package com.example.ejerciciopedido.utils;

import java.io.Serializable;

public class Pedido implements Serializable {

    String nombre, hamburguesa,bebida;
    String[] ingredientes;
    int telefono;
    boolean tipoConsumo;


    public Pedido(){}
    public Pedido(String nombre, String hamburguesa, String bebida, String[] ingredientes, int telefono, boolean tipoConsumo) {
        this.nombre = nombre;
        this.hamburguesa = hamburguesa;
        this.bebida = bebida;
        this.ingredientes = ingredientes;
        this.telefono = telefono;
        this.tipoConsumo = tipoConsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHamburguesa() {
        return hamburguesa;
    }

    public void setHamburguesa(String hamburguesa) {
        this.hamburguesa = hamburguesa;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(boolean tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }
}
