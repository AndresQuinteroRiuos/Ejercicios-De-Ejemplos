package Model;

import Model.interfaces.GestionEmergencia;
import Model.servicios.servicioEmergenciaBase;
import utils.nivelGravedad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorEmergencias implements GestionEmergencia {
    private List<emergenciaBase> emergenciasActivas;
    private Map<String, servicioEmergenciaBase> serviciosDisponibles;
    private List<String> observaciones;
    private Map<String, Integer> recursosAsignados;
    private String estadoActual;

    public GestorEmergencias() {
        this.emergenciasActivas = new ArrayList<>();
        this.serviciosDisponibles = new HashMap<>();
        this.observaciones = new ArrayList<>();
        this.recursosAsignados = new HashMap<>();
        this.estadoActual = "INICIALIZADO";
    }

    @Override
    public void registrarEmergencia(String ubicacion, nivelGravedad gravedad, int tiempoRespuesta) {
        // Este método será implementado por las clases específicas de emergencia
        System.out.println("Registrando nueva emergencia en " + ubicacion);
        System.out.println("Nivel de gravedad: " + gravedad);
        System.out.println("Tiempo de respuesta requerido: " + tiempoRespuesta + " minutos");
    }

    @Override
    public void asignarServicio(servicioEmergenciaBase servicio) {
        if (servicio.verificarDisponibilidad()) {
            serviciosDisponibles.put(servicio.getId(), servicio);
            System.out.println("Servicio " + servicio.getId() + " asignado correctamente");
        } else {
            System.out.println("El servicio no está disponible para asignación");
        }
    }

    @Override
    public void actualizarInformacion(String nuevaInformacion) {
        System.out.println("Actualizando información de emergencia: " + nuevaInformacion);
    }

    @Override
    public String evaluarEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Estado del sistema de emergencias:\n");
        estado.append("- Emergencias activas: ").append(emergenciasActivas.size()).append("\n");
        estado.append("- Servicios disponibles: ").append(serviciosDisponibles.size()).append("\n");
        estado.append("- Estado actual: ").append(estadoActual).append("\n");
        
        for (emergenciaBase emergencia : emergenciasActivas) {
            estado.append("\nEmergencia: ").append(emergencia.getTipo())
                  .append(" - Estado: ").append(emergencia.getEstadoActual());
        }
        
        return estado.toString();
    }

    @Override
    public boolean verificarPrioridad() {
        for (emergenciaBase emergencia : emergenciasActivas) {
            if (emergencia.getNivelGravedad() == nivelGravedad.ALTA) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String obtenerRecomendaciones() {
        StringBuilder recomendaciones = new StringBuilder();
        recomendaciones.append("Recomendaciones basadas en el estado actual:\n");
        
        if (verificarPrioridad()) {
            recomendaciones.append("- Hay emergencias de alta prioridad que requieren atención inmediata\n");
        }
        
        if (serviciosDisponibles.size() < emergenciasActivas.size()) {
            recomendaciones.append("- Se recomienda solicitar servicios adicionales\n");
        }
        
        return recomendaciones.toString();
    }

    @Override
    public void actualizarProgreso(String estado) {
        this.estadoActual = estado;
        System.out.println("Progreso actualizado: " + estado);
    }

    @Override
    public String obtenerMetricas() {
        StringBuilder metricas = new StringBuilder();
        metricas.append("Métricas del sistema:\n");
        metricas.append("- Total de emergencias: ").append(emergenciasActivas.size()).append("\n");
        metricas.append("- Servicios activos: ").append(serviciosDisponibles.size()).append("\n");
        metricas.append("- Observaciones registradas: ").append(observaciones.size()).append("\n");
        
        for (Map.Entry<String, Integer> recurso : recursosAsignados.entrySet()) {
            metricas.append("- ").append(recurso.getKey()).append(": ").append(recurso.getValue()).append("\n");
        }
        
        return metricas.toString();
    }

    @Override
    public void registrarObservacion(String observacion) {
        observaciones.add(observacion);
        System.out.println("Observación registrada: " + observacion);
    }

    @Override
    public void coordinarServicios() {
        System.out.println("Coordinando servicios disponibles...");
        for (servicioEmergenciaBase servicio : serviciosDisponibles.values()) {
            servicio.movilizarUnidad();
            servicio.reportarEstado();
        }
    }

    @Override
    public void solicitarApoyo(String tipoApoyo) {
        System.out.println("Solicitando apoyo de tipo: " + tipoApoyo);
    }

    @Override
    public void actualizarRecursos(String tipoRecurso, int cantidad) {
        recursosAsignados.put(tipoRecurso, cantidad);
        System.out.println("Recursos actualizados - " + tipoRecurso + ": " + cantidad);
    }

    // Métodos adicionales para gestión
    public void agregarEmergencia(emergenciaBase emergencia) {
        emergenciasActivas.add(emergencia);
        System.out.println("Nueva emergencia agregada al sistema");
    }

    public void removerEmergencia(emergenciaBase emergencia) {
        emergenciasActivas.remove(emergencia);
        System.out.println("Emergencia removida del sistema");
    }

    public List<emergenciaBase> getEmergenciasActivas() {
        return new ArrayList<>(emergenciasActivas);
    }

    public Map<String, servicioEmergenciaBase> getServiciosDisponibles() {
        return new HashMap<>(serviciosDisponibles);
    }
} 