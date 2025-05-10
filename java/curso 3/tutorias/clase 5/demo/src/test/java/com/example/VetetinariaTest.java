package com.example;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VetetinariaTest {
   
    private Veterinaria veterinaria;
    private RegistroMascota registro;


    @Test
    void TestregistrarMascota() {
       
        veterinaria.registrarMascota("tony ", "perro");
        verify(registro).agregarMascota(Mockito.any(Mascota.class)); //registro.agregarMascota(any(Mascota.class));
        List<Mascota> mascotas = veterinaria.ListarMascotas();
        assertEquals(1, mascotas.size());
        assertEquals("tony", mascotas.get(0).getNombre());
    }
    @Test    
    void TestListarMascotas() {
       
       
        List<Mascota>   ListaFalsa = Arrays.asList(
                new Mascota("michi", "gato"),
                new Mascota("rex   ", "perro"));
                when(registro.obtenerMascota()).thenReturn(ListaFalsa); //registro.obtenerMascota().thenReturn(null)
        
                List<Mascota> resultado= veterinaria.ListarMascotas();
                assertEquals(ListaFalsa,resultado);
                assertEquals(2, resultado.size());
                assertNotNull(resultado);
                assertEquals("rex", resultado.get(1).getNombre()); 
               }
               @Test
               void TestAgregarYVerificar() {
                Mascota NuevaMascota=new Mascota("snake", "serpiente");
                veterinaria.registrarMascota("body ", "tortuga");

               
     veterinaria.registrarMascota(NuevaMascota);
                verify(registro).agregarMascota(NuevaMascota);
               }
}