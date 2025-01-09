package Ejemplo1;

public class Incrementador implements Runnable {
    private Contador contador;

    public Incrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.incrementar();
        }
    }
}