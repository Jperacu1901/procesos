package RepasoExtra.TransportadorPizza;

import java.util.LinkedList;
import java.util.Queue;

public class MostradorPizzas {
    private final Queue<String> cola = new LinkedList<String>();
    private final int capacidad;

    public MostradorPizzas(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void ponerPizzas(String pizza) throws InterruptedException {
        while (cola.size() == capacidad) {
            System.out.println(" [LLENO] " + Thread.currentThread().getName() + " esperando");
            wait();
        }
        cola.add(pizza);
        notifyAll();
    }

    public synchronized String recogerPizza(String nombreRepartidor) throws InterruptedException {
        while (cola.size() == 0) {
            wait();
        }
        String pizza = cola.poll();
        System.out.println("[REPARTO] " + nombreRepartidor + " recoge: " + pizza + " | Quedan: " + cola.size());
        notifyAll();
        return pizza;
    }

}
