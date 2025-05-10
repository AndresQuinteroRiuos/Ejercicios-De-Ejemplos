package Model.controllers;

import Model.servicios.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private static ResourceManager instance;
    private Map<String, servicioEmergenciaBase> serviciosDisponibles;
    private Map<String, Integer> recursosGenerales;
    private Map<String, String> configuraciones;

    private ResourceManager() {
        this.serviciosDisponibles = new HashMap<>();
        this.recursosGenerales = new HashMap<>();
        this.configuraciones = new HashMap<>();
        inicializarRecursos();
    }

    public static synchronized ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    private void inicializarRecursos() {
        // Inicializar recursos generales
        recursosGenerales.put("combustible", 10000);
        recursosGenerales.put("personal", 100);
        recursosGenerales.put("medicamentos", 500);
        recursosGenerales.put("agua", 50000);
        
        // Inicializar configuraciones
        configuraciones.put("tiempo_max_respuesta", "30");
        configuraciones.put("nivel_alerta", "NORMAL");
    }

    public void registrarServicio(servicioEmergenciaBase servicio) {
        serviciosDisponibles.put(servicio.getId(), servicio);
    }

    public void removerServicio(String idServicio) {
        serviciosDisponibles.remove(idServicio);
    }

    public servicioEmergenciaBase obtenerServicio(String idServicio) {
        return serviciosDisponibles.get(idServicio);
    }

    public Map<String, servicioEmergenciaBase> getServiciosDisponibles() {
        return new HashMap<>(serviciosDisponibles);
    }

    public void actualizarRecurso(String tipoRecurso, int cantidad) {
        recursosGenerales.put(tipoRecurso, cantidad);
    }

    public int obtenerRecurso(String tipoRecurso) {
        return recursosGenerales.getOrDefault(tipoRecurso, 0);
    }

    public void actualizarConfiguracion(String clave, String valor) {
        configuraciones.put(clave, valor);
    }

    public String obtenerConfiguracion(String clave) {
        return configuraciones.get(clave);
    }

    public void asignarRecursos(servicioEmergenciaBase servicio, String tipoRecurso, int cantidad) {
        int recursosActuales = obtenerRecurso(tipoRecurso);
        if (recursosActuales >= cantidad) {
            actualizarRecurso(tipoRecurso, recursosActuales - cantidad);
            servicio.actualizarRecursos(tipoRecurso, cantidad);
        } else {
            System.out.println("No hay suficientes recursos de tipo " + tipoRecurso);
        }
    }

    public String obtenerEstadoRecursos() {
        StringBuilder estado = new StringBuilder();
        estado.append("Estado de los recursos del sistema:\n");
        
        estado.append("\nRecursos generales:\n");
        for (Map.Entry<String, Integer> recurso : recursosGenerales.entrySet()) {
            estado.append("- ").append(recurso.getKey()).append(": ").append(recurso.getValue()).append("\n");
        }
        
        estado.append("\nServicios disponibles: ").append(serviciosDisponibles.size()).append("\n");
        for (servicioEmergenciaBase servicio : serviciosDisponibles.values()) {
            estado.append("- ").append(servicio.getTipoServicio()).append(": ").append(servicio.getId()).append("\n");
        }
        
        return estado.toString();
    }
} 