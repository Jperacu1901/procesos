package repaso.ej10;

public class AppMonitorServidor {
    public static void main(String[] args) {

        ServicioMonitorServidor monitor = new ServicioMonitorServidor();
        monitor.start();

        try {
            Thread.sleep(2500);
            System.out.println("[MAIN] Solicitando detencion del monitor");
            monitor.interrupt();

            monitor.join();

            System.out.println("[MAIN] Monitor detenido: " + monitor.isAlive());
        } catch (InterruptedException e) {
            System.err.println("ERROR");
            Thread.currentThread().interrupt();
        }
    }
}
