package Model.observers;

import Model.emergencias.emergenciaBase;
import Model.servicios.servicioEmergenciaBase;

public interface EmergencySubject {
    void registrarObserver(EmergencyObserver observer);
    void removerObserver(EmergencyObserver observer);
    void notificarObservers(emergenciaBase emergencia);
    void asignarServicio(servicioEmergenciaBase servicio, emergenciaBase emergencia);
} 