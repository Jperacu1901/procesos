package RepasoExtra.TransportadorPizza;

import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private final String nombre;
    private final MostradorPizzas mostrador;
    private final int totalPizzas;

    public Repartidor(String nombre, MostradorPizzas mostrador, int totalPizzas) {
        this.nombre = nombre;
        this.mostrador = mostrador;
        this.totalPizzas = totalPizzas;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalPizzas; i++) {
                mostrador.recogerPizza(nombre);
                int entrega = ThreadLocalRandom.current().nextInt(300, 801);
                Thread.sleep(entrega);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("ERROR");
        }
    }
}
