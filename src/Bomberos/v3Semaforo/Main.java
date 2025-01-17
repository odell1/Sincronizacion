package Bomberos.v3Semaforo;
/*
 * Crea un programa que cree 4 bomberos y que apaguen fuegos de una cola sincronizada.
 * Solamente tenemos 2 mangueras que serán implementadas por dos semáforos. 
 * 
 * 
 */


public class Main {
    public static void main(String[] args) {
        ColaDeFuegos colaDeFuegos = new ColaDeFuegos();
        Manguera manguera = new Manguera(2); //Dos tickets para dos mangueras

        //Metemos fuegos a la cola
        for (int i = 0; i < 10; i++) {
            colaDeFuegos.agregarFuego(new Fuego(i));
        }
        Thread judas1=new Thread(new Bombero(colaDeFuegos,manguera), "Bombero-" + 1);
        Thread judas2=new Thread(new Bombero(colaDeFuegos,manguera), "Bombero-" + 2);
        Thread judas3=new Thread(new Bombero(colaDeFuegos,manguera), "Bombero-" + 3);
        Thread judas4=new Thread(new Bombero(colaDeFuegos,manguera), "Bombero-" + 4);

      /*  judas1.setPriority(Thread.MAX_PRIORITY);//10
        judas2.setPriority(Thread.NORM_PRIORITY);//5
        judas3.setPriority(Thread.MIN_PRIORITY);//1
        judas4.setPriority(5);
*/
      
        judas1.start();
        judas2.start();
        judas3.start();
        judas4.start();

     

        
    }
}//main
