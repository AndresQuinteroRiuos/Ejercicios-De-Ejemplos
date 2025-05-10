package com.example.Dao;
import java.util.List;

import com.example.model.Enfermero;
public interface EnfermeroDAO {
     void guardar(Enfermero enfermero) ;
     Enfermero buscarPorId(int id);
    List<Enfermero> mostrarlista();
}
