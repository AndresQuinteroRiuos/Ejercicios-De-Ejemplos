package Model;

import utils.nivelGravedad;

public class robo extends emergtencia {
    public robo(String ubicacion, nivelGravedad nivelGravedad, int tiempoRespuesta, boolean atendida) {
        super("Robo", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
