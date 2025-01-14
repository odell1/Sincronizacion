package Ejermplo9;

import javax.swing.*;

public class Principal extends JFrame {

    private VentanaCirculos panel;

    public Principal() {
        panel = new VentanaCirculos();
        add(panel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Creamos los hilos y los ejecutamos
        for (int i = 0; i < 6; i++) {
            Thread hilo = new Thread(new HiloCirculo(panel, i));
            hilo.start();
        }

        //No se le pone join

    }//Principal

    public static void main(String[] args) {
        new Principal();///////
    }
}