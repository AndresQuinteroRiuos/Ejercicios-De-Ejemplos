public class Ejercicio6 {
    public static void main(String[] args) {
        double precioConDescuento = 34.00;
        double descuento = 0.15;
        double precioOriginal = precioConDescuento / (1 - descuento);

        System.out.println("El precio original de los pantalones era: " + precioOriginal + " E");
    }

}
