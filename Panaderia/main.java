package Panaderia;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Mostrador mostrador = new Mostrador();

        panadero panadero = new panadero(mostrador, 15);

        cliente cliente1 = new cliente(mostrador, "Cliente 1");
        cliente cliente2 = new cliente(mostrador, "Cliente 2");
        cliente cliente3 = new cliente(mostrador, "Cliente 3");

        panadero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();

        // Esperamos a que todos terminen
        panadero.join();
        cliente1.join();
        cliente2.join();
        cliente3.join();

        System.out.println("Panadería cerrada. Todos los clientes servidos.");
    }
}