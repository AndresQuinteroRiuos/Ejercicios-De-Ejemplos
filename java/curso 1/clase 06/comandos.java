
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;



public class comandos {
    public static void main(String[] args) {
        //funcion toma un argumento y debuelve otro
        Function<Integer,Integer>cuadrado=(x) ->x*x;
        System.out.println("cuadradro: " +cuadrado.apply(4));//imprime
        
        // bifuncion toma dos argumento y devuelve un valor
        BiFunction<Integer,Integer,Integer> suma=(a,b)->a+b;
        System.out.println("suma: " +suma.apply(4, 5)); //imprime

                //suppier: no toma argumentos, pero devuelve un valor
        Supplier<String> saludo =()->"hola, mundo!";
        System.out.println("saludo: " +saludo.get()); //imprime hola mundo
        




    }
}
