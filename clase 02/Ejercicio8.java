import java.util.Scanner;

public class Ejercicio8 {
    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la longitud del rectángulo: ");
        double longitud = scanner.nextDouble();

        System.out.print("Introduce el ancho del rectángulo: ");
        double ancho = scanner.nextDouble();

        double area = longitud * ancho;
        double perimetro = 2 * (longitud + ancho);

        System.out.println("Área del rectángulo: " + area);
        System.out.println("Perímetro del rectángulo: " + perimetro);
    }

}
