package repaso.ej14;

public class AppParking {
    public static void main(String[] args) {
        final int TOTAL_PLAZAS = 3;
        final int TOTAL_VEHICULOS = 8;

        Parking parking = new Parking(TOTAL_PLAZAS);
        Thread[] hilosVehiculos = new Thread[TOTAL_VEHICULOS];

        for (int i = 0; i < TOTAL_VEHICULOS; i++) {
            int idVehiculo = i + 1;
            hilosVehiculos[i] = new Thread(new Vehiculo(idVehiculo, parking), "Vehiculo-" + idVehiculo);
            hilosVehiculos[i].start();
        }

        for (Thread hilo : hilosVehiculos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("ERROR");
            }
        }
        System.out.println(" [FINALIZADO] ");
    }
}