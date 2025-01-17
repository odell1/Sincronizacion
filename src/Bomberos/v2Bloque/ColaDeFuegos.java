package Bomberos.v2Bloque;


import java.util.LinkedList;
import java.util.Queue;

public class ColaDeFuegos {
    private final Queue<Fuego> cola = new LinkedList<>();

    public  void agregarFuego(Fuego fuego) {
        cola.add(fuego); //Agregamos el fuego
    }

    public  Fuego obtenerFuego() {
        return cola.poll(); //Quitamos fuego
    }
}
