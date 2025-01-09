package Ejemplo2;

/*
 * Bloque sincronizado. Al contario que el método sincronizado, son bloques de código. con los bloques es más ágil y menos bloqueante.
 * Prueba a comentar los bloques sincronizados.
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