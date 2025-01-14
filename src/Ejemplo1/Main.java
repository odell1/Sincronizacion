package Ejemplo1;
/*
 * Una condición de carrera ocurre cuando dos o más hilos acceden a un recurso compartido
 *  (como una variable o un objeto) al mismo tiempo, 
 * y al menos uno de los hilos modifica ese recurso. Esto puede llevar a resultados inesperados o incorrectos, ya que el orden de ejecución
 *  de los hilos puede variar cada vez que se ejecuta el programa.
 * Por ejemplo, imagina que dos hilos intentan incrementar una variable compartida al mismo tiempo. 
 * Si ambos leen el valor actual de la variable antes de que cualquiera de ellos la incremente, 
 * ambos podrían leer el mismo valor y luego 
 * escribir el mismo valor incrementado, en lugar de incrementar la variable dos veces.
 * 
 * Método sincronizado 
 * Prueba este mismo ejercicio sin la sincronización del método en la clase Incrementador
 * 
 */
public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        // Crear hilos que incrementan el contador
        Thread hilo1 = new Thread(new Incrementador(contador));
        Thread hilo2 = new Thread(new Incrementador(contador));
        Thread hilo3 = new Thread(new Incrementador(contador));
        Thread hilo4 = new Thread(new Incrementador(contador));


        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cuenta final: " + contador.getCuenta());
    }
}