package com.example;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<String> nombres = java.util.List.of("andres", "juan", "edinson", "catalina ","Ana","beatriz");
        java.util.List<String> nombreMayuscula = nombres.stream()
        .filter(n -> n.length() > 5)
        .map(String::toUpperCase)
        .sorted()
        .collect(java.util.stream.Collectors.toList());
       
    System.out.println("cadena procesada con un pipeline de stream/n " + nombreMayuscula);
    System.out.println(nombreMayuscula);
    }

}