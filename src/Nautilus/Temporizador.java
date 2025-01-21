package Nautilus;

public class Temporizador implements Runnable {
    private final Thread[] buzos;
    private final int tiempoLimite;

    public Temporizador(Thread[] buzos, int tiempoLimite) {
        this.buzos = buzos;
        this.tiempoLimite = tiempoLimite;
    }

  /*  public Temporizador(Thread[] buzos2, Nautilus nautilus, int i) {
        this.buzos = buzos;
        this.tiempoLimite = tiempoLimite;

     
    }*/

    @Override
    public void run() {
        try {
            Thread.sleep(tiempoLimite); // Tiempo límite en milisegundos
            System.out.println("¡El tiempo se ha agotado! Todos los tripulantes han muerto.");
            for (Thread buzo : buzos) {
                buzo.interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}