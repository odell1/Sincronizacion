package Ejemplo5;

import java.util.concurrent.Semaphore;

public class Contador {
    private int cuenta = 0;
    private final Semaphore semaforo = new Semaphore(1);////// Semáforo!!!!!!!!!!

    public void incrementar() {
        try {
            semaforo.acquire();////// Lo cogemos!!!!
            cuenta++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();///// Lo dejamos
        }
    }

    public void decrementar() {
        try {
            semaforo.acquire(); /// Lo cogemos!!!!
            cuenta--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();//// Lo soltamos
        }
    }

    public int getCuenta() {
        try {
            semaforo.acquire();
            return cuenta;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            semaforo.release();
        }
    }
}