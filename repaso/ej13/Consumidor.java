package repaso.ej13;

import java.util.concurrent.ThreadLocalRandom;

public class Consumidor implements Runnable {

    private final String idConsumidor;
    private final BufferAcotado<String> buffer;
    private final int cantidadElementos;

    public Consumidor(String idConsumidor, BufferAcotado<String> buffer, int cantidadElementos) {
        this.idConsumidor = idConsumidor;
        this.buffer = buffer;
        this.cantidadElementos = cantidadElementos;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= cantidadElementos; i++) {
                String item = buffer.consumir();

                Thread.sleep(ThreadLocalRandom.current().nextInt(150, 501));
            }
        } catch (InterruptedException e) {
            System.err.println("[ERROR] " + idConsumidor + " interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}