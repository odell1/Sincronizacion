package Barberia.version2;
import java.util.concurrent.Semaphore;

public class Barberia {
    private final Semaphore sillas;
    private final Semaphore barbero;
    private final Semaphore cliente;
    private final Object lock = new Object();

    public Barberia(int numSillas) {
        sillas = new Semaphore(numSillas);
        barbero = new Semaphore(0);
        cliente = new Semaphore(0);
    }

    public void entraCliente(int idCliente) throws InterruptedException {
        synchronized (lock) {
            if (sillas.tryAcquire()) {
                System.out.println("Cliente " + idCliente + " se sienta en una silla.");
                cliente.release(); 
                lock.notify(); //Despierta al barbero si está dormido. //!Ojo! debemos poner este objeto que está en el synchronized
            } else {
                System.out.println("Cliente " + idCliente + " espera porque no hay sillas disponibles.");
                lock.wait(); //Espera hasta que haya una silla disponible
                entraCliente(idCliente); // Intentar de nuevo cuando se despierte
            }
        }
    }

    public void atiendeBarbero() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (cliente.availablePermits() == 0) {
                    System.out.println("Barbero se duerme porque no hay clientes.");
                    lock.wait(); //Espera hasta que haya un cliente. //!Ojo! debemos poner este objeto que está en el synchronized
                }
                cliente.acquire();
                System.out.println("Barbero atiende a un cliente.");
                barbero.release();
                Thread.sleep(3000); // Simula el tiempo de corte de pelo
                sillas.release();
                lock.notifyAll(); // Despierta a los clientes que estén esperando
            }
        }
    }
}