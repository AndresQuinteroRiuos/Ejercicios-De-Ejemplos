

public class App {
    public static void main(String[] args) {
        calculadoracomision calculadora=new calculadoracomision(5000,0.1);
        double comision =calculadora.calculadoracomision();
        System.out.println("la comicion de esta venta es: " + comision);

    }
}
    class calculadoracomision {
        private double montoventas;
        private double tasacomision;

        public calculadoracomision(double montoventas, double tasacomision){ 
            this.montoventas=montoventas;
            this.tasacomision=tasacomision;

        }

        public double calculadoracomision() {
            return montoventas*tasacomision;
        }
    }

