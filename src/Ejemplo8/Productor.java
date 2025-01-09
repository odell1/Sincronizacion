package Ejemplo8;

public class Productor implements Runnable {
    private final Almacen almacen;

    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                almacen.producir(i);
                Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo de producción
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}