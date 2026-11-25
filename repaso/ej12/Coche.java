package repaso.ej12;

import java.util.concurrent.ThreadLocalRandom;

public class Coche implements Runnable {
    private final String nombre;
    private final PuenteEstrecho puente;

    public Coche(String nombre, PuenteEstrecho puente) {
        this.nombre = nombre;
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            puente.entrarPuente(nombre);

            try {
                int tiempoCruce = ThreadLocalRandom.current().nextInt(500, 1501);
                Thread.sleep(tiempoCruce);
            } finally {
                puente.salirPuente(nombre);
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR");
            Thread.currentThread().interrupt();
        }
    }
}
