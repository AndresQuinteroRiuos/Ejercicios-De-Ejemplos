package Model.servicios;

public class Ambulancia extends servicioEmergenciaBase {
    private int capacidadPacientes;
    private boolean tieneEquipoReanimacion;
    private boolean tieneEquipoTrauma;
    private int cantidadMedicamentos;

    public Ambulancia(String id, int personalDisponible, double combustible,
                     int capacidadPacientes, boolean tieneEquipoReanimacion,
                     boolean tieneEquipoTrauma, int cantidadMedicamentos) {
        super(id, personalDisponible, combustible, capacidadPacientes, 0.0, cantidadMedicamentos, 0.0, 0.0);
        this.capacidadPacientes = capacidadPacientes;
        this.tieneEquipoReanimacion = tieneEquipoReanimacion;
        this.tieneEquipoTrauma = tieneEquipoTrauma;
        this.cantidadMedicamentos = cantidadMedicamentos;
    }

    @Override
    public String getTipoServicio() {
        return "AMBULANCIA";
    }

    @Override
    public void movilizarUnidad() {
        if (verificarDisponibilidad()) {
            this.estadoActual = "EN MOVIMIENTO";
            System.out.println("Ambulancia " + id + " en movimiento hacia la emergencia");
            prepararEquipoReanimacion();
        } else {
            System.out.println("Ambulancia " + id + " no disponible para movilización");
        }
    }

    @Override
    public void reportarEstado() {
        System.out.println("Estado de la ambulancia " + id + ":");
        System.out.println("- Personal disponible: " + personalDisponible);
        System.out.println("- Combustible: " + combustible);
        System.out.println("- Capacidad de pacientes: " + capacidadPacientes);
        System.out.println("- Medicamentos disponibles: " + cantidadMedicamentos);
        System.out.println("- Estado: " + estadoActual);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return disponible && personalDisponible >= 2 && combustible > 0 && cantidadMedicamentos > 0;
    }

    public void realizarPrimerosAuxilios() {
        if (personalDisponible >= 2) {
            System.out.println("Realizando primeros auxilios al paciente...");
            this.personalDisponible -= 2;
        } else {
            System.out.println("No hay suficiente personal para realizar primeros auxilios");
        }
    }

    public void administrarMedicamento() {
        if (cantidadMedicamentos > 0) {
            System.out.println("Administrando medicamento...");
            this.cantidadMedicamentos--;
        } else {
            System.out.println("No hay medicamentos disponibles");
        }
    }

    public void prepararEquipoReanimacion() {
        if (tieneEquipoReanimacion) {
            System.out.println("Preparando equipo de reanimación...");
        } else {
            System.out.println("No se cuenta con equipo de reanimación");
        }
    }

    // Getters y Setters
    public int getCapacidadPacientes() {
        return capacidadPacientes;
    }

    public void setCapacidadPacientes(int capacidadPacientes) {
        this.capacidadPacientes = capacidadPacientes;
    }

    public boolean isTieneEquipoReanimacion() {
        return tieneEquipoReanimacion;
    }

    public void setTieneEquipoReanimacion(boolean tieneEquipoReanimacion) {
        this.tieneEquipoReanimacion = tieneEquipoReanimacion;
    }

    public boolean isTieneEquipoTrauma() {
        return tieneEquipoTrauma;
    }

    public void setTieneEquipoTrauma(boolean tieneEquipoTrauma) {
        this.tieneEquipoTrauma = tieneEquipoTrauma;
    }

    public int getCantidadMedicamentos() {
        return cantidadMedicamentos;
    }

    public void setCantidadMedicamentos(int cantidadMedicamentos) {
        this.cantidadMedicamentos = cantidadMedicamentos;
    }
} 