package repaso.ej14;

public class Parking {
    private int plazasLibres;

    public Parking(int totalPlazas) {
        this.plazasLibres = totalPlazas;
    }

    public synchronized void solicitarPlaza(int idVehiculo) throws InterruptedException {
        while (plazasLibres == 0) {
            wait();
        }
        plazasLibres--;
        System.out.println(" [ENTRA] Coche #" + idVehiculo + " Plazas libres: " + plazasLibres);
    }

    public synchronized void liberarPlaza(int idVehiculo) {
        plazasLibres++;
        System.out.println(" [SALE] " + idVehiculo + " Plazas libres: " + plazasLibres);
        notifyAll();
    }
}
