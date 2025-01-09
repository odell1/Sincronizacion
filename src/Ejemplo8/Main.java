package Ejemplo8;
/*
 * 
 * Vamos a crear un ejemplo utilizando los métodos wait() y notify() en Java. Estos métodos se utilizan para la comunicación entre hilos, 
 * permitiendo que un hilo espere hasta que otro hilo le notifique que puede continuar.  
 * 
 * 
 * 
 * Tenemos un almacén con una capacidad limitada. Los productores añaden elementos al almacén y los consumidores los retiran. 
 * Si el almacén está lleno, los productores deben esperar hasta que haya espacio disponible. Si el almacén está vacío, los consumidores deben esperar hasta que haya elementos disponibles.
 * 
 */
public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(5);

        Thread productor1 = new Thread(new Productor(almacen));
        Thread productor2 = new Thread(new Productor(almacen));
        Thread consumidor1 = new Thread(new Consumidor(almacen));
        Thread consumidor2 = new Thread(new Consumidor(almacen));

        productor1.start();
        productor2.start();
        consumidor1.start();
        consumidor2.start();

        try {
            productor1.join();
            productor2.join();
            consumidor1.join();
            consumidor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}