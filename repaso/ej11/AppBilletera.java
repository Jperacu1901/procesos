package repaso.ej11;

public class AppBilletera {
    public static void main(String[] args) {
        BilleteraVirtual billeteraCompartida = new BilleteraVirtual();

        Thread hiloIngreso = new Thread(new ClienteIngreso(billeteraCompartida), "Hilo-Ingreso");
        Thread hiloGasto = new Thread(new ClienteGasto(billeteraCompartida), "Hilo-Gasto");

        hiloIngreso.start();
        hiloGasto.start();

        try {
            hiloIngreso.join();
            hiloGasto.join();
        } catch (InterruptedException e) {
            System.err.println("ERROR");
            Thread.currentThread().interrupt();
        }

        System.out.println("SALDO FINAL ESPERADO: 1000€");
        System.out.println("SALDO FINAL: " + billeteraCompartida.getSaldo() + "€");
    }
}