package Ejermplo9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCirculos extends JPanel {

    private int[][] circulos;
    private Color[] colores;
    private Timer[] timers;

    public VentanaCirculos() {
        int numCirculos = 6;
        int radioCirculoGrande = 200;
        int centroX = 400;
        int centroY = 300;

        circulos = new int[numCirculos][3];
        colores = new Color[numCirculos];
        timers = new Timer[numCirculos];

        // Inicializar las posiciones y radios de los círculos
        for (int i = 0; i < numCirculos; i++) {
            double angulo = 2 * Math.PI * i / numCirculos;
            int x = (int) (centroX + radioCirculoGrande * Math.cos(angulo));
            int y = (int) (centroY + radioCirculoGrande * Math.sin(angulo));
            int radio = 50; // Radio de los círculos pequeños
            circulos[i][0] = x;
            circulos[i][1] = y;
            circulos[i][2] = radio;
            colores[i] = Color.BLACK; // Inicializar todos los colores a negro
        }
    }//VentanaCirculos

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar los círculos con sus colores correspondientes
        for (int i = 0; i < circulos.length; i++) {
            int x = circulos[i][0];
            int y = circulos[i][1];
            int radio = circulos[i][2];
            g2d.setColor(colores[i]);
            g2d.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
        }
    }

    public void setColorCirculo(int numeroCirculo, int numeroColor) {
        if (numeroCirculo < 0 || numeroCirculo >= colores.length) {
            throw new IllegalArgumentException("Número de círculo inválido");
        }

        Color color;
        switch (numeroColor) {
            case 1: color = Color.RED; break;
            case 2: color = Color.GREEN; break;
            case 3: color = Color.BLUE; break;
            case 4: color = Color.YELLOW; break;
            case 5: color = Color.ORANGE; break;
            case 6: color = Color.PINK; break;
            default: color = Color.BLACK; break;
        }

        colores[numeroCirculo] = color;
        repaint();
    }//setColorCirculo

    public void parpadearCirculo(int numeroCirculo, int intervalo) {
        if (numeroCirculo < 0 || numeroCirculo >= colores.length) {
            throw new IllegalArgumentException("Número de círculo inválido");
        }

        if (timers[numeroCirculo] != null && timers[numeroCirculo].isRunning()) {
            timers[numeroCirculo].stop();
        }

        Color colorOriginal = colores[numeroCirculo];
        Color colorFondo = getBackground();

        timers[numeroCirculo] = new Timer(intervalo, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                colores[numeroCirculo] = visible ? colorOriginal : colorFondo;
                visible = !visible;
                repaint();
            }
        });

        timers[numeroCirculo].start();
    }//parpadearCirculo
}

/* Prueba
    public static void main(String[] args) {
        JFrame marco = new JFrame("Ventana de Círculos");
        VentanaCirculos panel = new VentanaCirculos();
        marco.add(panel);
        marco.setSize(800, 600);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);

        // Ejemplo de uso del método setColorCirculo
        panel.setColorCirculo(0, 1); //Pinta el primer círculo de rojo
        panel.setColorCirculo(1, 2); //Pinta el segundo círculo de verde
        panel.setColorCirculo(2, 3); //Pinta el tercer círculo de azul
     }
*/

   
        
