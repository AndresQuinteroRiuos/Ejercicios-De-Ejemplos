//package java.curso 1.clase 06;

import java.util.function.BiFunction;

public class lambda2 {
    public static void main(String[] args) {
        BiFunction <Integer,Integer,Integer> suma=(a,b)->a+b;
        //llamada a la funcion utilizando los parametros directamente
        int resultado=suma.apply(5,3);
        System.err.println("resultado: "+resultado);
    }
}
