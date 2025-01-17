package Barberia;

import java.util.concurrent.Semaphore;

public class Barberia {
    private final Semaphore sillas;
    private final Semaphore barbero;
    private final Semaphore cliente;

    public Barberia(int numSillas) {
        sillas = new Semaphore(numSillas);
        barbero = new Semaphore(0);//Esto es un mutex 
        cliente = new Semaphore(0);;//Esto es un mutex 
    }

    public void entraCliente(int idCliente) throws InterruptedException {
        if (sillas.tryAcquire()) {///Lo intentamos coger
            System.out.println("Cliente " + idCliente + " se sienta en una silla.");
            cliente.release();
            barbero.acquire();
            sillas.release();
            System.out.println("Cliente " + idCliente + " está siendo atendido.");
        } else {
            System.out.println("Cliente " + idCliente + " se va porque no hay sillas disponibles.");
        }
    }

    public void atiendeBarbero() throws InterruptedException {
        while (true) {
            cliente.acquire();
            System.out.println("Barbero atiende a un cliente.");
            barbero.release();
            Thread.sleep(3000); // Simula el tiempo de corte de pelo
        }
    }
}