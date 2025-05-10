package Model.servicios;

public class Bomberos extends servicioEmergenciaBase {
    private int capacidadAgua;
    private boolean tieneEscalera;
    private boolean tieneEquipoRescate;
    private int cantidadExtintores;

    public Bomberos(String id, int personalDisponible, double combustible,
                   int capacidadAgua, boolean tieneEscalera,
                   boolean tieneEquipoRescate, int cantidadExtintores) {
        super(id, personalDisponible, combustible, capacidadAgua, 0.0, cantidadExtintores, 0.0, 0.0);
        this.capacidadAgua = capacidadAgua;
        this.tieneEscalera = tieneEscalera;
        this.tieneEquipoRescate = tieneEquipoRescate;
        this.cantidadExtintores = cantidadExtintores;
    }

    @Override
    public String getTipoServicio() {
        return "BOMBEROS";
    }

    @Override
    public void movilizarUnidad() {
        if (verificarDisponibilidad()) {
            this.estadoActual = "EN MOVIMIENTO";
            System.out.println("Unidad de bomberos " + id + " en movimiento hacia la emergencia");
            prepararEquipoExtincion();
        } else {
            System.out.println("Unidad de bomberos " + id + " no disponible para movilización");
        }
    }

    @Override
    public void reportarEstado() {
        System.out.println("Estado de la unidad de bomberos " + id + ":");
        System.out.println("- Personal disponible: " + personalDisponible);
        System.out.println("- Combustible: " + combustible);
        System.out.println("- Capacidad de agua: " + capacidadAgua);
        System.out.println("- Extintores disponibles: " + cantidadExtintores);
        System.out.println("- Estado: " + estadoActual);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return disponible && personalDisponible >= 4 && combustible > 0 && capacidadAgua > 0;
    }

    public void prepararEquipoExtincion() {
        System.out.println("Preparando equipo de extinción...");
        if (tieneEscalera) {
            System.out.println("Escalera preparada para uso");
        }
        if (tieneEquipoRescate) {
            System.out.println("Equipo de rescate preparado");
        }
    }

    public void realizarRescate() {
        if (tieneEquipoRescate && personalDisponible >= 2) {
            System.out.println("Realizando operación de rescate...");
            this.personalDisponible -= 2;
        } else {
            System.out.println("No se puede realizar rescate - equipo o personal insuficiente");
        }
    }

    public void usarExtintor() {
        if (cantidadExtintores > 0) {
            System.out.println("Usando extintor...");
            this.cantidadExtintores--;
        } else {
            System.out.println("No hay extintores disponibles");
        }
    }

    // Getters y Setters
    public int getCapacidadAgua() {
        return capacidadAgua;
    }

    public void setCapacidadAgua(int capacidadAgua) {
        this.capacidadAgua = capacidadAgua;
    }

    public boolean isTieneEscalera() {
        return tieneEscalera;
    }

    public void setTieneEscalera(boolean tieneEscalera) {
        this.tieneEscalera = tieneEscalera;
    }

    public boolean isTieneEquipoRescate() {
        return tieneEquipoRescate;
    }

    public void setTieneEquipoRescate(boolean tieneEquipoRescate) {
        this.tieneEquipoRescate = tieneEquipoRescate;
    }

    public int getCantidadExtintores() {
        return cantidadExtintores;
    }

    public void setCantidadExtintores(int cantidadExtintores) {
        this.cantidadExtintores = cantidadExtintores;
    }
} 