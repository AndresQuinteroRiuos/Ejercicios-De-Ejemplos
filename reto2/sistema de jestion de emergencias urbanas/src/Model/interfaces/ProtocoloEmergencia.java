package Model.interfaces;

public interface ProtocoloEmergencia {
    void iniciarProtocolo();
    void finalizarProtocolo();
    String obtenerReporteDetallado();
    void asignarRecursos();
    void notificarAutoridades();
    void registrarIncidente();
} 