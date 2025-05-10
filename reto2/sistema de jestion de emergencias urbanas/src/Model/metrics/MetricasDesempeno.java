package Model.metrics;

import Model.emergencias.emergenciaBase;
import Model.servicios.servicioEmergenciaBase;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetricasDesempeno {
    private static MetricasDesempeno instance;
    private final List<RegistroEmergencia> registros;
    private LocalDateTime inicioJornada;
    private LocalDateTime finJornada;

    // Clase interna para registrar información detallada de cada emergencia
    private static class RegistroEmergencia {
        private final emergenciaBase emergencia;
        private servicioEmergenciaBase servicioAsignado;
        private final LocalDateTime horaRegistro;
        private LocalDateTime horaAsignacion;
        private LocalDateTime horaFinalizacion;
        private boolean atendidaExitosamente;
        private String observaciones;

        public RegistroEmergencia(emergenciaBase emergencia) {
            this.emergencia = emergencia;
            this.horaRegistro = LocalDateTime.now();
            this.atendidaExitosamente = false;
        }

        public void registrarAsignacion(servicioEmergenciaBase servicio) {
            this.servicioAsignado = servicio;
            this.horaAsignacion = LocalDateTime.now();
        }

        public void registrarFinalizacion(boolean exitosa, String observaciones) {
            this.horaFinalizacion = LocalDateTime.now();
            this.atendidaExitosamente = exitosa;
            this.observaciones = observaciones;
        }

        public long calcularTiempoRespuesta() {
            if (horaAsignacion != null) {
                return Duration.between(horaRegistro, horaAsignacion).toMinutes();
            }
            return -1;
        }

        public long calcularTiempoAtencion() {
            if (horaFinalizacion != null && horaAsignacion != null) {
                return Duration.between(horaAsignacion, horaFinalizacion).toMinutes();
            }
            return -1;
        }
    }

    private MetricasDesempeno() {
        this.registros = new ArrayList<>();
    }

    public static MetricasDesempeno getInstance() {
        if (instance == null) {
            instance = new MetricasDesempeno();
        }
        return instance;
    }

    public void iniciarJornada() {
        this.inicioJornada = LocalDateTime.now();
        this.registros.clear();
    }

    public void finalizarJornada() {
        this.finJornada = LocalDateTime.now();
    }

    public void registrarNuevaEmergencia(emergenciaBase emergencia) {
        registros.add(new RegistroEmergencia(emergencia));
    }

    public void registrarAsignacionServicio(emergenciaBase emergencia, servicioEmergenciaBase servicio) {
        registros.stream()
            .filter(r -> r.emergencia == emergencia)
            .findFirst()
            .ifPresent(r -> r.registrarAsignacion(servicio));
    }

    public void registrarFinalizacionEmergencia(emergenciaBase emergencia, boolean exitosa, String observaciones) {
        registros.stream()
            .filter(r -> r.emergencia == emergencia)
            .findFirst()
            .ifPresent(r -> r.registrarFinalizacion(exitosa, observaciones));
    }

    // Métricas de desempeño
    public double calcularTiempoPromedioRespuesta() {
        return registros.stream()
            .mapToLong(RegistroEmergencia::calcularTiempoRespuesta)
            .filter(t -> t >= 0)
            .average()
            .orElse(0.0);
    }

    public double calcularTiempoPromedioAtencion() {
        return registros.stream()
            .mapToLong(RegistroEmergencia::calcularTiempoAtencion)
            .filter(t -> t >= 0)
            .average()
            .orElse(0.0);
    }

    public int contarEmergenciasAtendidas() {
        return (int) registros.stream()
            .filter(r -> r.atendidaExitosamente)
            .count();
    }

    public int contarEmergenciasPendientes() {
        return (int) registros.stream()
            .filter(r -> !r.atendidaExitosamente && r.horaFinalizacion == null)
            .count();
    }

    public Map<servicioEmergenciaBase, Integer> contarAsignacionesPorServicio() {
        return registros.stream()
            .filter(r -> r.servicioAsignado != null)
            .collect(Collectors.groupingBy(
                r -> r.servicioAsignado,
                Collectors.summingInt(r -> 1)
            ));
    }

    public Map<String, Integer> contarEmergenciasPorTipo() {
        return registros.stream()
            .collect(Collectors.groupingBy(
                r -> r.emergencia.getTipo().toString(),
                Collectors.summingInt(r -> 1)
            ));
    }

    public Map<String, Integer> contarEmergenciasPorGravedad() {
        return registros.stream()
            .collect(Collectors.groupingBy(
                r -> r.emergencia.getNivelGravedad().toString(),
                Collectors.summingInt(r -> 1)
            ));
    }

    public String generarReporteJornada() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== Reporte de Desempeño ===\n");
        reporte.append("Período: ").append(inicioJornada).append(" - ").append(finJornada).append("\n");
        reporte.append("Tiempo promedio de respuesta: ").append(calcularTiempoPromedioRespuesta()).append(" minutos\n");
        reporte.append("Tiempo promedio de atención: ").append(calcularTiempoPromedioAtencion()).append(" minutos\n");
        reporte.append("Emergencias atendidas: ").append(contarEmergenciasAtendidas()).append("\n");
        reporte.append("Emergencias pendientes: ").append(contarEmergenciasPendientes()).append("\n\n");

        reporte.append("Distribución por tipo de emergencia:\n");
        contarEmergenciasPorTipo().forEach((tipo, cantidad) ->
            reporte.append("- ").append(tipo).append(": ").append(cantidad).append("\n")
        );

        reporte.append("\nDistribución por nivel de gravedad:\n");
        contarEmergenciasPorGravedad().forEach((gravedad, cantidad) ->
            reporte.append("- ").append(gravedad).append(": ").append(cantidad).append("\n")
        );

        reporte.append("\nAsignaciones por servicio:\n");
        contarAsignacionesPorServicio().forEach((servicio, cantidad) ->
            reporte.append("- ").append(servicio.getId()).append(": ").append(cantidad).append("\n")
        );

        return reporte.toString();
    }

    // Método para optimizar la asignación de recursos
    public Map<String, Object> analizarOptimizacion() {
        Map<String, Object> recomendaciones = new HashMap<>();

        // Análisis de tiempos de respuesta
        double tiempoPromedioRespuesta = calcularTiempoPromedioRespuesta();
        if (tiempoPromedioRespuesta > 15) {
            recomendaciones.put("tiempo_respuesta", "Se recomienda aumentar el número de unidades disponibles o mejorar la distribución geográfica de los servicios");
        }

        // Análisis de distribución de emergencias
        Map<String, Integer> emergenciasPorTipo = contarEmergenciasPorTipo();
        emergenciasPorTipo.forEach((tipo, cantidad) -> {
            if (cantidad > 10) {
                recomendaciones.put("distribucion_" + tipo, "Se recomienda aumentar recursos para atender emergencias de tipo " + tipo);
            }
        });

        // Análisis de carga de trabajo por servicio
        contarAsignacionesPorServicio().forEach((servicio, cantidad) -> {
            if (cantidad > 5) {
                recomendaciones.put("carga_trabajo_" + servicio.getId(), 
                    "El servicio " + servicio.getId() + " está sobrecargado. Se recomienda redistribuir la carga");
            }
        });

        return recomendaciones;
    }
} 