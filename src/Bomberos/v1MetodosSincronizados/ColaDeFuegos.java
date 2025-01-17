package Bomberos.v1MetodosSincronizados;


import java.util.LinkedList;
import java.util.Queue;

public class ColaDeFuegos {
    private final Queue<Fuego> cola = new LinkedList<>();

    public synchronized void agregarFuego(Fuego fuego) {
        cola.add(fuego); //Agregamos el fuego
    }

    public synchronized Fuego obtenerFuego() {
        return cola.poll(); //Quitamos fuego
    }
}
