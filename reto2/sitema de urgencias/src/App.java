import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enumeración para los niveles de gravedad
enum NivelGravedad {
    BAJA, MEDIA, ALTA;
}

// Clase Emergencia
class Emergencia {
    private String tipo;
    private String ubicacion;
    private NivelGravedad gravedad;
    private int tiempoMaxRespuesta;
    private boolean enAtencion;
    private boolean finalizada;
    private long tiempoInicioAtencion;
    private long tiempoFinalizacion;

    public Emergencia(String tipo, String ubicacion, NivelGravedad gravedad, int tiempoMaxRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.tiempoMaxRespuesta = tiempoMaxRespuesta;
        this.enAtencion = false;
        this.finalizada = false;
    }

    public void atender() {
        if (!finalizada && !enAtencion) {
            enAtencion = true;
            tiempoInicioAtencion = System.currentTimeMillis();
            System.out.println("Emergencia en atención: " + tipo + " en " + ubicacion);
        } else {
            System.out.println("La emergencia ya está en atención o ha sido finalizada.");
        }
    }

    public void finalizar() {
        if (enAtencion && !finalizada) {
            tiempoFinalizacion = System.currentTimeMillis();
            finalizada = true;
            System.out.println("Emergencia finalizada: " + tipo + " en " + ubicacion);
            System.out.println("Tiempo total de atención: " + (tiempoFinalizacion - tiempoInicioAtencion) / 1000 + " segundos");
        } else {
            System.out.println("La emergencia no está en atención o ya ha sido finalizada.");
        }
    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    public String getTipo() {
        return tipo;
    }

    public NivelGravedad getGravedad() {
        return gravedad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return tipo + " en " + ubicacion + " - Gravedad: " + gravedad +
                " | Estado: " + (finalizada ? "Finalizada" : enAtencion ? "En atención" : "Pendiente");
    }
}

// Clase principal de la aplicación
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Emergencia> emergencias = new ArrayList<>();

    public static void main(String[] args) {
        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            ejecutando = procesarOpcion(opcion);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Gestión de Emergencias Urbanas");
        System.out.println("1. Registrar nueva emergencia");
        System.out.println("2. Listar emergencias");
        System.out.println("3. Atender emergencia");
        System.out.println("4. Finalizar emergencia");
        System.out.println("5. Mostrar estadísticas");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarEmergencia();
            case 2 -> listarEmergencias();
            case 3 -> atenderEmergencia();
            case 4 -> finalizarEmergencia();
            case 5 -> mostrarEstadisticas();
            case 6 -> {
                System.out.println("Saliendo del sistema...");
                return false;
            }
            default -> System.out.println("Opción no válida. Intente de nuevo.");
        }
        return true;
    }

    private static void registrarEmergencia() {
        System.out.print("Ingrese el tipo de emergencia (Accidente, Incendio, Robo): ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese la ubicación de la emergencia: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Seleccione el nivel de gravedad (BAJA, MEDIA, ALTA): ");
        NivelGravedad gravedad;
        try {
            gravedad = NivelGravedad.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel de gravedad inválido. Se asignará BAJA por defecto.");
            gravedad = NivelGravedad.BAJA;
        }
        System.out.print("Ingrese el tiempo máximo de respuesta (en minutos): ");
        int tiempoMax = scanner.nextInt();
        scanner.nextLine(); 

        emergencias.add(new Emergencia(tipo, ubicacion, gravedad, tiempoMax));
        System.out.println("Emergencia registrada con éxito.");
    }

    private static void listarEmergencias() {
        if (emergencias.isEmpty()) {
            System.out.println("No hay emergencias registradas.");
        } else {
            System.out.println("\nLista de emergencias:");
            emergencias.forEach(System.out::println);
        }
    }

    private static void atenderEmergencia() {
        System.out.print("Ingrese la ubicación de la emergencia a atender: ");
        String ubicacion = scanner.nextLine();
        for (Emergencia e : emergencias) {
            if (e.getUbicacion().equalsIgnoreCase(ubicacion) && !e.estaFinalizada()) {
                e.atender();
                return;
            }
        }
        System.out.println("No se encontró una emergencia pendiente con esa ubicación.");
    }

    private static void finalizarEmergencia() {
        System.out.print("Ingrese la ubicación de la emergencia a finalizar: ");
        String ubicacion = scanner.nextLine();
        for (Emergencia e : emergencias) {
            if (e.getUbicacion().equalsIgnoreCase(ubicacion) && !e.estaFinalizada()) {
                e.finalizar();
                return;
            }
        }
        System.out.println("No se encontró una emergencia en atención con esa ubicación.");
    }

    private static void mostrarEstadisticas() {
        long total = emergencias.size();
        long atendidas = emergencias.stream().filter(Emergencia::estaFinalizada).count();
        long pendientes = total - atendidas;
        System.out.println("\nEstadísticas:");
        System.out.println("Total de emergencias: " + total);
        System.out.println("Emergencias atendidas: " + atendidas);
        System.out.println("Emergencias pendientes: " + pendientes);
    }
}
