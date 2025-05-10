package com.example.service;

import java.lang.System.Logger;
import java.util.List;

import com.example.DAO.EnfermeroDAO;
import com.example.DAO.EnfermeroDAOImplements;
import com.example.model.Enfermero;

public class EnfermeroServiceImpl implements EnfermeroService {
    private static final Logger logger=
    LoggerFactorys.getLogger(EnfermeroServiceImpl.class);
   
    private  final EnfermeroDAO enfermeroDao= new EnfermeroDAOImplements();
    
    @Override
    public void registrarEnfermero(Enfermero enfermero) {
       EnfermeroDAO.guardar(enfermero);
       logger.info(   "Enfermero registrado: {}",enfermero);
    }
@Override
    public Enfermero obtenerEnfermeroPorId(int id) throws EnfermeroNoEncontradoException {
       Enfermero enfermero=enfermeroDao.buscarPorId(id); 
       if (enfermero==null) {
        logger.error( "Enfermero no encontrado por el id : " + id);
        throw new EnfermeroNoEncontradoException   ("Enfermero no encontrado por el id [exception]: " + id);

       }
        return enfermero;
    }

    @Override
    public List<Enfermero> listarEnfermeros() {
       return enfermeroDao.mostrarlista();}
    @Override
    public Enfermero obtenerEnfermeroPorIdEnfermero(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEnfermeroPorIdEnfermero'");
    }


}
