package Nautilus;

public class Buzo implements Runnable {
    private final Nautilus nautilus;
    private final int id;
    private final boolean esRompeHielo;

    public Buzo(Nautilus nautilus, int id, boolean esRompeHielo) {
        this.nautilus = nautilus;
        this.id = id;
        this.esRompeHielo = esRompeHielo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (esRompeHielo) {
                    nautilus.romperHielo(id);
                } else {
                    nautilus.empujarSubmarino(id);
                }
                Thread.sleep(1000); // Simula el tiempo de descanso
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}