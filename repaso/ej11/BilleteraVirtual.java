package repaso.ej11;

public class BilleteraVirtual {
    private int saldo = 1000;

    public synchronized void ingresar(int cantidad) {
        saldo += cantidad;
    }

    public synchronized void retirar(int cantidad) {
        saldo -= cantidad;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}
