package Model;

import utils.nivelGravedad;

public class incendio extends emergtencia {
    public incendio(String ubicacion, nivelGravedad nivelGravedad, int tiempoRespuesta, boolean atendida) {
        super("Incendio", ubicacion, nivelGravedad, tiempoRespuesta);
    }
}
