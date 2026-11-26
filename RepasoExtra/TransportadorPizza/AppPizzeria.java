package RepasoExtra.TransportadorPizza;

public class AppPizzeria {
    public static void main(String[] args) {
        MostradorPizzas buffer = new MostradorPizzas(5);

        Thread p1 = new Thread(new Cocinero("Pepe", buffer, 6));
        Thread p2 = new Thread(new Cocinero("Maricarmen", buffer, 6));

        Thread c1 = new Thread(new Repartidor("Enrique", buffer, 3));
        Thread c2 = new Thread(new Repartidor("Juan", buffer, 3));
        Thread c3 = new Thread(new Repartidor("Eva", buffer, 3));

        System.out.println(" [INICIANDO] ");

        p1.start();
        p2.start();

        c1.start();
        c2.start();
        c3.start();

        try {
            p1.join();
            p2.join();

            c1.join();
            c2.join();
            c3.join();

        } catch (InterruptedException e) {
            System.err.println("Ejecución interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println(" [FIN] ");
    }
}
