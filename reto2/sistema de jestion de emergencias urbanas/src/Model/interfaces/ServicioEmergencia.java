package Model.interfaces;

public interface ServicioEmergencia {
    void movilizarUnidad();
    void reportarEstado();
    void solicitarRefuerzos();
    void actualizarUbicacion(String nuevaUbicacion);
    boolean verificarDisponibilidad();
    void finalizarIntervencion();
} 