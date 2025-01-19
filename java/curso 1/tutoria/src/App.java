
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      /*
       * System.out.println("Hello, World!");
       
        System.out.println("introduce tu nombre: ");
        String name=scanner.nextLine();

         System.out.println("digite el numero: ");
         int num1 =scanner.nextInt(); 

         

         
       */
        Scanner scanner=new Scanner(System.in);
         double Iva = 0.19;

         System.out.print("digite el valor del producto: ");
         double num1=scanner.nextDouble();
         
         double divisible = num1 * Iva;
         System.out.println("el valor del iva es:  " +divisible+" pesos");

         







    }
}
