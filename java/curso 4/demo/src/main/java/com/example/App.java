package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal de la aplicación que implementa un menú interactivo
 * para gestionar una lista de elementos.
 */
public class App {

    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = getUserOption(scanner);
            processOption(option, items, scanner);
        } while (option != 5);

        scanner.close();
    }

    /**
     * Muestra el menú de opciones al usuario.
     */
    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Eliminar elemento");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Mostrar elementos");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    /**
     * Obtiene la opción seleccionada por el usuario.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @return La opción seleccionada por el usuario.
     */
    private static int getUserOption(Scanner scanner) {
        int option = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        return option;
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     * 
     * @param option Opción seleccionada por el usuario.
     * @param items Lista de elementos gestionada por el programa.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void processOption(int option, ArrayList<String> items, Scanner scanner) {
        switch (option) {
            case 1:
                addItem(items, scanner);
                break;
            case 2:
                removeItem(items, scanner);
                break;
            case 3:
                searchItem(items, scanner);
                break;
            case 4:
                showItems(items);
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Agrega un elemento a la lista.
     * 
     * @param items Lista de elementos.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void addItem(ArrayList<String> items, Scanner scanner) {
        System.out.print("Ingresa el elemento a agregar: ");
        String itemToAdd = scanner.nextLine();
        items.add(itemToAdd);
        System.out.println("Elemento agregado.");
    }

    /**
     * Elimina un elemento de la lista.
     * 
     * @param items Lista de elementos.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void removeItem(ArrayList<String> items, Scanner scanner) {
        System.out.print("Ingresa el elemento a eliminar: ");
        String itemToRemove = scanner.nextLine();
        if (items.remove(itemToRemove)) {
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    /**
     * Busca un elemento en la lista.
     * 
     * @param items Lista de elementos.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void searchItem(ArrayList<String> items, Scanner scanner) {
        System.out.print("Ingresa el elemento a buscar: ");
        String itemToSearch = scanner.nextLine();
        if (items.contains(itemToSearch)) {
            System.out.println("Elemento encontrado.");
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    /**
     * Muestra todos los elementos de la lista.
     * 
     * @param items Lista de elementos.
     */
    private static void showItems(ArrayList<String> items) {
        System.out.println("Elementos en la lista:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}