package Bomberos.v2Bloque;

class Bombero implements Runnable {
    private final ColaDeFuegos colaDeFuegos;

    public Bombero(ColaDeFuegos colaDeFuegos) {//Recibe la cola sincronizada
        this.colaDeFuegos = colaDeFuegos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized(colaDeFuegos){
                            Fuego fuego = colaDeFuegos.obtenerFuego();//Al método que llama está sincronizado
                            if (fuego == null) {
                                System.out.println(Thread.currentThread().getName() + " no encontró más fuegos.");
                                break;
                            }
                            System.out.println(Thread.currentThread().getName() + " está apagando el fuego " + fuego.getId());
                            Thread.sleep(2000);//Esperamos
                            System.out.println(Thread.currentThread().getName() + " apagó el fuego " + fuego.getId());
                    }
                }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}