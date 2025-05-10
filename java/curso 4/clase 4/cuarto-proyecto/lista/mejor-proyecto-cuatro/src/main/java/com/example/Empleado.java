package com.example;

/**
 * Clase que representa a un empleado con sus datos personales y salariales.
 */
public class Empleado {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final double salario;

    /**
     * Constructor para crear un nuevo empleado.
     *
     * @param nombre   Nombre del empleado
     * @param apellido Apellido del empleado
     * @param edad     Edad del empleado
     * @param salario  Salario del empleado
     */
    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("%s %s - Edad: %d - Salario: %.2f", 
            nombre, apellido, edad, salario);
    }
} 