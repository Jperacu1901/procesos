package repaso.ej12;

public class PuenteEstrecho {
    private boolean ocupado = false;

    public synchronized void entrarPuente(String nombreCoche) throws InterruptedException {
        while (ocupado) {
            System.out.println(" [ESPERA] " + nombreCoche + " no entra");
            wait();
        }
        ocupado = true;
        System.out.println(" [ENTRA] " + nombreCoche + " entra al puente");
    }

    public synchronized void salirPuente(String nombreCoche) {
        ocupado = false;
        System.out.println(" [SALE] " + nombreCoche + " ha salido del puente");

        notifyAll();
    }
}