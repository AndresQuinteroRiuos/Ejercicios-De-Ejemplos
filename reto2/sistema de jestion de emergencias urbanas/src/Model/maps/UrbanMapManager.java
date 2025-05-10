package Model.maps;

import Model.emergencias.emergenciaBase;
import Model.servicios.servicioEmergenciaBase;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UrbanMapManager {
    // Clase interna para representar ubicaciones en el mapa
    public static class Ubicacion {
        private String nombre;
        private double latitud;
        private double longitud;
        private TipoUbicacion tipo;

        public Ubicacion(String nombre, double latitud, double longitud, TipoUbicacion tipo) {
            this.nombre = nombre;
            this.latitud = latitud;
            this.longitud = longitud;
            this.tipo = tipo;
        }

        // Getters
        public String getNombre() { return nombre; }
        public double getLatitud() { return latitud; }
        public double getLongitud() { return longitud; }
        public TipoUbicacion getTipo() { return tipo; }
    }

    // Clase interna para representar tipos de ubicación
    public enum TipoUbicacion {
        HOSPITAL,
        ESTACION_BOMBEROS,
        COMISARIA,
        EMERGENCIA,
        BASE_SERVICIO
    }

    private List<Ubicacion> ubicaciones;
    private static UrbanMapManager instance;

    private UrbanMapManager() {
        this.ubicaciones = new ArrayList<>();
    }

    public static UrbanMapManager getInstance() {
        if (instance == null) {
            instance = new UrbanMapManager();
        }
        return instance;
    }

    // Método para agregar una nueva ubicación
    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicaciones.add(ubicacion);
    }

    // Método para calcular la distancia entre dos ubicaciones
    public double calcularDistancia(Ubicacion origen, Ubicacion destino) {
        // Implementación simplificada del cálculo de distancia
        // En una implementación real, se usaría la fórmula de Haversine
        double latDiff = destino.getLatitud() - origen.getLatitud();
        double lonDiff = destino.getLongitud() - origen.getLongitud();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

    // Método para encontrar la ubicación más cercana de un tipo específico
    public Ubicacion encontrarUbicacionMasCercana(Ubicacion origen, TipoUbicacion tipo) {
        return ubicaciones.stream()
            .filter(u -> u.getTipo() == tipo)
            .min((u1, u2) -> Double.compare(
                calcularDistancia(origen, u1),
                calcularDistancia(origen, u2)
            ))
            .orElse(null);
    }

    // Método para filtrar servicios por criterios específicos usando lambdas
    public List<servicioEmergenciaBase> filtrarServicios(
        List<servicioEmergenciaBase> servicios,
        Predicate<servicioEmergenciaBase> criterio
    ) {
        return servicios.stream()
            .filter(criterio)
            .collect(Collectors.toList());
    }

    // Método para encontrar servicios disponibles dentro de un radio específico
    public List<servicioEmergenciaBase> encontrarServiciosEnRadio(
        List<servicioEmergenciaBase> servicios,
        Ubicacion ubicacion,
        double radioMaximo
    ) {
        return filtrarServicios(servicios, servicio -> {
            Ubicacion ubicacionServicio = new Ubicacion(
                servicio.getId(),
                servicio.getLatitud(),
                servicio.getLongitud(),
                TipoUbicacion.BASE_SERVICIO
            );
            return calcularDistancia(ubicacion, ubicacionServicio) <= radioMaximo;
        });
    }

    // Método para encontrar servicios con tiempo de respuesta menor a un límite
    public List<servicioEmergenciaBase> encontrarServiciosPorTiempoRespuesta(
        List<servicioEmergenciaBase> servicios,
        int tiempoMaximoRespuesta
    ) {
        return filtrarServicios(servicios, 
            servicio -> servicio.getTiempoEstimadoRespuesta() <= tiempoMaximoRespuesta
        );
    }

    // Método para encontrar servicios disponibles y cercanos a una emergencia
    public List<servicioEmergenciaBase> encontrarServiciosAdecuados(
        List<servicioEmergenciaBase> servicios,
        emergenciaBase emergencia,
        double radioMaximo,
        int tiempoMaximoRespuesta
    ) {
        Ubicacion ubicacionEmergencia = new Ubicacion(
            emergencia.getUbicacion(),
            emergencia.getLatitud(),
            emergencia.getLongitud(),
            TipoUbicacion.EMERGENCIA
        );

        return servicios.stream()
            .filter(servicio -> servicio.verificarDisponibilidad())
            .filter(servicio -> {
                Ubicacion ubicacionServicio = new Ubicacion(
                    servicio.getId(),
                    servicio.getLatitud(),
                    servicio.getLongitud(),
                    TipoUbicacion.BASE_SERVICIO
                );
                return calcularDistancia(ubicacionEmergencia, ubicacionServicio) <= radioMaximo;
            })
            .filter(servicio -> servicio.getTiempoEstimadoRespuesta() <= tiempoMaximoRespuesta)
            .collect(Collectors.toList());
    }
} 