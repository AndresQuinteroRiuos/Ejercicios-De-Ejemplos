package com.example;

import java.util.ArrayList;
import java.util.List;

public class RegistroMascotaLista implements RegistroMascota{
    
    private   List<Mascota> mascotas = new ArrayList<>();
    @Override
    public void agregarMascota(Mascota mascota) {
       mascotas.add(mascota);
    }

    @Override
    public List<Mascota> obtenerMascota() {
        return mascotas;
    }
    

}
