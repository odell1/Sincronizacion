package Ejercicios.Ejercicio2.version1;

class Banco {
    public static synchronized void depositar(CuentaBancaria cuenta, double monto) { /*/////////// Aquí están los métodos estáticos y  sincronizados. */
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        System.out.println("Depósito en cuenta " + cuenta.getId() + ": +" + monto + " | Saldo: " + nuevoSaldo);
    }

    public static synchronized void retirar(CuentaBancaria cuenta, double monto) {
        if (cuenta.getSaldo() >= monto) {
            double nuevoSaldo = cuenta.getSaldo() - monto;
            cuenta.setSaldo(nuevoSaldo);
            System.out.println("Retiro en cuenta " + cuenta.getId() + ": -" + monto + " | Saldo: " + nuevoSaldo);
        } else {
            System.out.println("Fondos insuficientes en cuenta " + cuenta.getId() + " para retirar " + monto);
        }
    }
}