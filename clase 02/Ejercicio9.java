import java.util.Scanner;

public class Ejercicio9 {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;

        System.out.println("Temperatura en Fahrenheit: " + fahrenheit);
        System.out.println("Temperatura en Kelvin: " + kelvin);
    }

}
