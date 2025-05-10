package Model.emergencias;

import utils.nivelGravedad;
import utils.tipoEmergencia;

public class Incendio extends emergenciaBase {
    private int areaAfectada;
    private boolean hayPersonasAtrapadas;
    private String tipoEdificio;
    private int cantidadPisos;
    private boolean hayMaterialesPeligrosos;
    private String informacionPropietario;
    private String planosEdificio;

    public Incendio(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta) {
        super(ubicacion, 0.0, 0.0, gravedad, tiempoRespuesta, tipoEmergencia.INCENDIO);
        this.areaAfectada = 0;
        this.hayPersonasAtrapadas = false;
        this.tipoEdificio = "No especificado";
        this.cantidadPisos = 0;
        this.hayMaterialesPeligrosos = false;
        this.informacionPropietario = "";
        this.planosEdificio = "";
    }

    @Override
    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Información del incendio:\n");
        info.append("- Ubicación: ").append(ubicacion).append("\n");
        info.append("- Gravedad: ").append(gravedad).append("\n");
        info.append("- Tiempo de respuesta requerido: ").append(tiempoRespuesta).append(" minutos\n");
        info.append("- Estado actual: ").append(estadoActual).append("\n");
        info.append("- Área afectada: ").append(areaAfectada).append(" m²\n");
        info.append("- Tipo de edificio: ").append(tipoEdificio).append("\n");
        info.append("- Cantidad de pisos: ").append(cantidadPisos).append("\n");
        info.append("- Personas atrapadas: ").append(hayPersonasAtrapadas ? "Sí" : "No").append("\n");
        info.append("- Materiales peligrosos: ").append(hayMaterialesPeligrosos ? "Sí" : "No").append("\n");
        return info.toString();
    }

    @Override
    public void actualizarInformacion(String informacion) {
        System.out.println("Actualizando información del incendio: " + informacion);
    }

    public void actualizarAreaAfectada(int area) {
        this.areaAfectada = area;
        if (area > 100) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void reportarPersonasAtrapadas(boolean hayPersonas) {
        this.hayPersonasAtrapadas = hayPersonas;
        if (hayPersonas) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public void establecerTipoEdificio(String tipo) {
        this.tipoEdificio = tipo;
    }

    public void actualizarCantidadPisos(int pisos) {
        this.cantidadPisos = pisos;
    }

    public void reportarMaterialesPeligrosos(boolean hayMateriales) {
        this.hayMaterialesPeligrosos = hayMateriales;
        if (hayMateriales) {
            this.gravedad = nivelGravedad.ALTA;
        }
    }

    public int getAreaAfectada() {
        return areaAfectada;
    }

    public boolean isHayPersonasAtrapadas() {
        return hayPersonasAtrapadas;
    }

    public String getTipoEdificio() {
        return tipoEdificio;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public boolean isHayMaterialesPeligrosos() {
        return hayMaterialesPeligrosos;
    }
} 