package Model.servicios;

public class Policia extends servicioEmergenciaBase {
    private int cantidadPatrullas;
    private boolean tieneUnidadK9;
    private int cantidadArmas;
    private boolean tieneEquipoAntidisturbios;

    public Policia(String id, int personalDisponible, double combustible,
                  int cantidadPatrullas, boolean tieneUnidadK9,
                  int cantidadArmas, boolean tieneEquipoAntidisturbios) {
        this.id = id;
        this.personalDisponible = personalDisponible;
        this.combustible = combustible;
        this.cantidadPatrullas = cantidadPatrullas;
        this.tieneUnidadK9 = tieneUnidadK9;
        this.cantidadArmas = cantidadArmas;
        this.tieneEquipoAntidisturbios = tieneEquipoAntidisturbios;
    }

    public void realizarPatrullaje() {
        System.out.println("Iniciando patrullaje en la zona...");
    }

    public void desplegarUnidadK9() {
        if (tieneUnidadK9) {
            System.out.println("Desplegando unidad K9 para búsqueda...");
        } else {
            System.out.println("No se cuenta con unidad K9 disponible");
        }
    }

    public void controlarDisturbios() {
        if (tieneEquipoAntidisturbios) {
            System.out.println("Desplegando equipo antidisturbios...");
        } else {
            System.out.println("No se cuenta con equipo antidisturbios");
        }
    }

    // Getters y Setters
    public int getCantidadPatrullas() {
        return cantidadPatrullas;
    }

    public void setCantidadPatrullas(int cantidadPatrullas) {
        this.cantidadPatrullas = cantidadPatrullas;
    }

    public boolean isTieneUnidadK9() {
        return tieneUnidadK9;
    }

    public void setTieneUnidadK9(boolean tieneUnidadK9) {
        this.tieneUnidadK9 = tieneUnidadK9;
    }

    public int getCantidadArmas() {
        return cantidadArmas;
    }

    public void setCantidadArmas(int cantidadArmas) {
        this.cantidadArmas = cantidadArmas;
    }

    public boolean isTieneEquipoAntidisturbios() {
        return tieneEquipoAntidisturbios;
    }

    public void setTieneEquipoAntidisturbios(boolean tieneEquipoAntidisturbios) {
        this.tieneEquipoAntidisturbios = tieneEquipoAntidisturbios;
    }
} 