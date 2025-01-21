package Nautilus;

public class Main {
    public static void main(String[] args) {
        int grosorInicial = 10;
        Nautilus nautilus = new Nautilus(grosorInicial);

        Thread[] buzos = new Thread[10];
        for (int i = 0; i < 5; i++) {
            buzos[i] = new Thread(new Buzo(nautilus, i + 1, true));
            buzos[i].start();
        }

        for (int i = 5; i < 10; i++) {
            buzos[i] = new Thread(new Buzo(nautilus, i + 1, false));
            buzos[i].start();
        }

        // Inicia el temporizador
        Thread temporizador = new Thread(new Temporizador(buzos,30000)); //30 segundos
        temporizador.start();
        
    }
}