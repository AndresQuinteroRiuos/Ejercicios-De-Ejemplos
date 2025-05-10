package com.example;

public class Venta {
    private String cliente;
    private String producto;
    private String categoria;
    private int cantidad;
    private double precio;

    public Venta(String cliente, String producto, String categoria, int cantidad, double precio) {
        this.cliente = cliente;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTotal() {
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", Producto: " + producto + 
               ", Cantidad: " + cantidad + ", Precio: " + precio +
               ", Total: " + getTotal();
    }
} 