package Panaderia;

public class panadero extends Thread {
    private final Mostrador mostrador;
    private final int totalBarrasAProducir;

    public panadero(Mostrador mostrador, int totalBarrasAProducir) {
        this.mostrador = mostrador;
        this.totalBarrasAProducir = totalBarrasAProducir;
    }

    public void run() {
        for (int i = 0; i < totalBarrasAProducir; i++) {
            try {
                // Genera 1 barra cada 2 segundos
                Thread.sleep(2000);
                mostrador.PonerBarra();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}