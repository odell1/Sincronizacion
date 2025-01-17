package Bomberos.v3Semaforo;

import java.util.concurrent.Semaphore;

class Bombero implements Runnable {
    private final ColaDeFuegos colaDeFuegos;
    private final Semaphore manguera = new Semaphore(2);

    public Bombero(ColaDeFuegos colaDeFuegos) {//Recibe la cola sincronizada
        this.colaDeFuegos = colaDeFuegos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                    if(manguera.tryAcquire()){
                           try{
                            Fuego fuego = colaDeFuegos.obtenerFuego();//Al método que llama está sincronizado
                            if (fuego == null) {
                                System.out.println(Thread.currentThread().getName() + " no encontró más fuegos.");
                                break;
                            }
                            System.out.println(Thread.currentThread().getName() + " está apagando el fuego " + fuego.getId());
                            Thread.sleep(2000);//Esperamos
                    
                            System.out.println(Thread.currentThread().getName() + " apagó el fuego " + fuego.getId());
                           }finally{
                        manguera.release();
                           }
                        }else{
                            System.out.println("Estamos esperando a que suelten una manguera");
                            Thread.sleep(1000);//Esperamos
                        }
                    }
                
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}