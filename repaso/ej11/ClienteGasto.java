package repaso.ej11;

public class ClienteGasto implements Runnable {
    private final BilleteraVirtual billetera;

    public ClienteGasto(BilleteraVirtual billetera) {
        this.billetera = billetera;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            billetera.retirar(10);
        }
    }
}