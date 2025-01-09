package Ejemplo4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private int cuenta = 0;
    private final Lock bloqueo = new ReentrantLock();///////////Aquí está el rollo del Arzollo

    public void incrementar() {
        bloqueo.lock();///// Bloqueamos
        try {
            cuenta++;
        } finally {
            bloqueo.unlock();////Desbloqueamos Ojo!!!!
        }
    }

    public void decrementar() {
        bloqueo.lock();//////// Bloqueamos
        try {
            cuenta--;
        } finally {
            bloqueo.unlock();/////Desbloquemos Ojo al parche!!!
        }
    }

    public int getCuenta() {
        bloqueo.lock();
        try {
            return cuenta;
        } finally {
            bloqueo.unlock();
        }
    }
}