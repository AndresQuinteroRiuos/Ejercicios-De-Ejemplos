package Model;

import utils.nivelGravedad;

public class emergtencia {
    private String tipo;
    private String ubicacion;
    private nivelGravedad nivelGravedad;
    private int tiempoRespuesta; //en minutos
    private boolean atendida;
    private long tiempoInicioAtencion;
    private long tiempoFinalAtencion;

    public emergtencia(String tipo, String ubicacion, nivelGravedad nivelGravedad, int tiempoRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nivelGravedad = nivelGravedad;
        this.tiempoRespuesta = tiempoRespuesta;
        this.atendida = false;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public nivelGravedad getNivelGravedad() {
        return nivelGravedad;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public long getTiempoInicioAtencion() {
        return tiempoInicioAtencion;
    }

    public long getTiempoFinalAtencion() {
        return tiempoFinalAtencion;
    }

    public void tiempoInicioAtencion() {
        this.tiempoInicioAtencion = System.currentTimeMillis();
    }

    public void marcarFinalAtencion() {
        this.atendida = true;
        this.tiempoFinalAtencion = System.currentTimeMillis();
    }

    public long calcularTiempoAtencion() {
        return tiempoFinalAtencion - tiempoInicioAtencion;
    }

    @Override
    public String toString() {
        return "Emergencia: " + tipo + " - Ubicación: " + ubicacion + " - Gravedad: " + nivelGravedad + 
               " - Estado: " + (atendida ? "Atendida" : "Pendiente");
    }
}
