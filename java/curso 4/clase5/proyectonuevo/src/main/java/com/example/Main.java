package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
      List<producto> productos =  Arrays.asList(
        new producto("portatil", "computacion", 1200.0),
        new producto("cafeteria", "hogar", 50.0),
        new producto("smarfon", "electronica", 800.0),
        new producto("libro", "libreria", 40.0)  );
    
    System.out.println("/n/nla lista original de productos /n " + productos);
    List<String> productosFiltrados = productos.stream()
    .filter(p-> p.getPrecio() > 100)
    .map(p -> p.getNombre().toUpperCase())
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());

    System.out.println("laq lista original de productos filtrados /n " + productosFiltrados);

      for (producto producto : productos) {
        System.out.println(producto.getNombre() + " - " + producto.getCategoria() + " - " + producto.getPrecio());
      }
    }
}