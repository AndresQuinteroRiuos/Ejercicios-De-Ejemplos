package Model.interfaces;

public interface IServicioEmergencia {
    String getId();
    int getCombustible();
    boolean estaDisponible(); 
    int getPersonalDisponible();
    void asignarPersonal(    int cantidad);
   void asignarCombustible(double cantidad);
   void cargarCombustible(double cantidad);
   void atenderEmergencia(Model.Emergencia emergencia);
}
