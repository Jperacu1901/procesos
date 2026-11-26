package repaso.ej13;

public class AppProductorConsumidor {

    public static void main(String[] args) {
        BufferAcotado<String> buffer = new BufferAcotado<>(5);

        Thread p1 = new Thread(new Productor("P1", buffer, 15), "Productor-1");
        Thread p2 = new Thread(new Productor("P2", buffer, 15), "Productor-2");
        Thread c1 = new Thread(new Consumidor("C1", buffer, 15), "Consumidor-1");
        Thread c2 = new Thread(new Consumidor("C2", buffer, 15), "Consumidor-2");

        System.out.println("=== INICIANDO PRODUCTORES Y CONSUMIDORES ===");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            System.err.println("Ejecución interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("=== TODOS LOS ELEMENTOS PRODUCIDOS Y CONSUMIDOS ===");
    }
}