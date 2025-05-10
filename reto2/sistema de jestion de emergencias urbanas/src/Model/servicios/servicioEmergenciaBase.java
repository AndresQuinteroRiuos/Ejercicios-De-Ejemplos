package Model.servicios;

import Model.emergencias.emergenciaBase;
import Model.interfaces.GestionEmergencia;
import Model.observers.EmergencyObserver;
import java.util.ArrayList;
import java.util.List;
import utils.nivelGravedad;

public abstract class servicioEmergenciaBase implements GestionEmergencia, EmergencyObserver {
    protected String id;
    protected int personalDisponible;
    protected double combustible;
    protected List<String> observaciones;
    protected String estadoActual;
    protected boolean disponible;
    protected List<emergenciaBase> emergenciasAsignadas;
    private int unidadesDisponibles;
    private double capacidadMaxima;
    private int tiempoEstimadoRespuesta;
    private double latitud;
    private double longitud;

    public servicioEmergenciaBase(String id, int personalDisponible, double combustible, 
                                int unidadesDisponibles, double capacidadMaxima, 
                                int tiempoEstimadoRespuesta, double latitud, double longitud) {
        this.id = id;
        this.personalDisponible = personalDisponible;
        this.combustible = combustible;
        this.observaciones = new ArrayList<>();
        this.estadoActual = "DISPONIBLE";
        this.disponible = true;
        this.emergenciasAsignadas = new ArrayList<>();
        this.unidadesDisponibles = unidadesDisponibles;
        this.capacidadMaxima = capacidadMaxima;
        this.tiempoEstimadoRespuesta = tiempoEstimadoRespuesta;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public void registrarEmergencia(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta) {
        System.out.println("Registrando emergencia para " + getTipoServicio() + " en " + ubicacion);
        System.out.println("Nivel de gravedad: " + gravedad);
        System.out.println("Tiempo de respuesta requerido: " + tiempoRespuesta + " minutos");
    }

    @Override
    public void asignarServicio(servicioEmergenciaBase servicio) {
        if (verificarDisponibilidad()) {
            System.out.println("Servicio " + getTipoServicio() + " asignado correctamente");
            this.disponible = false;
        } else {
            System.out.println("El servicio no está disponible para asignación");
        }
    }

    @Override
    public void actualizarInformacion(String nuevaInformacion) {
        System.out.println("Actualizando información del servicio " + getTipoServicio() + ": " + nuevaInformacion);
    }

    @Override
    public String evaluarEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Estado del servicio ").append(getTipoServicio()).append(":\n");
        estado.append("- ID: ").append(id).append("\n");
        estado.append("- Personal disponible: ").append(personalDisponible).append("\n");
        estado.append("- Combustible: ").append(combustible).append("\n");
        estado.append("- Estado actual: ").append(estadoActual).append("\n");
        estado.append("- Disponible: ").append(disponible).append("\n");
        return estado.toString();
    }

    @Override
    public boolean verificarPrioridad() {
        return !disponible;
    }

    @Override
    public String obtenerRecomendaciones() {
        StringBuilder recomendaciones = new StringBuilder();
        recomendaciones.append("Recomendaciones para ").append(getTipoServicio()).append(":\n");
        
        if (combustible < 20) {
            recomendaciones.append("- Nivel de combustible bajo, se recomienda reabastecer\n");
        }
        
        if (personalDisponible < 2) {
            recomendaciones.append("- Personal insuficiente, se recomienda solicitar refuerzos\n");
        }
        
        return recomendaciones.toString();
    }

    @Override
    public void actualizarProgreso(String estado) {
        this.estadoActual = estado;
        System.out.println("Progreso actualizado para " + getTipoServicio() + ": " + estado);
    }

    @Override
    public String obtenerMetricas() {
        StringBuilder metricas = new StringBuilder();
        metricas.append("Métricas del servicio ").append(getTipoServicio()).append(":\n");
        metricas.append("- Personal disponible: ").append(personalDisponible).append("\n");
        metricas.append("- Combustible: ").append(combustible).append("\n");
        metricas.append("- Observaciones registradas: ").append(observaciones.size()).append("\n");
        return metricas.toString();
    }

    @Override
    public void registrarObservacion(String observacion) {
        observaciones.add(observacion);
        System.out.println("Observación registrada para " + getTipoServicio() + ": " + observacion);
    }

    @Override
    public void coordinarServicios() {
        System.out.println("Coordinando servicio " + getTipoServicio());
        movilizarUnidad();
        reportarEstado();
    }

    @Override
    public void solicitarApoyo(String tipoApoyo) {
        System.out.println("Solicitando apoyo de tipo " + tipoApoyo + " para " + getTipoServicio());
    }

    @Override
    public void actualizarRecursos(String tipoRecurso, int cantidad) {
        System.out.println("Actualizando recursos para " + getTipoServicio() + ": " + tipoRecurso + " = " + cantidad);
    }

    @Override
    public void actualizar(emergenciaBase emergencia) {
        System.out.println("Servicio " + getTipoServicio() + " " + id + 
                         " ha sido notificado sobre la emergencia en " + 
                         emergencia.getUbicacion());
    }

    @Override
    public void recibirAsignacion(emergenciaBase emergencia) {
        if (verificarDisponibilidad()) {
            emergenciasAsignadas.add(emergencia);
            movilizarUnidades(1);
            System.out.println("Servicio " + getTipoServicio() + " " + id + 
                             " ha sido asignado a la emergencia en " + 
                             emergencia.getUbicacion());
        }
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    public abstract String getTipoServicio();
    public abstract void movilizarUnidad();
    public abstract void reportarEstado();
    public abstract boolean verificarDisponibilidad();

    // Getters y Setters
    public String getId() {
        return id;
    }

    public int getPersonalDisponible() {
        return personalDisponible;
    }

    public double getCombustible() {
        return combustible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<emergenciaBase> getEmergenciasAsignadas() {
        return new ArrayList<>(emergenciasAsignadas);
    }

    public void finalizarEmergencia(emergenciaBase emergencia) {
        if (emergenciasAsignadas.remove(emergencia)) {
            liberarUnidades(1);
            System.out.println("Servicio " + getTipoServicio() + " " + id + 
                             " finalizó atención de emergencia en " + 
                             emergencia.getUbicacion());
        }
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getTiempoEstimadoRespuesta() {
        return tiempoEstimadoRespuesta;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void movilizarUnidades(int cantidad) {
        if (cantidad <= unidadesDisponibles) {
            unidadesDisponibles -= cantidad;
            estadoActual = "EN_MOVIMIENTO";
        }
    }

    public void liberarUnidades(int cantidad) {
        unidadesDisponibles += cantidad;
        if (unidadesDisponibles > 0) {
            estadoActual = "DISPONIBLE";
        }
    }
}
