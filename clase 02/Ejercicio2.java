public class Ejercicio2 {
    public static void main(String[] args) {
        double precioPorCienGramos = 5.95;
        double precioPorKilogramo = precioPorCienGramos * 10;

        System.out.println("El precio por kilogramo es: " + precioPorKilogramo + " E");

        double precioVendedor = 29.75;
        if(precioPorKilogramo == precioVendedor) {
            System.out.println("El precio proporcionado por el vendedor es correcto.");
        } else {
            System.out.println("El precio proporcionado por el vendedor es incorrecto.");
        }
    }
}
