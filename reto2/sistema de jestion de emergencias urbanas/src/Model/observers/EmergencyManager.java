package Model.observers;

import Model.emergencias.emergenciaBase;
import Model.estrategias.PriorizacionPorGravedad;
import Model.estrategias.PriorizacionStrategy;
import Model.metrics.MetricasDesempeno;
import Model.servicios.servicioEmergenciaBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmergencyManager implements EmergencySubject {
    private List<EmergencyObserver> observers;
    private PriorizacionStrategy estrategiaPriorizacion;
    private MetricasDesempeno metricas;

    public EmergencyManager() {
        this.observers = new ArrayList<>();
        this.estrategiaPriorizacion = new PriorizacionPorGravedad();
        this.metricas = MetricasDesempeno.getInstance();
        this.metricas.iniciarJornada();
    }

    public void setEstrategiaPriorizacion(PriorizacionStrategy estrategia) {
        this.estrategiaPriorizacion = estrategia;
    }

    @Override
    public void registrarObserver(EmergencyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(EmergencyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(emergenciaBase emergencia) {
        for (EmergencyObserver observer : observers) {
            observer.actualizar(emergencia);
        }
    }

    @Override
    public void asignarServicio(servicioEmergenciaBase servicio, emergenciaBase emergencia) {
        // Registrar la asignación en las métricas
        metricas.registrarAsignacionServicio(emergencia, servicio);
        
        // Asignar el servicio a la emergencia
        emergencia.asignarServicio(servicio);
        // Notificar al servicio específico
        for (EmergencyObserver observer : observers) {
            if (observer instanceof servicioEmergenciaBase && 
                ((servicioEmergenciaBase) observer).getId().equals(servicio.getId())) {
                observer.recibirAsignacion(emergencia);
            }
        }
    }

    public void registrarNuevaEmergencia(emergenciaBase emergencia) {
        // Registrar la nueva emergencia en las métricas
        metricas.registrarNuevaEmergencia(emergencia);
        
        // Notificar a todos los observadores sobre la nueva emergencia
        notificarObservers(emergencia);
        // Determinar el servicio más apropiado basado en el tipo de emergencia
        asignarServicioMasApropiado(emergencia);
    }

    public void finalizarEmergencia(emergenciaBase emergencia, boolean exitosa, String observaciones) {
        // Registrar la finalización en las métricas
        metricas.registrarFinalizacionEmergencia(emergencia, exitosa, observaciones);
        
        // Finalizar la atención de la emergencia
        emergencia.finalizarAtencion();
    }

    public String obtenerReporteDesempeno() {
        return metricas.generarReporteJornada();
    }

    public Map<String, Object> obtenerRecomendacionesOptimizacion() {
        return metricas.analizarOptimizacion();
    }

    private void asignarServicioMasApropiado(emergenciaBase emergencia) {
        // Lógica para determinar el servicio más apropiado
        // Esto podría incluir:
        // 1. Filtrar servicios por tipo de emergencia
        // 2. Verificar disponibilidad
        // 3. Considerar proximidad
        // 4. Asignar el servicio más adecuado
    }
} 