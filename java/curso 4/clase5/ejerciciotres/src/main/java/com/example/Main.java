package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       List<Venta> ventas = List.of(
        new Venta("cliente1", "Producto A", "electronica", 3, 100),
        new Venta("cliente2", "Producto B", "hogar", 5, 350),
        new Venta("cliente3", "Producto C", "electronica", 1, 1000)     
       );

       Map<String, List<Venta>> ventaporcategoria = ventas.stream()
       .collect(Collectors.groupingBy(Venta::getCategoria));

       ventaporcategoria.forEach((categoria, listaventas) -> {
        System.out.println("Categoria: " + categoria);
        listaventas.forEach(v -> System.out.println(" - "+ v));
       });
    }
}