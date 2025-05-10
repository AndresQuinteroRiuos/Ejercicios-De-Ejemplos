package Model.interfaces;

import Model.servicios.servicioEmergenciaBase;
import utils.nivelGravedad;

public interface GestionEmergencia {
    // Métodos para el ingreso de emergencias
    void registrarEmergencia(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta);
    void asignarServicio(servicioEmergenciaBase servicio);
    void actualizarInformacion(String nuevaInformacion);
    
    // Métodos para evaluación de estado
    String evaluarEstado();
    boolean verificarPrioridad();
    String obtenerRecomendaciones();
    
    // Métodos para seguimiento
    void actualizarProgreso(String estado);
    String obtenerMetricas();
    void registrarObservacion(String observacion);
    
    // Métodos para coordinación
    void coordinarServicios();
    void solicitarApoyo(String tipoApoyo);
    void actualizarRecursos(String tipoRecurso, int cantidad);
} 