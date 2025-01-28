package Ejercicios.Ejercicio2.version1;

import java.util.ArrayList;
import java.util.List;

public class Lanzador {
     public static void main(String[] args) throws InterruptedException {
        //Creamos las cuentas bancarias
        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaBancaria(1, 1000));
        cuentas.add(new CuentaBancaria(2, 1000));

        //Crear hilos
        List<Thread> hilos = new ArrayList<>();
        
        //Hilos para la cuenta 1 - Los metemos en una lista pero tb en un array como hemos hecho
        hilos.add(new Thread(new Transaccion(cuentas.get(0), "depositar", 100, 5)));
        hilos.add(new Thread(new Transaccion(cuentas.get(0), "retirar", 50, 5)));
        
        //Hilos para la cuenta 2
        hilos.add(new Thread(new Transaccion(cuentas.get(1), "depositar", 200, 5)));
        hilos.add(new Thread(new Transaccion(cuentas.get(1), "retirar", 100, 5)));

        //Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            hilo.join();
        }

        //Mostrar saldos finales
        System.out.println("\nSaldos finales:");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println("Cuenta " + cuenta.getId() + ": " + cuenta.getSaldo());
        }
    }
}
