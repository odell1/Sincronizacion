package Ejemplo7;


/*
*
 * Vamos a crear un ejemplo más complejo utilizando semáforos. Imaginemos una tienda de ropa con 5 probadores y 20 clientes, 
 * pero esta vez añadiremos una cola de espera y un sistema de registro para saber cuánto tiempo ha esperado cada cliente. 
 * Además, cada cliente puede decidir si quiere probarse más ropa después de usar el probador.
 * 
 */

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