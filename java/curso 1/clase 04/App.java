

public class App {
    
    public static void main(String[] args) throws Exception{
      var factura=10;
      var descuento=15;
      if (factura < descuento){
        var saldo=factura-descuento;
        System.out.printf( "total es: %d%n", saldo);
      }
      if (factura < descuento){
        System.out.printf(  "total es :  %d%n", factura);

        //System.out.println("error, el descuento es mayor al valor de la factura");
      }

    }
}
