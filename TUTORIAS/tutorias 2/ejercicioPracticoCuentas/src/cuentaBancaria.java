public class cuentaBancaria implements cuenta{
      //atributos
 
        public int numeroCuenta;
        public double saldo;

        public  cuentaBancaria(int numeroCuenta, double saldo){
            this.numeroCuenta=numeroCuenta;
            this.saldo=saldo;
        } 
        public void depositar(double saldo){
            if (saldo>0){
             this.saldo+=saldo;
             System.out.println("saldo depositado con exito: "+consultarSaldo());

            }else{
                System.out.println("por favor digite una cantidad valida");
            }
}
       

    @Override
           
        public  void retirar(double cantidad){
            if (cantidad> 0 && cantidad <=this.saldo){
                this.saldo-=cantidad;
                System.out.println("se retiro con exito");


            }else {
                System.out.println("fondos insuficientes");
            }
        }
        @Override
        public double consultarSaldo(){
            return saldo;
        }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cuentaBancaria{");
        sb.append("numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }


}
