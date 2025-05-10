package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Una aplicación Java simple que demuestra operaciones básicas con listas
 * incluyendo iteración y reducción.
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final Random random = new Random();

    /**
     * Genera una lista de números aleatorios.
     * 
     * @return Lista de números enteros aleatorios
     */
    private static List<Integer> createNumberList() {
        logger.debug("Generando lista de números aleatorios");
        List<Integer> numbers = new ArrayList<>();
        
        // Generar entre 5 y 15 números aleatorios
        int cantidadNumeros = random.nextInt(11) + 5; // 5-15 números
        logger.info("Generando {} números aleatorios", cantidadNumeros);
        
        for (int i = 0; i < cantidadNumeros; i++) {
            int numero = random.nextInt(100) + 1; // Números entre 1 y 100
            numbers.add(numero);
            logger.debug("Número aleatorio generado: {}", numero);
        }
        
        return numbers;
    }

    /**
     * Imprime cada número de la lista.
     * 
     * @param numbers Lista de números enteros a imprimir
     */
    private static void printNumbers(List<Integer> numbers) {
        logger.info("Imprimiendo lista de números aleatorios");
        System.out.println("\nLista de números generados:");
        numbers.forEach(numero -> System.out.print(numero + " "));
        System.out.println("\n");
    }

    /**
     * Calcula la suma de todos los números en la lista.
     * 
     * @param numbers Lista de números enteros a sumar
     * @return Suma de todos los números
     */
    private static int calculateSum(List<Integer> numbers) {
        logger.debug("Calculando suma de números");
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    /**
     * Calcula el promedio de los números en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Promedio de los números
     * @throws IllegalArgumentException si la lista es null o vacía
     */
    private static double calculateAverage(List<Integer> numbers) {
        logger.debug("Calculando promedio de números");
        
        if (numbers == null) {
            logger.error("La lista de números es null");
            throw new IllegalArgumentException("La lista de números no puede ser null");
        }
        
        if (numbers.isEmpty()) {
            logger.error("La lista de números está vacía");
            throw new IllegalArgumentException("La lista de números no puede estar vacía");
        }
        
        // Calcular la suma usando long para evitar overflow
        long suma = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();
        
        // Calcular el promedio con mayor precisión
        double promedio = (double) suma / numbers.size();
        
        logger.debug("Promedio calculado: {} (suma: {}, cantidad: {})", 
                    promedio, suma, numbers.size());
        
        return promedio;
    }

    /**
     * Encuentra el número mínimo en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Número mínimo
     */
    private static int findMin(List<Integer> numbers) {
        logger.debug("Buscando número mínimo");
        return numbers.stream()
                .min(Integer::compare)
                .orElse(0);
    }

    /**
     * Encuentra el número máximo en la lista.
     * 
     * @param numbers Lista de números enteros
     * @return Número máximo
     */
    private static int findMax(List<Integer> numbers) {
        logger.debug("Buscando número máximo");
        return numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static void main(String[] args) {
        logger.info("Iniciando aplicación");
        
        try {
            List<Integer> numeros = createNumberList();
            printNumbers(numeros);
            
            int suma = calculateSum(numeros);
            double promedio = calculateAverage(numeros);
            int minimo = findMin(numeros);
            int maximo = findMax(numeros);
            
            logger.info("Resultados calculados - Suma: {}, Promedio: {:.2f}, Mínimo: {}, Máximo: {}", 
                       suma, promedio, minimo, maximo);
            
            System.out.println("Resultados:");
            System.out.println("Suma total: " + suma);
            System.out.println("Promedio: " + String.format("%.2f", promedio));
            System.out.println("Número mínimo: " + minimo);
            System.out.println("Número máximo: " + maximo);
            
        } catch (IllegalArgumentException e) {
            logger.error("Error en el cálculo del promedio: {}", e.getMessage());
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error en la aplicación: ", e);
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
        
        logger.info("Finalizando aplicación");
    }
}