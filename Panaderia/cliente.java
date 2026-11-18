package Panaderia;

public class cliente extends Thread {
    private final Mostrador mostrador;

    public cliente(Mostrador mostrador, String nombre) {
        this.mostrador = mostrador;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            try {
                long tiempoEspera = (long) (Math.random() * 2001 + 1000);
                Thread.sleep(tiempoEspera);

                mostrador.comprarBarra();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}