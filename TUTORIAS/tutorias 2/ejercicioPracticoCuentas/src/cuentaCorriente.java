public class cuentaCorriente extends  cuentaBancaria {
    
    public double limiteSobreGiro;

    public cuentaCorriente(int numeroCuenta, double saldo, double limiteSobreGiro) {
        super(numeroCuenta, saldo);
        this.limiteSobreGiro=limiteSobreGiro;
    }

    @Override
    public String toString() {
        return "cuentaCorriente [numeroCuenta=" + numeroCuenta + ", limiteSobreGiro=" + limiteSobreGiro + ", saldo="
                + saldo + "]";
    }

    

}
