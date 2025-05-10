package com.example;

public class Producto {

    private String codigo;
    private String nombre;
    private int cantidad;

    public Producto(String codigo, String nombre, int cantidad) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
    }


}
