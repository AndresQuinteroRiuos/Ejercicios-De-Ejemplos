package com.example;

import java.util.Comparator;
import java.util.List;

class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private double salario;

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
        return nombre + " " + apellido + " - Edad: " + edad + " - Salario: " + salario;
    }
}

/**
 * Clase principal que demuestra el uso de Streams y operaciones con empleados.
 */
public class Main {
    private static final int EDAD_LIMITE = 30;
    private static final int NUMERO_EMPLEADOS = 5;

    /**
     * Método principal que ejecuta las operaciones con empleados.
     */
    public static void main(String[] args) {
        List<Empleado> empleados = crearListaEmpleados();
        
        mostrarEmpleadosOrdenadosPorApellido(empleados);
        mostrarPrimerosNEmpleados(empleados, NUMERO_EMPLEADOS);
        mostrarEmpleadosMayoresDeEdad(empleados, EDAD_LIMITE);
        mostrarPromedioSalarios(empleados);
    }

    /**
     * Crea y retorna una lista de empleados de ejemplo.
     */
    private static List<Empleado> crearListaEmpleados() {
        return List.of(
            new Empleado("Juan", "Pérez", 25, 2500.0),
            new Empleado("María", "García", 30, 3000.0),
            new Empleado("Carlos", "López", 35, 3500.0),
            new Empleado("Ana", "Martínez", 28, 2800.0),
            new Empleado("Pedro", "Sánchez", 32, 3200.0),
            new Empleado("Laura", "Rodríguez", 27, 2700.0),
            new Empleado("Miguel", "Fernández", 40, 4000.0),
            new Empleado("Sofía", "Gómez", 29, 2900.0),
            new Empleado("David", "Díaz", 33, 3300.0),
            new Empleado("Elena", "Ruiz", 31, 3100.0)
        );
    }

    /**
     * Muestra los empleados ordenados por apellido.
     */
    private static void mostrarEmpleadosOrdenadosPorApellido(List<Empleado> empleados) {
        System.out.println("Empleados ordenados por apellido:");
        empleados.stream()
            .sorted(Comparator.comparing(Empleado::getApellido))
            .forEach(System.out::println);
    }

    /**
     * Muestra los primeros N empleados ordenados por apellido.
     */
    private static void mostrarPrimerosNEmpleados(List<Empleado> empleados, int n) {
        System.out.printf("\nPrimeros %d empleados:\n", n);
        empleados.stream()
            .sorted(Comparator.comparing(Empleado::getApellido))
            .limit(n)
            .forEach(e -> System.out.println(e.getApellido() + ", " + e.getNombre()));
    }

    /**
     * Muestra los empleados mayores de una edad específica.
     */
    private static void mostrarEmpleadosMayoresDeEdad(List<Empleado> empleados, int edadLimite) {
        System.out.printf("\nEmpleados mayores de %d años:\n", edadLimite);
        empleados.stream()
            .filter(empleado -> empleado.getEdad() > edadLimite)
            .forEach(System.out::println);
    }

    /**
     * Calcula y muestra el promedio de salarios de los empleados.
     */
    private static void mostrarPromedioSalarios(List<Empleado> empleados) {
        double promedio = empleados.stream()
            .mapToDouble(Empleado::getSalario)
            .average()
            .orElse(0.0);
        System.out.printf("\nPromedio de salarios: %.2f\n", promedio);
    }
}