package Ejermplo9;

import java.util.List;
import java.util.Random;


public class HiloCirculo implements Runnable {

 /*   private VentanaCirculos panel;
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
}*/

private VentanaCirculos panel;
    private int numeroCirculo;
    private static final int[] COLORES = {1, 2, 3, 4, 5};
    private static boolean[] coloresUsados = new boolean[COLORES.length];
    

    public HiloCirculo(VentanaCirculos panel, int numeroCirculo) {
        this.panel = panel;
        this.numeroCirculo = numeroCirculo;
    }

    @Override
    public void run() {
        
            synchronized (COLORES) {
               if(todosSonTrue(coloresUsados)){
                    panel.parpadearCirculo(numeroCirculo, 500);
               }else{
                    int colorAsignado;
                    do {
                        colorAsignado = COLORES[new Random().nextInt(COLORES.length)];
                    } while (coloresUsados[colorAsignado - 1]);
                    coloresUsados[colorAsignado - 1] = true;
            
                    panel.setColorCirculo(numeroCirculo, colorAsignado);
                }//else
            }


}//run


public static boolean todosSonTrue(boolean[] array) {
    for (boolean elemento : array) {
        if (!elemento) {
            return false;
        }
    }
    return true;
}//todosSonTrue

}

    

