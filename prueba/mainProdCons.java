package prueba;

/**
 *
 * @author profe-admin
 */
public class mainProdCons {
    public static void main(String[] args) throws InterruptedException {
        ClaseCompartida objetoCompartido = new ClaseCompartida();

        Productor productor = new Productor(objetoCompartido);
        Consumidor consumidor1 = new Consumidor(objetoCompartido);
        Consumidor consumidor2 = new Consumidor(objetoCompartido);

        productor.start();
        consumidor1.start();
        consumidor2.start();

        // Esperamos a que acaben todos los hilos
        productor.join();
        consumidor1.join();
        consumidor2.join();

        // Acciones a realizar una vez hayan acabado el productor y los consumidores
    }
}