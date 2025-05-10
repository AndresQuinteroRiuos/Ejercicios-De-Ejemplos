package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.model.Enfermero;
import com.example.service.EnfermeroService;
import com.example.utils.EnfermeroNoEncontradoEcxeptions;

public class EnfermeroServiceText {
    @Test
    public void registrarYObtenerEnfermeroText() throws EnfermeroNoEncontradoEcxeption {
        EnfermeroService Service = new EnfermeroServiceImpl();
        Enfermero enfermero1 = new Enfermero(1, "Ana Lopez");
        Enfermero encontrado=Service.obtenerEnfermeroPorId(1);
        assertEquals("Ana lopez", encontrado.getNombre());
       
       
    }
    @Test
    public void EnfermeroNoEncontradoTest (){
        EnfermeroService Service = new EnfermeroServiceImpl();
        assertThrows(EnfermeroNoEncontradoEcxeptions.class, () -> {
            
            Service.obtenerEnfermeroPorId(1);
        });
        assertNotNull(Service);
        }

}
