package repaso.ej9;

public class GestionAlmacenApp {
    public static void main(String[] args) {
        Thread t1 = new Thread(new OperarioAlmacen("Pepe", 4), "Operario 1");
        Thread t2 = new Thread(new OperarioAlmacen("Manolo", 4), "Operario 2");
        Thread t3 = new Thread(new OperarioAlmacen("Maricarmen", 4), "Operario 3");

        System.out.println("INICIANDO");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("ERROR");
            Thread.currentThread().interrupt();
        }
        System.out.println("TERMINADO");
    }
}
