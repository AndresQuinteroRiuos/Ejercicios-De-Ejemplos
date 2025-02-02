//package java.curso 1.clase 06;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class lambdasVarias {
    public static void main(String[] args) {
        //function: toma un argumento y devuelve un valor
        Function<Integer,Integer>cuadrado=(x) ->x*x;
        System.out.println("cuadrado: "+cuadrado.apply(4));//imprime

        //bifunction: toma dos argumentos y devuelve uno
        BiFunction<Integer, Integer, Integer>suma=(a,b)->a+b;
        System.out.println("suma: " +suma.apply(4, 5)); //imprime

        //suppier: no, toma argumentos pero devuelve un valor
        Supplier<String>saludo=()->"hola mundo!";
        System.out.println("saludo: "+saludo.get()); //imprime hola mundo

        //consumer; toma un argumento y no devuelve nada
        Consumer<String>imprimir=(x)->System.out.println(x);
        imprimir.accept(" ¡hola !"); // imprimme hola
        
    }
}
