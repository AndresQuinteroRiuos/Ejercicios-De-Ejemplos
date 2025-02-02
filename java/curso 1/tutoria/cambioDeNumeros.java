
import java.util.Scanner;

public class cambioDeNumeros {
    /*pedir la8 personas en un arreglo, las sume y mostrar el
     resultadfopor consola, luego modificar la posicion 3, 
     sumar y mostrar nuevamente
     */
    public static void main(String[] args) throws Exception {
        int []arregloEdades=new int[3];
        int sumaEdades=0;
        int nuevoNumero=0;
        Scanner entrada=new Scanner(System.in);

        for (int i = 0; i< arregloEdades.length; i++){
            System.out.println("introdusca la edad de la persona:" +(i+1));
            arregloEdades[i]=Integer.parseInt(entrada.nextLine());
            sumaEdades+=arregloEdades[i];

        }
System.out.println("la suma de las edades es;" +sumaEdades);
System.err.println("que valor quieres que obtenga la posicion 3");
nuevoNumero=Integer.parseInt(entrada.nextLine());
//este cason os referimos a la posicion 3,se esta refiriendo a al indice 2
sumaEdades-=arregloEdades[2];
sumaEdades+=nuevoNumero;
System.out.println("resultado:" +sumaEdades);
entrada.close();


    }
}
