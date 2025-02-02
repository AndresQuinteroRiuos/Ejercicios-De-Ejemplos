
package java.curso 1.clase 05;

public class FuncionesSuma_Resta {
    public static void suma (){
        int a=5;
        int b=3;
        int resultado = a+b;
        System.out.println("la suma es: " +resultado);
    }

//metodo para realizar la resta
public static void resta (){
    int a=8;
    int b=2;
    int resultado = a-b;
    System.out.println("la resta es: " +resultado);
}

public static void main(String[] args) {
    //llamamos los metodos
    suma();
    resta();
}
}