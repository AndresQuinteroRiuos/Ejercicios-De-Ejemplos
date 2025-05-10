public class examinarvuelo {
    
    private int numeroPasajeros;
    private int cantidadAlimentacion;
    private double combustibleEstable;
    private double proximidadAterrizaje;
    private double nivelOxigeno;
    private double velocidadKmH;

    // Constructor
    public AvionMonitor(int numeroPasajeros, int cantidadAlimentacion, double combustibleEstable, 
                        double proximidadAterrizaje, double nivelOxigeno, double velocidadKmH) {
        this.numeroPasajeros = numeroPasajeros;
        this.cantidadAlimentacion = cantidadAlimentacion;
        this.combustibleEstable = combustibleEstable;
        this.proximidadAterrizaje = proximidadAterrizaje;
        this.nivelOxigeno = nivelOxigeno;
        this.velocidadKmH = velocidadKmH;
    }

    // Métodos para monitorear el avión
    public void mostrarEstadoAvion() {
        System.out.println("Estado del Avión:");
        System.out.println("Número de Pasajeros: " + numeroPasajeros);
        System.out.println("Cantidad de Alimentación: " + cantidadAlimentacion);
        System.out.println("Combustible Estable: " + combustibleEstable + " litros");
        System.out.println("Proximidad al Aterrizaje: " + proximidadAterrizaje + " km");
        System.out.println("Nivel de Oxígeno: " + nivelOxigeno + " %");
        System.out.println("Velocidad: " + velocidadKmH + " km/h");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        AvionMonitor avion = new AvionMonitor(150, 300, 5000.0, 50.0, 21.0, 900.0);
        avion.mostrarEstadoAvion();
    }

}
