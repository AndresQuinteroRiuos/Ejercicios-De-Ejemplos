
import java.util.Scanner;

public class archivojava {
    public static void main(String[] args) {
        int edad = 0;
        System.out.println("mi edad es: " + edad);

        edad = 15;
        System.out.println("mi edad es: " + edad);
        Scanner entrada = new Scanner(System.in);
        System.out.println("digite su nombre: ");
        String persona = entrada.nextLine();
        System.out.println("el nombre es: "+ persona);

       

        System.out.println("cuantos quieres aumentarle a la edad");
        edad = edad + entrada.nextInt();
       // int edadActualizada = edad + entrada.nextInt();
       
        System.out.println("la nueva edad es: "+ edad);
        
        entrada.close();
    }
}