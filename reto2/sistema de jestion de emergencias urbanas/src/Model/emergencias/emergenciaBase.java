package Model.emergencias;

import Model.servicios.servicioEmergenciaBase;
import utils.nivelGravedad;
import utils.tipoEmergencia;

public abstract class emergenciaBase {
    protected String ubicacion;
    protected double latitud;
    protected double longitud;
    protected nivelGravedad gravedad;
    protected int tiempoRespuesta;
    protected String estadoActual;
    protected tipoEmergencia tipo;
    protected servicioEmergenciaBase servicioAsignado;

    public emergenciaBase(String ubicacion, double latitud, double longitud, 
                         nivelGravedad gravedad, int tiempoRespuesta, tipoEmergencia tipo) {
        this.ubicacion = ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.gravedad = gravedad;
        this.tiempoRespuesta = tiempoRespuesta;
        this.estadoActual = "PENDIENTE";
        this.tipo = tipo;
        this.servicioAsignado = null;
    }

    // Getters
    public String getUbicacion() { return ubicacion; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }
    public nivelGravedad getNivelGravedad() { return gravedad; }
    public int getTiempoRespuesta() { return tiempoRespuesta; }
    public String getEstadoActual() { return estadoActual; }
    public tipoEmergencia getTipo() { return tipo; }
    public servicioEmergenciaBase getServicioAsignado() { return servicioAsignado; }

    // Método para actualizar el estado de la emergencia
    public void actualizarEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    // Método para asignar un servicio a la emergencia
    public void asignarServicio(servicioEmergenciaBase servicio) {
        this.servicioAsignado = servicio;
        this.estadoActual = "EN_ATENCION";
    }

    // Método para finalizar la atención de la emergencia
    public void finalizarAtencion() {
        if (servicioAsignado != null) {
            servicioAsignado.finalizarEmergencia(this);
            this.estadoActual = "ATENDIDA";
            this.servicioAsignado = null;
        }
    }

    // Método abstracto para obtener información específica de la emergencia
    public abstract String obtenerInformacion();

    // Método abstracto para actualizar información específica de la emergencia
    public abstract void actualizarInformacion(String informacion);
} 