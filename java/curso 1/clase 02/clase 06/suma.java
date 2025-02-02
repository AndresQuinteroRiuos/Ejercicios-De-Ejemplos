//package java.curso 1.clase 06;

public class suma {
    public static void main(String[] args) {
        
        // declarar e inicializar un arreglo de enteros
        int[]numeros={1,2,3,4,5};
        int suma =0;
        // calcular la suma de los elementos del arreglo
        for (int i = 0; i < numeros.length; i++) {
            suma +=numeros[i];//sumar cada elemento
            
        }
        //mostrar el resultado
        System.out.println("la suma de los elementos del arreglo es; "+suma);
    }
}
