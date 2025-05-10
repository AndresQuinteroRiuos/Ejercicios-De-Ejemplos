package Model.interfaces;

public interface iservicioEmergencia {
    String getId();
    int getCombustible(); 
    boolean estaDisponible();
    int getPersonalDisponible();
    void asignarPersonal(int cantidad);
    void asignarCombustible(double cantidad);
    void cargarCombustible(double cantidad);
    void atenderEmergencia(emergencia emergencia);
}
