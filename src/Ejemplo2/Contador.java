package Ejemplo2;

public class Contador {
    private int cuenta = 0;

    public void incrementar() {
        synchronized (this) {
            cuenta++;
        }
    }

    public void decrementar() {
        synchronized (this) {
            cuenta--;
       }
    }

    public int getCuenta() {
        synchronized (this) {
            return cuenta;
        }
    }
}