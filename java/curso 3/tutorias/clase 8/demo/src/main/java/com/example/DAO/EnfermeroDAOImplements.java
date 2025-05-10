
import com.example.model.Enfermero;


public class EnfermeroDAOImplements implements  EnfermeroDAO {
    private List<Enfermero> enfermeros=new ArrayList<>();

    @Override
    public void guardar(Enfermero enfermero) {
        enfermeros.add(enfermero);
    }

    @Override
    public Enfermero buscarPorId(int id) {

       return enfermeros.stream().
       filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Enfermero> mostrarlista() {
       return enfermeros;
    }

}
