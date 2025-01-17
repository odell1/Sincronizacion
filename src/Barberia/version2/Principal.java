package Barberia.version2;

public class Principal {
        public static void main(String[] args) {
            int numSillas = 3;
            Barberia barberia = new Barberia(numSillas);
    
            Thread barbero = new Thread(new Barbero(barberia));
            barbero.start();
    
            for (int i = 1; i <= 10; i++) {
                Thread cliente = new Thread(new Cliente(barberia, i));
                cliente.start();
                try {
                    Thread.sleep(1000); //Simula la llegada de nuevos clientes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
