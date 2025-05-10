package Model.emergencias;

import Model.servicios.servicioEmergenciaBase;
import utils.nivelGravedad;
import utils.tipoEmergencia;

public class AccidenteVehicular extends emergenciaBase {
    private int cantidadVehiculos;
    private int cantidadHeridos;
    private boolean hayPersonasAtrapadas;
    private String tipoAccidente;
    private boolean hayFugaCombustible;
    private boolean hayObstaculoVia;
    private String informacionConductores;
    private String numerosPlaca;

    public AccidenteVehicular(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta) {
        super(ubicacion, 0.0, 0.0, gravedad, tiempoRespuesta, tipoEmergencia.ACCIDENTE_VEHICULAR);
        this.cantidadVehiculos = 0;
        this.cantidadHeridos = 0;
        this.hayPersonasAtrapadas = false;
        this.tipoAccidente = "No especificado";
        this.hayFugaCombustible = false;
        this.hayObstaculoVia = false;
        this.informacionConductores = "";
        this.numerosPlaca = "";
    }

    @Override
    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Información del accidente vehicular:\n");
        info.append("- Ubicación: ").append(ubicacion).append("\n");
        info.append("- Gravedad: ").append(gravedad).append("\n");
        info.append("- Tiempo de respuesta requerido: ").append(tiempoRespuesta).append(" minutos\n");
        info.append("- Estado actual: ").append(estadoActual).append("\n");
        info.append("- Tipo de accidente: ").append(tipoAccidente).append("\n");
        info.append("- Vehículos involucrados: ").append(cantidadVehiculos).append("\n");
        info.append("- Personas heridas: ").append(cantidadHeridos).append("\n");
        info.append("- Personas atrapadas: ").append(hayPersonasAtrapadas ? "Sí" : "No").append("\n");
        info.append("- Fuga de combustible: ").append(hayFugaCombustible ? "Sí" : "No").append("\n");
        info.append("- Obstáculo en vía: ").append(hayObstaculoVia ? "Sí" : "No").append("\n");
        return info.toString();
    }

    @Override
    public void actualizarInformacion(String informacion) {
        System.out.println("Actualizando información del accidente vehicular: " + informacion);
    }

    public void establecerTipoAccidente(String tipo) {
        this.tipoAccidente = tipo;
    }

    public void actualizarCantidadVehiculos(int cantidad) {
        this.cantidadVehiculos = cantidad;
    }

    public void actualizarCantidadHeridos(int cantidad) {
        this.cantidadHeridos = cantidad;
    }

    public void reportarPersonasAtrapadas(boolean hayPersonas) {
        this.hayPersonasAtrapadas = hayPersonas;
        if (hayPersonas) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void reportarFugaCombustible(boolean hayFuga) {
        this.hayFugaCombustible = hayFuga;
        if (hayFuga) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void reportarObstaculoVia(boolean hayObstaculo) {
        this.hayObstaculoVia = hayObstaculo;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public int getCantidadHeridos() {
        return cantidadHeridos;
    }

    public boolean isHayPersonasAtrapadas() {
        return hayPersonasAtrapadas;
    }

    public String getTipoAccidente() {
        return tipoAccidente;
    }

    public boolean isHayFugaCombustible() {
        return hayFugaCombustible;
    }

    public boolean isHayObstaculoVia() {
        return hayObstaculoVia;
    }
} 