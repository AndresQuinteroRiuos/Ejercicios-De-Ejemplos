package Model.factories;

import Model.emergencias.*;
import utils.nivelGravedad;
import utils.tipoEmergencia;

public class EmergencyFactory {
    public static emergenciaBase crearEmergencia(tipoEmergencia tipo, String ubicacion, 
                                               nivelGravedad gravedad, int tiempoRespuesta) {
        switch (tipo) {
            case INCENDIO:
                return new Incendio(ubicacion, gravedad, tiempoRespuesta);
            case ACCIDENTE_VEHICULAR:
                return new AccidenteVehicular(ubicacion, gravedad, tiempoRespuesta);
            case ROBO:
                return new Robo(ubicacion, gravedad, tiempoRespuesta);
            default:
                throw new IllegalArgumentException("Tipo de emergencia no válido: " + tipo);
        }
    }
} 