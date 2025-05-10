package Model.servicios;

public class Bomberos extends servicioEmergenciaBase {
    private int cantidadCamiones;
    private int cantidadMangueras;
    private boolean tieneEscalera;
    private int capacidadAgua; // en litros

    public Bomberos(String id, int personalDisponible, double combustible, 
                   int cantidadCamiones, int cantidadMangueras, 
                   boolean tieneEscalera, int capacidadAgua) {
        this.id = id;
        this.personalDisponible = personalDisponible;
        this.combustible = combustible;
        this.cantidadCamiones = cantidadCamiones;
        this.cantidadMangueras = cantidadMangueras;
        this.tieneEscalera = tieneEscalera;
        this.capacidadAgua = capacidadAgua;
    }

    public void recargarAgua() {
        System.out.println("Recargando agua en los camiones...");
        this.capacidadAgua = 10000; // Capacidad máxima en litros
    }

    public void desplegarEscalera() {
        if (tieneEscalera) {
            System.out.println("Desplegando escalera telescópica...");
        } else {
            System.out.println("No se cuenta con escalera telescópica");
        }
    }

    public void apagarIncendio() {
        if (capacidadAgua > 0) {
            System.out.println("Iniciando operación de extinción de incendio...");
            this.capacidadAgua -= 1000; // Consumo de agua aproximado
        } else {
            System.out.println("No hay suficiente agua para apagar el incendio");
        }
    }

    // Getters y Setters
    public int getCantidadCamiones() {
        return cantidadCamiones;
    }

    public void setCantidadCamiones(int cantidadCamiones) {
        this.cantidadCamiones = cantidadCamiones;
    }

    public int getCantidadMangueras() {
        return cantidadMangueras;
    }

    public void setCantidadMangueras(int cantidadMangueras) {
        this.cantidadMangueras = cantidadMangueras;
    }

    public boolean isTieneEscalera() {
        return tieneEscalera;
    }

    public void setTieneEscalera(boolean tieneEscalera) {
        this.tieneEscalera = tieneEscalera;
    }

    public int getCapacidadAgua() {
        return capacidadAgua;
    }

    public void setCapacidadAgua(int capacidadAgua) {
        this.capacidadAgua = capacidadAgua;
    }
} 