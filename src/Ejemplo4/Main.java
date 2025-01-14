package Ejemplo4;


/*
 * Los objetos de bloqueo (Lock Objects) en Java proporcionan un mayor control sobre la sincronización que los bloques
 *  sincronizados tradicionales. 
 * La interfaz Lock en el paquete java.util.concurrent.locks permite bloquear y desbloquear explícitamente, lo que puede ser útil en situaciones más complejas.
 * Son por decir así, la versión mejorada de syncronized.
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