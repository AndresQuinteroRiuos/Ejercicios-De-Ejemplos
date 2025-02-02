import java.util.Scanner;

public class Ejercicio4 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca palabra 1: ");
        String palabra1 = scanner.nextLine();

        System.out.print("Introduzca palabra 2: ");
        String palabra2 = scanner.nextLine();

        System.out.print("Introduzca palabra 3: ");
        String palabra3 = scanner.nextLine();

        System.out.println(palabra1 + " " + palabra2 + " " + palabra3);
        
        scanner.close();
    }

    
}
