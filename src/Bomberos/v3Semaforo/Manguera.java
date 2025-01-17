package Bomberos.v3Semaforo;

import java.util.concurrent.Semaphore;

class Manguera {
    private Semaphore semaforo;

    public Manguera(int permisos) {
        this.semaforo = new Semaphore(permisos);
    }

    public void usar(String bombero) throws InterruptedException {
        semaforo.acquire();
        System.out.println(bombero + " está usando la manguera.");
    }

    public void liberar(String bombero) {
        System.out.println(bombero + " ha liberado la manguera.");
        semaforo.release();
    }
}