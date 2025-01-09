package Ejemplo3;

public class Contador {
    private static int cuenta = 0;

    public static synchronized void incrementar() {
        cuenta++;
    }

    public static synchronized void decrementar() {
        cuenta--;
    }

    public static synchronized int getCuenta() {
        return cuenta;
    }
}
