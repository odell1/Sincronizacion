package Nautilus;

public class Temporizador implements Runnable {
    private final Thread[] buzos;
    private final Thread nautilusThread;
    private final int tiempoLimite;

    public Temporizador(Thread[] buzos, Thread nautilusThread, int tiempoLimite) {
        this.buzos = buzos;
        this.nautilusThread = nautilusThread;
        this.tiempoLimite = tiempoLimite;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tiempoLimite); //Tiempo límite en milisegundos
            System.out.println("¡El tiempo se ha agotado! Todos los tripulantes han muerto.");
            for (Thread buzo : buzos) {
                buzo.interrupt();
            }
            nautilusThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}