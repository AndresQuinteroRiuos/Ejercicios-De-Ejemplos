package TUTORIAS;

public class serieFibonacci {
    public static void main(String[] args) {
        /*el planteamiento del programa
        /*
         considerando de la secuencia fibonacci no exceda los 4.000.000
         encontrar la sumatoria delos numeros pares.
         */
    int limite= 4_000_000;
    int numeroA=1;
    int numeroB=1;
    int sumatoriaPares=0;
    while (numeroB<=limite){
        if (numeroB % 2==0){
        System.out.println("numero par: "+numeroB);
        sumatoriaPares+=numeroB;
        }
//actualizar numeros de fibonacci
numeroB=numeroA+numeroB; //1+1 =========numeroB =2
numeroA=(numeroB-numeroA);
//2-1==========numeroA =1
    
        
    }
    System.out.println("suma pares: " +sumatoriaPares);
    System.out.printf("sumatoria pares con f-strings  %d:",sumatoriaPares);
}
 }
