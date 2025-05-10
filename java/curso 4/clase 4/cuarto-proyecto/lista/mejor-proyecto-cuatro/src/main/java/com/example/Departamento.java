package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un departamento de la empresa.
 */
public class Departamento {
    private final String nombre;
    private final String ubicacion;
    private final List<Empleado> empleados;

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double calcularPresupuestoTotal() {
        return empleados.stream()
            .mapToDouble(Empleado::getSalario)
            .sum();
    }

    public double calcularPromedioSalario() {
        return empleados.stream()
            .mapToDouble(Empleado::getSalario)
            .average()
            .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("Departamento: %s (Ubicación: %s) - Empleados: %d", 
            nombre, ubicacion, empleados.size());
    }
} 