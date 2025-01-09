package Ejemplo8;

import java.util.LinkedList;
import java.util.Queue;

public class Almacen {
    private final int capacidad;
    private final Queue<Integer> cola = new LinkedList<>();

    public Almacen(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void producir(int item) throws InterruptedException {
        while (cola.size() == capacidad) {
            System.out.println("Almacén lleno. Productor esperando...");
            wait();
        }
        cola.add(item);
        System.out.println("Producido: " + item);
        notifyAll();////Avismos de que pueden consumir
    }

    public synchronized int consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            System.out.println("Almacén vacío. Consumidor esperando...");
            wait();
        }
        int item = cola.poll();
        System.out.println("Consumido: " + item);
        notifyAll();/////// Avisamos de que pueden rellenar
        return item;
    }
}