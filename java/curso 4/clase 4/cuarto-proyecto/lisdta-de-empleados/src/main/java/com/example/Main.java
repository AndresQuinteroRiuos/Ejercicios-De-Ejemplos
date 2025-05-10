package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = List.of(
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

        // Empleados mayores de 30 años
        List<Empleado> mayoresDe30 = empleados.stream()
            .filter(empleado -> empleado.getEdad() > 30)
            .collect(Collectors.toList());

        // Promedio de salarios
        double promedio = empleados.stream()
            .mapToDouble(Empleado::getSalario)
            .average()
            .orElse(0.0);

        // Empleados ordenados por apellido
        List<Empleado> ordenados = empleados.stream()
            .sorted(Comparator.comparing(Empleado::getApellido))
            .collect(Collectors.toList());

        System.out.println("Empleados ordenados por apellido:");
        ordenados.forEach(System.out::println);

        System.out.println("\nPrimeros 5 empleados:");
        ordenados.stream()
            .limit(5)
            .forEach(e -> System.out.println(e.getApellido() + ", " + e.getNombre()));

        System.out.println("\nEmpleados mayores de 30 años:");
        mayoresDe30.forEach(System.out::println);

        System.out.println("\nPromedio de salarios: " + promedio);
    }
}