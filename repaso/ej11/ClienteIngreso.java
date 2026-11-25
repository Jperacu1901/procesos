package repaso.ej11;

public class ClienteIngreso implements Runnable {
    private final BilleteraVirtual billetera;

    public ClienteIngreso(BilleteraVirtual billetera) {
        this.billetera = billetera;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            billetera.ingresar(10);
        }
    }
}
