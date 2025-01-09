package Ejemplo3;

public class Incrementador implements Runnable {
   

    public Incrementador(Contador contador) {
       // this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contador.incrementar();
        }
    }
}