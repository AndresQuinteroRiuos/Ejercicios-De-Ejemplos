package com.example;

public class Main {
    public static void main(String[] args) {
       Inventario inventario = new Inventario(5);
       try {
        inventario.agregarProducto(
            new Producto(  "101","martillo", 10));

            inventario.agregarProducto(
            new Producto(  "102","alicate", 10));

            inventario.agregarProducto(
                new Producto(  "103","llave inglesa", 10));
            
            
       }
       catch (ProductoExistentesExepcion e) {
        System.out.println("error: " + e.getMessage());
       }
       try {
        Producto p=inventario.buscarProducto("102");
       }
       catch (ProductoNoEncontradoExepcion e) {
        System.out.println("error: " + e.getMessage());
       }
    }

}