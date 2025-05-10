package Model.estrategias;

import Model.emergencias.emergenciaBase;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorizacionPorDistancia implements PriorizacionStrategy {
    private final String ubicacionBase;

    public PriorizacionPorDistancia(String ubicacionBase) {
        this.ubicacionBase = ubicacionBase;
    }

    @Override
    public List<emergenciaBase> priorizar(List<emergenciaBase> emergencias) {
        List<emergenciaBase> emergenciasOrdenadas = new ArrayList<>(emergencias);
        emergenciasOrdenadas.sort(new Comparator<emergenciaBase>() {
            @Override
            public int compare(emergenciaBase e1, emergenciaBase e2) {
                double distancia1 = calcularDistancia(e1.getUbicacion());
                double distancia2 = calcularDistancia(e2.getUbicacion());
                return Double.compare(distancia1, distancia2);
            }

            private double calcularDistancia(String ubicacion) {
                // Implementación simplificada de cálculo de distancia
                // En una implementación real, se usaría un servicio de geolocalización
                return Math.random() * 100; // Simulación de distancia
            }
        });
        return emergenciasOrdenadas;
    }
} 