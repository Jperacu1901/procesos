package RepasoExtra.TransportadorPizza;

import java.util.concurrent.ThreadLocalRandom;

public class Cocinero implements Runnable {

    private final String nombre;
    private final MostradorPizzas mostrador;
    private final int totalPizzas;

    public Cocinero(String nombre, MostradorPizzas mostrador, int totalPizzas) {
        this.nombre = nombre;
        this.mostrador = mostrador;
        this.totalPizzas = totalPizzas;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalPizzas; i++) {
                int tiempoHorneado = ThreadLocalRandom.current().nextInt(200, 601);
                Thread.sleep(tiempoHorneado);
                String pizza = "Pizza-" + nombre + "-" + i;
                mostrador.ponerPizzas(pizza);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("ERROR: Cocinero " + nombre + " interrumpido.");
        }
    }
}