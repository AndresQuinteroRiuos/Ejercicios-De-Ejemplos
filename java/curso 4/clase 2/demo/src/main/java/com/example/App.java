package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;>>>
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        logger.setLevel(Level.INFO);

        Set<Integer> edades = new HashSet<>(Arrays.asList(25, 30, 25));
        imprimirSet("Edades", edades);

        Map<Integer, String> empleados = new HashMap<>();
        empleados.put(1, "Ana");
        empleados.put(2, "Luis");
        empleados.put(3, "Carlos");
        imprimirMapa("Empleado", empleados);

        List<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes", "Miercoles"));
        imprimirLista("Dias", dias);

        accederElementoLista(dias, 2);
        accederElementoLista(dias, 3);

        List<String> lista2 = new LinkedList<>(Arrays.asList("Uno", "Dos", "Tres"));

        removerElemento(lista2, 1);
        removerElemento(lista2, 10);
        imprimirLista("Lista 2", lista2);

        Set<String> frutasHash = new HashSet<>(Arrays.asList("Manzana", "Banana", "Pera"));
        imprimirSet("Frutas (HashSet)", frutasHash);

        Set<String> frutasTree = new TreeSet<>(Arrays.asList("Manzana", "Banana", "Pera"));
        imprimirSet("Frutas (TreeSet)", frutasTree);

        Map<Integer, String> mapa1 = new HashMap<>();
        mapa1.put(2, "Luis");
        mapa1.put(1, "Ana");
        mapa1.put(3, "Carlos");
        imprimirMapa("Mapa1 (HashMap)", mapa1);

        Map<Integer, String> mapa2 = new TreeMap<>();
        mapa2.put(3, "Carlos");
        mapa2.put(2, "Luis");
        mapa2.put(1, "Ana");
        imprimirMapa("Mapa2 (TreeMap)", mapa2);

    }

    private static <T> void imprimirSet(String nombre, Set<T> conjunto) {
        logger.info("Imprimiendo conjunto " + nombre);
        for (T elemento : conjunto) {
            System.out.println(nombre + " -> " + elemento);
        }
    }

    private static <T> void imprimirLista(String nombre, List<T> lista) {
        logger.info("Imprimiendo lista " + nombre);
        for (T elemento : lista) {
            System.out.println(nombre + " -> " + elemento);
        }
    }

    private static <K, V> void imprimirMapa(String nombre, Map<K, V> mapa) {
        logger.info("Imprimiendo Mapa " + mapa);
        for (Map.Entry<K, V> entry : mapa.entrySet()) {
            System.out.println(nombre + " -> Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
    }

    private static <T> void accederElementoLista(List<T> lista, int indice) {
        if (indice >= 0 && indice < lista.size()) {
            System.out.println("Elemento en indice: " + indice + ": " + lista.get(indice));
        } else {
            logger.warning("Indice fuera de rango: " + indice + "(Tamaño: " + lista.size() + ")");
        }
    }

    private static <T> void removerElemento(List<T> lista, int indice) {
        if (indice >= 0 && indice < lista.size()) {
            T eliminado = lista.remove(indice);
            logger.info("Elemento eliminado: " + eliminado);
        } else {
            logger.warning("No se pudo eliminar. Indice fuera de rango: " + indice);
        }
    }
}
