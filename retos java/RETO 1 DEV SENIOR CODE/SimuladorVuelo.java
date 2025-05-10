//package retos java.RETO 1 DEV SENIOR CODE;
import java.util.Scanner;
public class SimuladorVuelo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] planetas = {"Mercurio", "Venus",  "Marte", "Júpiter",    "Saturno",   "urano","neptupno"};
        double[] distancias = {77000000, 108200000, 225000000, 628000000, 1429000000, 287000000, 435000000}; // Distancias en km

        System.out.println("Selecciona tu destino:");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i]);
        }

        int eleccion = scanner.nextInt();
        if (eleccion < 1 || eleccion > planetas.length) {
            System.out.println("Selección inválida.");
            return;
        }

        String planetaSeleccionado = planetas[eleccion - 1];
        double distancia = distancias[eleccion - 1];
        System.out.println("Has seleccionado: " + planetaSeleccionado);
        System.out.println("Distancia desde la Tierra: " + distancia + " km");
        
        // Calcular tiempo de viaje
        double velocidad = 100000; // km/h
        double tiempoViaje = distancia / velocidad;
        System.out.println("Tiempo estimado de viaje: " + tiempoViaje + " horas");

        // Llamar a otros métodos para continuar con la simulación
        gestionarRecursos(distancia);
        simularEventosAleatorios();
        monitorearEstadoViaje(tiempoViaje, distancia);
    }

    // Métodos adicionales para gestionar recursos, simular eventos aleatorios y monitorear el estado del viaje
    public static void gestionarRecursos(double distancia) {
        // Supongamos que la nave consume 0.1 unidades de combustible por km y 0.05 unidades de oxígeno por km
        double combustibleNecesario = distancia * 0.55;
        double oxigenoNecesario = distancia * 0.05;
    
        System.out.println("Combustible necesario: " + combustibleNecesario + " unidades");
        System.out.println("Oxígeno necesario: " + oxigenoNecesario + " unidades");
    
        // Permitir al usuario ajustar recursos (se podría implementar una lógica adicional aquí)
    }
    public static void simularEventosAleatorios() {
        // Generar eventos aleatorios (por ejemplo, utilizando la clase Random)
        System.out.println("Simulación de eventos aleatorios en progreso...");
        // Lógica de eventos aleatorios aquí
    }
    public static void monitorearEstadoViaje(double tiempoViaje, double distancia) {
        // Monitorear el progreso del viaje
        System.out.println("Monitoreando el estado del viaje...");
        // Lógica de monitoreo aquí
    }
         
}
