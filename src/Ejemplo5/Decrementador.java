package Ejemplo5;

public class Decrementador implements Runnable {
    private Contador contador;

    public Decrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.decrementar();
        }
    }
}