package Model.estrategias;

import Model.emergencias.emergenciaBase;
import java.util.List;

public interface PriorizacionStrategy {
    List<emergenciaBase> priorizar(List<emergenciaBase> emergencias);
} 