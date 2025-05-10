package com.example;

import java.util.concurrent.locks.Condition;
import java.util.stream.Stream;

public class Inventario {
    private static final System.Logger Logger = System.Logger.getLogger(Inventario.class.getName());

    public static System.Logger getLogger() {
        return Logger;
    }

private Producto[] productos;

private int contador;

public Inventario(int capacidad) {
    productos = new Producto[capacidad];
    this.contador = 0;
}
public void agregarProducto(Producto producto) throws  ProductoExistentesExepcion {
    if(buscarProductoPorCodigo(producto.getCodigo())!=null ){
        ((Object) Logger).warning("intento de agregar producto existente"+producto.getCodigo());
        throw new ProductoExistentesExepcion(   "EL Producto con codigo "+producto.getCodigo()+" ya existe" );
        
    }

if (contador < productos.length) {
    productos[contador ++  ] = producto;
    Logger.info("Producto agregado "+producto.getCodigo());
}
}
public Producto buscarProducto(String codigo) throws ProductoNoEncontradoExepcion {
   
    producto p=buscarProductoPorCodigo(codigo);
     if (p==null){
    Logger.severe("Producto no encontrado"+string);
    throw new ProductoNoEncontradoExepcion("Producto con codigo" +codigo+ "no encontrado";
   } 
   Logger.info("Producto encontrado");
   return p;
}
private Producto buscarProductoPorCodigo(String codigo) {
    for (int i = 0; i < contador; i++) {
        if (productos[i].getCodigo().equals(codigo)) {
            return productos[i];
        }
    }
    return null;
}
public void ListarProductos()  {
Logger.info(msg;"listando todos los productos.....");
for (int i = 0; i < contador; i++) {
    System.out.println(productos[i]);
}

}
}
