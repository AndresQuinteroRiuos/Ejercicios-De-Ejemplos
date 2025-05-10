package Model.servicios;

public class Policia extends servicioEmergenciaBase {
    private boolean tieneEquipoTactico;
    private boolean tieneEquipoComunicaciones;
    private int cantidadArmas;
    private int cantidadChalecos;

    public Policia(String id, int personalDisponible, double combustible,
                  boolean tieneEquipoTactico, boolean tieneEquipoComunicaciones,
                  int cantidadArmas, int cantidadChalecos) {
        super(id, personalDisponible, combustible, 0, 0.0, 0, 0.0, 0.0);
        this.tieneEquipoTactico = tieneEquipoTactico;
        this.tieneEquipoComunicaciones = tieneEquipoComunicaciones;
        this.cantidadArmas = cantidadArmas;
        this.cantidadChalecos = cantidadChalecos;
    }

    @Override
    public String getTipoServicio() {
        return "POLICIA";
    }

    @Override
    public void movilizarUnidad() {
        if (verificarDisponibilidad()) {
            this.estadoActual = "EN MOVIMIENTO";
            System.out.println("Unidad policial " + id + " en movimiento hacia la emergencia");
            prepararEquipoTactico();
        } else {
            System.out.println("Unidad policial " + id + " no disponible para movilización");
        }
    }

    @Override
    public void reportarEstado() {
        System.out.println("Estado de la unidad policial " + id + ":");
        System.out.println("- Personal disponible: " + personalDisponible);
        System.out.println("- Combustible: " + combustible);
        System.out.println("- Armas disponibles: " + cantidadArmas);
        System.out.println("- Chalecos disponibles: " + cantidadChalecos);
        System.out.println("- Estado: " + estadoActual);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return disponible && personalDisponible >= 2 && combustible > 0 && 
               cantidadArmas >= personalDisponible && cantidadChalecos >= personalDisponible;
    }

    public void prepararEquipoTactico() {
        System.out.println("Preparando equipo táctico...");
        if (tieneEquipoTactico) {
            System.out.println("Equipo táctico preparado");
        }
        if (tieneEquipoComunicaciones) {
            System.out.println("Equipo de comunicaciones preparado");
        }
    }

    public void realizarIntervencion() {
        if (personalDisponible >= 2 && tieneEquipoTactico) {
            System.out.println("Realizando intervención policial...");
            this.personalDisponible -= 2;
        } else {
            System.out.println("No se puede realizar intervención - personal o equipo insuficiente");
        }
    }

    public void establecerCordon() {
        if (personalDisponible >= 4) {
            System.out.println("Estableciendo cordón de seguridad...");
            this.personalDisponible -= 4;
        } else {
            System.out.println("No hay suficiente personal para establecer cordón");
        }
    }

    // Getters y Setters
    public boolean isTieneEquipoTactico() {
        return tieneEquipoTactico;
    }

    public void setTieneEquipoTactico(boolean tieneEquipoTactico) {
        this.tieneEquipoTactico = tieneEquipoTactico;
    }

    public boolean isTieneEquipoComunicaciones() {
        return tieneEquipoComunicaciones;
    }

    public void setTieneEquipoComunicaciones(boolean tieneEquipoComunicaciones) {
        this.tieneEquipoComunicaciones = tieneEquipoComunicaciones;
    }

    public int getCantidadArmas() {
        return cantidadArmas;
    }

    public void setCantidadArmas(int cantidadArmas) {
        this.cantidadArmas = cantidadArmas;
    }

    public int getCantidadChalecos() {
        return cantidadChalecos;
    }

    public void setCantidadChalecos(int cantidadChalecos) {
        this.cantidadChalecos = cantidadChalecos;
    }
} 