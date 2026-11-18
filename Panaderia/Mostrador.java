package Panaderia;

public class Mostrador {
    private int barras = 0;
    private final int max_barras = 5;

    public synchronized void PonerBarra() {
        while (barras == max_barras) {
            try {
                System.out.println("Mostrador lleno, esperando");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        barras++;
        System.out.printf("Horneando, mostrador: ", barras);
        notifyAll();
    }

    public synchronized void comprarBarra() {
        while (barras == 0) {
            try {
                System.out.println("Cliente esperando");
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        barras--;
        System.out.printf("Se ha comprado 1 barra. Quedan: ", barras);
        notifyAll();
    }
}
