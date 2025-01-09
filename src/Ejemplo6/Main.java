package Ejemplo6;

public class Main {
    public static void main(String[] args) {
        TiendaRopa tienda = new TiendaRopa();

        // Crear y ejecutar 20 hilos de clientes
        Thread[] clientes = new Thread[20];
        for (int i = 0; i < 20; i++) {
            clientes[i] = new Thread(new Cliente(tienda, "Cliente " + (i + 1)));
            clientes[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < 20; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los clientes han terminado de usar los probadores.");
    }
}