package com.example.service;
import java.util.List;

import com.example.model.Enfermero;
public interface EnfermeroService {
    void registrarEnfermero(Enfermero enfermero);
    Enfermero obtenerEnfermeroPorIdEnfermero(int id) throws EnfermeroNoEncontradoException;
    List<Enfermero>listarEnfermeros();
    char[] obtenerEnfermeroPorId(int i);  
}
