package Bomberos.v1MetodosSincronizados;
/*
 * Crea un programa que cree 4 bomberos y que apaguen fuegos de una cola sincronizada
 * 
 * 
 */


public class Main {
    public static void main(String[] args) {
        ColaDeFuegos colaDeFuegos = new ColaDeFuegos();

        //Metemos fuegos a la cola
        for (int i = 0; i < 10; i++) {
            colaDeFuegos.agregarFuego(new Fuego(i));
        }

        //Arrancamos a la cola
        for (int i = 1; i <= 4; i++) {
            new Thread(new Bombero(colaDeFuegos), "Bombero-" + i).start();
            
        }
    }
}//main
