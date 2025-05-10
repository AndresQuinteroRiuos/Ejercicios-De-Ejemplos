package Model.observers;

import Model.emergencias.emergenciaBase;

public interface EmergencyObserver {
    void actualizar(emergenciaBase emergencia);
    void recibirAsignacion(emergenciaBase emergencia);
} 