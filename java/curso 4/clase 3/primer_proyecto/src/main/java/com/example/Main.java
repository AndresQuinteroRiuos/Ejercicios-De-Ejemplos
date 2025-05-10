package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       //stream<String>nombre=List.of("Juan","Maria","Pedro","Ana").stream();
       
       //operaciones intermedias.
       List<String> nombre=List.of("Juan","Maria","Pedro");

        /*
         * operaciones intermedias:
         * filter(): filtra los elementos de la lista.
         * map(): transforma los elementos de la lista.
         * sorted(): ordena los elementos de la lista.
         * distinct(): elimina los elementos duplicados de la lista.
         * limit(): limita el numero de elementos de la lista.
         * skip(): controla los elementos de la lista.
         */

         //creeamos una lista de nombres de tipo "string".
         List<String> nombres=List.of("Juan","Maria","Pedro","Ana");

         //IMPRIMIR LOS ELEMENTOS DE LA LISTA ORIGINAL
         System.out.println(".(lista original):");
         nombres.forEach(System.out::println);

         //anunciamos el inicio de la ejecucion de las operaciones intermedias en stream.
         System.out.println(".(procesamiento del stream):");

        //iniciar un stream de la lista de "nombres"
        nombres.stream()
        //aplicamos la operacion intermedia filter para dejar solo los nombres que inician con "A"
        .filter(n -> {
            System.out.println("filtro evaluando:" + n);
            return n.startsWith("A");
        })
        //permitir ver los datos de la lista despues de aplicar el filtro.
        .peek(n -> {
            System.out.println("despues del filtro:" + n);
        })
        //convertir a mayusculas los valores que cumplen con el filtro.
        .map(n -> {
                String upper = n.toUpperCase();
                System.out.println("convertido a mayusculas:" + upper);
                return upper;
        })
        //aplicamos la operacion intermedia map para transformar los elementos de la lista
        .map(n -> {
            System.out.println("mapeado:" + n);
            return n.toUpperCase();
        })
        //operaciones terminales:
         /*
         * forEach(): imprime los elementos de la lista.
         * count(): cuenta los elementos de la lista.
         * collect(): recolecta los elementos de la lista.
        /*
         * 
         * 
         * 
         * 
         * 
         */
        
       // nombres.stream().filter(n->n.equals("Juan")).forEach(System.out::println);

       
    
    
    //eliminar los elementos duplicados de la lista.
    .distinct()
    //ver los datos de la lista despues de eliminar los duplicados.
    .peek(n -> System.out.println("lista despues del distinct:" + n))
    //ordenar alfabeticamente los nombres resultantes.
    .sorted()
    //ver los datos de la lista despues de ordenarlos.
    .peek(n -> System.out.println("lista despues del sorted:" + n))
   
    /*
     * imprimir los nombres resultantes del stream por consola, para ello se utiliza
     * el metodo forEach: imprime ->cerramos el stream-> producir el 
     * resultado
     */
    .forEach(n -> System.out.println("resultado final:" + n));
    }
}
