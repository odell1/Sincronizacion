package Barberia;

public class Cliente implements Runnable {
    private final Barberia barberia;
    private final int idCliente;

    public Cliente(Barberia barberia, int idCliente) {
        this.barberia = barberia;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            barberia.entraCliente(idCliente);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}