package Bomberos.v3Semaforo;

import java.util.concurrent.Semaphore;

class Bombero implements Runnable {
    private final ColaDeFuegos colaDeFuegos;
    private Manguera manguera;


    public Bombero(ColaDeFuegos colaDeFuegos, Manguera manguera2) {//Recibe la cola sincronizada
        this.colaDeFuegos = colaDeFuegos;
        this.manguera=manguera2;
    }

    @Override
    public void run() {
        try {
            while (true) {
                   
                            manguera.usar(Thread.currentThread().getName()); //Cogemos la manguera
                            Fuego fuego = colaDeFuegos.obtenerFuego();//Al método que llama está sincronizado
                            if (fuego == null) {
                                System.out.println(Thread.currentThread().getName() + " no encontró más fuegos.");
                                manguera.liberar(Thread.currentThread().getName());;
                                break;
                            }
                            System.out.println(Thread.currentThread().getName() + " está apagando el fuego " + fuego.getId());
                            Thread.sleep(2000);//Esperamos
                    
                            System.out.println(Thread.currentThread().getName() + " apagó el fuego " + fuego.getId());
                         
                            manguera.liberar(Thread.currentThread().getName());;
                       }
                        
                    
                
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}