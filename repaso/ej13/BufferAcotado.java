package repaso.ej13;

import java.util.LinkedList;
import java.util.Queue;

public class BufferAcotado<T> {

    private final Queue<T> cola = new LinkedList<>();
    private final int capacidad;

    public BufferAcotado(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void producir(T elemento) throws InterruptedException {
        while (cola.size() == capacidad) {
            System.out.println("  [LLENO] " + Thread.currentThread().getName() + " espera hueco...");
            wait();
        }

        cola.add(elemento);
        System.out.println(">>> [PRODUCE] " + Thread.currentThread().getName() + " -> " + elemento + " (Ocupación: "
                + cola.size() + "/" + capacidad + ")");

        notifyAll();
    }

    public synchronized T consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            System.out.println("  [VACÍO] " + Thread.currentThread().getName() + " espera datos...");
            wait();
        }

        T elemento = cola.poll();
        System.out.println("<<< [CONSUME] " + Thread.currentThread().getName() + " <- " + elemento + " (Ocupación: "
                + cola.size() + "/" + capacidad + ")");

        notifyAll();
        return elemento;
    }
}