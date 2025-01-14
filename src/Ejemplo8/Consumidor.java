package Ejemplo8;

public class Consumidor implements Runnable {
    private final Almacen almacen;

    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                almacen.consumir();
                Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo de consumo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}