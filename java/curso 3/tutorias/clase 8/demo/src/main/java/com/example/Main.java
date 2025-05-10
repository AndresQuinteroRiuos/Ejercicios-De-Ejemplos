package com.example;

import com.example.service.EnfermeroService;

public class Main {
    public static void main(String[] args) {
        EnfermeroService servicio = new EnfermeroServiceImpl();
    
        servicio.registrarEnfermero(
            new Enfermero(1, "Laura Gomez"));
           
         servicio.registrarEnfermero(
            new Enfermero(2, "Pedro Perez"));
            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }

            System.out.println(servicio.obtenerEnfermeroPorId(1));// se encuentra

            System.out.println(servicio.obtenerEnfermeroPorId(3));//no se encuentra
        
    }
}