package Model.estrategias;

import Model.emergencias.emergenciaBase;
import utils.nivelGravedad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorizacionPorGravedad implements PriorizacionStrategy {
    @Override
    public List<emergenciaBase> priorizar(List<emergenciaBase> emergencias) {
        List<emergenciaBase> emergenciasOrdenadas = new ArrayList<>(emergencias);
        emergenciasOrdenadas.sort(new Comparator<emergenciaBase>() {
            @Override
            public int compare(emergenciaBase e1, emergenciaBase e2) {
                return getPrioridad(e2.getNivelGravedad()) - getPrioridad(e1.getNivelGravedad());
            }

            private int getPrioridad(nivelGravedad gravedad) {
                switch (gravedad) {
                    case CRITICA: return 4;
                    case ALTA: return 3;
                    case MEDIA: return 2;
                    case BAJA: return 1;
                    default: return 0;
                }
            }
        });
        return emergenciasOrdenadas;
    }
} 