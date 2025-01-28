package Ejercicios.Ejercicio2.version1;

class Transaccion implements Runnable {
    private CuentaBancaria cuenta;
    private String tipoTransaccion;
    private double monto;
    private int numTransacciones;

    public Transaccion(CuentaBancaria cuenta, String tipoTransaccion, double monto, int numTransacciones) {
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.numTransacciones = numTransacciones;
    }

    @Override
    public void run() {
        for (int i = 0; i < numTransacciones; i++) {
            if ("depositar".equalsIgnoreCase(tipoTransaccion)) {
                Banco.depositar(cuenta, monto); //Llamada a los métodos estáticos
            } else if ("retirar".equalsIgnoreCase(tipoTransaccion)) {
                Banco.retirar(cuenta, monto);//Llamada a los métodos estáticos
            }
            
            try {
                Thread.sleep(50); // Simula tiempo de procesamiento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
