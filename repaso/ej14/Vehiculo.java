package repaso.ej14;

import java.util.concurrent.ThreadLocalRandom;

public class Vehiculo implements Runnable {
    private final int idVehiculo;
    private final Parking parking;

    public Vehiculo(int idVehiculo, Parking parking) {
        this.idVehiculo = idVehiculo;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            parking.solicitarPlaza(idVehiculo);
            long estanciaMs = ThreadLocalRandom.current().nextLong(1000, 3001);
            Thread.sleep(estanciaMs);
            parking.liberarPlaza(idVehiculo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(" [PAUSADO] " + idVehiculo + " parado");
        }
    }
}
