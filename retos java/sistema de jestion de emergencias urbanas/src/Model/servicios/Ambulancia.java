package Model.servicios;

public class Ambulancia extends servicioEmergenciaBase {
    private int capacidadPacientes;
    private boolean tieneEquipoReanimacion;
    private boolean tieneEquipoTrauma;
    private int cantidadMedicamentos;

    public Ambulancia(String id, int personalDisponible, double combustible,
                     int capacidadPacientes, boolean tieneEquipoReanimacion,
                     boolean tieneEquipoTrauma, int cantidadMedicamentos) {
        this.id = id;
        this.personalDisponible = personalDisponible;
        this.combustible = combustible;
        this.capacidadPacientes = capacidadPacientes;
        this.tieneEquipoReanimacion = tieneEquipoReanimacion;
        this.tieneEquipoTrauma = tieneEquipoTrauma;
        this.cantidadMedicamentos = cantidadMedicamentos;
    }

    public void realizarPrimerosAuxilios() {
        System.out.println("Realizando primeros auxilios al paciente...");
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