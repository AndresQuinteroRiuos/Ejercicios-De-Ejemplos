package Model;

import utils.nivelGravedad;

public class accidenteVehicular extends emergtencia {
    public accidenteVehicular(String ubicacion, nivelGravedad nivelGravedad, int tiempoRespuesta, boolean atendida) {
        super("Accidente Vehicular", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
