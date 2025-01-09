package Ejemplo7;

public class Cliente implements Runnable {
    private final TiendaRopa tienda;
    private final String nombre;

    public Cliente(TiendaRopa tienda, String nombre) {
        this.tienda = tienda;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        tienda.usarProbador(nombre);
    }
}