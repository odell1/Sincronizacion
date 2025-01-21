package Nautilus;

public class Main {
    public static void main(String[] args) {
        int grosorInicial = 10;
        Nautilus nautilus = new Nautilus(grosorInicial);

        for (int i = 1; i <= 5; i++) {
            Thread buzoRompeHielo = new Thread(new Buzo(nautilus, i, true));
            buzoRompeHielo.start();
        }

        for (int i = 6; i <= 10; i++) {
            Thread buzoEmpujaSubmarino = new Thread(new Buzo(nautilus, i, false));
            buzoEmpujaSubmarino.start();
        }

        //Inicia el temporizador
        Thread temporizador = new Thread(new Temporizador(buzos, nautilusThread, 30000)); // 30 segundos
        temporizador.start();
        }
    }
