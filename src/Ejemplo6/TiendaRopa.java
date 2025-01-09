package Ejemplo6;
import java.util.concurrent.Semaphore;

public class TiendaRopa {
    private final Semaphore probadores = new Semaphore(5);

    public void usarProbador(String cliente) {
        try {
            System.out.println(cliente + " está esperando para usar un probador.");
            probadores.acquire();// Cogemos un probador
            System.out.println(cliente + " está usando un probador.");
            Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo que el cliente pasa en el probador
            System.out.println(cliente + " ha terminado de usar el probador.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            probadores.release();//Lo soltamos
        }
    }
}