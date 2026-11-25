package repaso.ej9;

import java.util.concurrent.ThreadLocalRandom;

public class OperarioAlmacen implements Runnable {

    private final String nombre;
    private final int cantidadPaquetes;

    public OperarioAlmacen(String nombre, int cantidadPaquetes) {
        this.nombre = nombre;
        this.cantidadPaquetes = cantidadPaquetes;

    }

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();

        for (int i = 1; i <= cantidadPaquetes; i++) {
            try {
                System.out.println("[" + nombreHilo + "]" + nombre + " empieza a embalar el paquete #" + i);
                int tiempoPausa = ThreadLocalRandom.current().nextInt(400, 1201);
                Thread.sleep(tiempoPausa);
                System.out.println(
                        "[" + nombreHilo + "] " + nombre + " terminó el paquete #" + i + " (" + tiempoPausa + " ms)");

            } catch (InterruptedException e) {
                System.err.println("ERROR");
                Thread.currentThread().interrupt();
            }
        }
    }
}
