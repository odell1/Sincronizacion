package Ejemplo7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

public class TiendaRopa {
    private final Semaphore probadores = new Semaphore(5);
    private final Queue<String> colaEspera = new LinkedList<>();
    private final Lock lockCola = new ReentrantLock();

    public void usarProbador(String cliente) {
        long tiempoInicio = System.currentTimeMillis();
        try {
            lockCola.lock();
                colaEspera.add(cliente);//Metemos en la cola
            lockCola.unlock();

            System.out.println(cliente + " está esperando para usar un probador.");
                probadores.acquire();//Adquirimos el semáforo
                

            lockCola.lock();
                colaEspera.remove(cliente);//Quitamos de la cola
            lockCola.unlock();

            long tiempoEspera = System.currentTimeMillis() - tiempoInicio;
            System.out.println(cliente + " está usando un probador. Tiempo de espera: " + tiempoEspera + " ms");
                Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo que el cliente pasa en el probador
            System.out.println(cliente + " ha terminado de usar el probador.");

            // Decidir si el cliente quiere probarse más ropa
            if (Math.random() > 0.5) {
                System.out.println(cliente + " quiere probarse más ropa.");
                probadores.release();
                usarProbador(cliente);///Ojete con esto!!!
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            probadores.release();
        }
    }
}