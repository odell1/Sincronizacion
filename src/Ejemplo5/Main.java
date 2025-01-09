package Ejemplo5;

/*
 * 
 * Los semáforos en Java, proporcionados por la clase Semaphore en el paquete java.util.concurrent, se utilizan para controlar 
 * el acceso a un recurso compartido por un número limitado de hilos.
 * Un semáforo mantiene un contador que permite a los hilos adquirir permisos para acceder al recurso 
 * y liberar permisos cuando ya no necesitan el recurso.
 *  
 * 
 */

 public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        // Crear hilos que incrementan y decrementan el contador
        Thread hiloIncrementador1 = new Thread(new Incrementador(contador));
        Thread hiloIncrementador2 = new Thread(new Incrementador(contador));
        Thread hiloIncrementador3 = new Thread(new Incrementador(contador));
        Thread hiloDecrementador1 = new Thread(new Decrementador(contador));
        Thread hiloDecrementador2 = new Thread(new Decrementador(contador));
        Thread hiloDecrementador3 = new Thread(new Decrementador(contador));

        hiloIncrementador1.start();
        hiloIncrementador2.start();
        hiloIncrementador3.start();
        hiloDecrementador1.start();
        hiloDecrementador2.start();
        hiloDecrementador3.start();

        try {
            hiloIncrementador1.join();
            hiloIncrementador2.join();
            hiloDecrementador3.join();
            hiloDecrementador1.join();
            hiloDecrementador2.join();
            hiloDecrementador3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cuenta final: " + contador.getCuenta());
    }
}