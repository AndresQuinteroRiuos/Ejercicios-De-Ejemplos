public class cuentaAhorros extends cuentaBancaria{
    public double tasaInteres;
    public cuentaAhorros(int  numeroCuenta, double saldo,double tasaInteres){
        super(numeroCuenta,saldo);
        this.tasaInteres=tasaInteres;
    }
    public void aplicarInteres(){
        double interes = saldo * tasaInteres/100;
        saldo +=interes;
        System.out.println("interes aplicado. numero saldo: "+saldo);
    }
    @Override
    public String toString() {
        return "cuentaAhorros [tasaInteres=" + tasaInteres + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo
                + ", consultarSaldo()=" + consultarSaldo() + "]";
    }

    
}
