



public class main {
   public static void main(String[] args) {

        cuentaBancaria cuenta1=new cuentaBancaria(131414141,2_000_000);
        cuenta1.depositar(500_000);
        cuenta1.retirar(400_000);
        cuenta1.consultarSaldo();

        System.out.println(cuenta1.toString());

        System.out.println("cuenta numero2");

        cuentaAhorros cuenta2= new cuentaAhorros(1214144, 5_000_000,2.5);

        cuenta2.aplicarInteres();

        persona persona1=new persona("daniel", 35, cuenta2);

        ///operaciones
        
        persona1.accesocuenta().depositar(1_000_000);
        ((cuentaAhorros)persona1.accesocuenta()).aplicarInteres();

        System.out.println(persona1.toString());

       }
}
