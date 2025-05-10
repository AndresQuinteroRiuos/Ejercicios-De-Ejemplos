package com.example.model;

public class Enfermero {
    private int id;
    private String nombre;

    public  Enfermero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "Enfermero: " +  id + " - " + nombre ;
                
    }
}
