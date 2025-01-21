package Nautilus;
import java.util.concurrent.Semaphore;
import java.util.Random;

import java.util.concurrent.Semaphore;
import java.util.Random;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Nautilus {
    private final Semaphore ticketRompeHielo = new Semaphore(2); // Solo 2 buzos pueden trabajar a la vez
    private final Semaphore ticketEmpujaSubmarino = new Semaphore(0);
    private int grosorHielo;
    private int operacionesRompeHielo = 0; // Para que cuando lleguen a 3 hagan otra cosa

    public Nautilus(int grosorInicial) {
        this.grosorHielo = grosorInicial;
    }

    public void romperHielo(int id) throws InterruptedException {
        ticketRompeHielo.acquire();
        try {
            if (getGrosorHielo() > 0) {
                System.out.println("Tripulante " + id + " está rompiendo el hielo.");
                Random rand = new Random();
                int tiempoRomper = rand.nextInt(3000) + 1000; // Tiempo aleatorio entre 1 y 4 segundos
                Thread.sleep(tiempoRomper); // Simula el tiempo de romper el hielo
                decrementarGrosorHielo();
                incrementarOperacionesRompeHielo();
                System.out.println("Tripulante " + id + " ha roto el hielo. Grosor restante: " + getGrosorHielo());

                if (getOperacionesRompeHielo() >= 3) {
                    System.out.println("Tripulantes descansan y empujan el submarino.");
                    ticketEmpujaSubmarino.release(3); // Permite que los tripulantes empujen el submarino
                    resetOperacionesRompeHielo(); // Reinicia el contador de operaciones
                    synchronized (this) {
                        notifyAll(); // Despierta a los tripulantes que empujan el submarino
                        wait(); // Los tripulantes que rompen el hielo esperan
                    }
                }
            }
        } finally {
            ticketRompeHielo.release();
        }
    }

    public void empujarSubmarino(int id) throws InterruptedException {
        ticketEmpujaSubmarino.acquire();
        try {
            System.out.println("Tripulante " + id + " está empujando el submarino.");
            Thread.sleep(2000); // Simula el tiempo de empujar el submarino
            System.out.println("Tripulante " + id + " ha empujado el submarino.");
            synchronized (this) {
                notifyAll(); // Despierta a los tripulantes que rompen el hielo
            }
        } finally {
            ticketEmpujaSubmarino.release();
        }
    }

    private synchronized int getGrosorHielo() {
        return grosorHielo;
    }

    private synchronized void decrementarGrosorHielo() {
        grosorHielo--;
    }

    private synchronized int getOperacionesRompeHielo() {
        return operacionesRompeHielo;
    }

    private synchronized void incrementarOperacionesRompeHielo() {
        operacionesRompeHielo++;
    }

    private synchronized void resetOperacionesRompeHielo() {
        operacionesRompeHielo = 0;
    }
}

/*
public class Nautilus {
    private final Semaphore ticketRompeHielo = new Semaphore(2); //Solo 2 buzos pueden trabajar a la vez
    private final Semaphore ticketEmpujaSubmarino = new Semaphore(0);
    private final Object lock = new Object();
    private int grosorHielo;
    private int operacionesRompeHielo = 0;//Para que cuando lleguen a 3 hagan otra cosa

    public Nautilus(int grosorInicial) {
        this.grosorHielo = grosorInicial;
    }

    public void romperHielo(int id) throws InterruptedException {
        ticketRompeHielo.acquire();
        synchronized (lock) {
            if (grosorHielo > 0) {
                System.out.println("Tripulante " + id + " está rompiendo el hielo.");
                Random rand = new Random();
                int tiempoRomper = rand.nextInt(3000) + 1000; //Tiempo aleatorio entre 1 y 4 segundos
                Thread.sleep(tiempoRomper); //Simula el tiempo de romper el hielo
                grosorHielo--;
                operacionesRompeHielo++;
                System.out.println("Tripulante " + id + " ha roto el hielo. Grosor restante: " + grosorHielo);

                if (operacionesRompeHielo >= 3) {
                    System.out.println("Tripulantes descansan y empujan el submarino.");
                    ticketEmpujaSubmarino.release(3); //Permite que los tripulantes empujen el submarino
                    operacionesRompeHielo = 0; //Reinicia el contador de operaciones
                    lock.notifyAll(); //Despierta a los tripulantes que empujan el submarino
                    lock.wait(); //Los tripulantes que rompen el hielo esperan
                }
            }
        }
        ticketRompeHielo.release();
    }

    public void empujarSubmarino(int id) throws InterruptedException {
        ticketEmpujaSubmarino.acquire();
        synchronized (lock) {
            System.out.println("Tripulante " + id + " está empujando el submarino.");
            Thread.sleep(2000); //Simula el tiempo de empujar el submarino
            System.out.println("Tripulante " + id + " ha empujado el submarino.");
            lock.notifyAll(); //Despierta a los tripulantes que rompen el hielo
        }
        ticketEmpujaSubmarino.release();
    }
}
*/