package Ejermplo9;

import java.util.Random;


public class HiloCirculo implements Runnable {

    private VentanaCirculos panel;
    private int numeroCirculo;

    public HiloCirculo(VentanaCirculos panel, int numeroCirculo) {
        this.panel = panel;
        this.numeroCirculo = numeroCirculo;
    }

    @Override
    public void run() {
        int[] colores = {1, 2, 3, 4, 5, 6}; // Colores disponibles
        int indice = 0;

        while (true) {
            panel.setColorCirculo(numeroCirculo, colores[indice]);
            indice = (indice + 1) % colores.length;
            try {
                Thread.sleep(1000); // Cambiar color cada segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    

