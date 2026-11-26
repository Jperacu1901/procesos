package repaso.ej13;

import java.util.concurrent.ThreadLocalRandom;

public class Productor implements Runnable {

    private final String idProductor;
    private final BufferAcotado<String> buffer;
    private final int cantidadElementos;

    public Productor(String idProductor, BufferAcotado<String> buffer, int cantidadElementos) {
        this.idProductor = idProductor;
        this.buffer = buffer;
        this.cantidadElementos = cantidadElementos;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= cantidadElementos; i++) {
                String item = "Paquete-" + idProductor + "-" + i;
                buffer.producir(item);

                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 401));
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
