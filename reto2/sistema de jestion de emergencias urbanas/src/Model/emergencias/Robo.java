package Model.emergencias;

import Model.servicios.servicioEmergenciaBase;
import utils.nivelGravedad;
import utils.tipoEmergencia;

public class Robo extends emergenciaBase {
    private String tipoEstablecimiento;
    private int cantidadSospechosos;
    private boolean hayRehenes;
    private boolean hayArmas;
    private String descripcionSospechosos;
    private String vehiculoHuir;
    private String informacionPropietario;
    private String informacionTestigos;
    private String informacionValores;

    public Robo(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta) {
        super(ubicacion, 0.0, 0.0, gravedad, tiempoRespuesta, tipoEmergencia.ROBO);
        this.tipoEstablecimiento = "No especificado";
        this.cantidadSospechosos = 0;
        this.hayRehenes = false;
        this.hayArmas = false;
        this.descripcionSospechosos = "";
        this.vehiculoHuir = "";
        this.informacionPropietario = "";
        this.informacionTestigos = "";
        this.informacionValores = "";
    }

    @Override
    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Información del robo:\n");
        info.append("- Ubicación: ").append(ubicacion).append("\n");
        info.append("- Gravedad: ").append(gravedad).append("\n");
        info.append("- Tiempo de respuesta requerido: ").append(tiempoRespuesta).append(" minutos\n");
        info.append("- Estado actual: ").append(estadoActual).append("\n");
        info.append("- Tipo de establecimiento: ").append(tipoEstablecimiento).append("\n");
        info.append("- Cantidad de sospechosos: ").append(cantidadSospechosos).append("\n");
        info.append("- Hay rehenes: ").append(hayRehenes ? "Sí" : "No").append("\n");
        info.append("- Hay armas: ").append(hayArmas ? "Sí" : "No").append("\n");
        return info.toString();
    }

    @Override
    public void actualizarInformacion(String informacion) {
        System.out.println("Actualizando información del robo: " + informacion);
    }

    public void establecerTipoEstablecimiento(String tipo) {
        this.tipoEstablecimiento = tipo;
    }

    public void actualizarCantidadSospechosos(int cantidad) {
        this.cantidadSospechosos = cantidad;
        if (cantidad > 2) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void reportarRehenes(boolean hayRehenes) {
        this.hayRehenes = hayRehenes;
        if (hayRehenes) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void reportarArmas(boolean hayArmas) {
        this.hayArmas = hayArmas;
        if (hayArmas) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void actualizarDescripcionSospechosos(String descripcion) {
        this.descripcionSospechosos = descripcion;
    }

    public void actualizarVehiculoHuir(String vehiculo) {
        this.vehiculoHuir = vehiculo;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public int getCantidadSospechosos() {
        return cantidadSospechosos;
    }

    public boolean isHayRehenes() {
        return hayRehenes;
    }

    public boolean isHayArmas() {
        return hayArmas;
    }

    public String getDescripcionSospechosos() {
        return descripcionSospechosos;
    }

    public String getVehiculoHuir() {
        return vehiculoHuir;
    }
} 