package repaso.ej10;

public class ServicioMonitorServidor extends Thread {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("[MONITOR] Servidor operativo");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("[MONITOR] Señal de parada recibida. Guardando logs y cerrando servicio...");
        }
    }
}
