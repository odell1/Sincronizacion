package Ejercicios.Ejercicio2.version1;

import java.util.ArrayList;
import java.util.List;

class CuentaBancaria {
    private int id;
    private double saldo;

    public CuentaBancaria(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}