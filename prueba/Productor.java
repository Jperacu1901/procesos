package prueba;

public class Productor extends Thread {
    private ClaseCompartida objetoCompartido;

    Productor(ClaseCompartida objetoCompartido) {
        this.objetoCompartido = objetoCompartido;
    }

    @Override
    public void run() {
        // La ejecución del método run estará normalmente gestionada por un bucle
        // que controlará el ciclo de vida del hilo y se adaptará al problema.
        // En el caso de simulaciones se harán esperas proporcionales.
        for (int i = 0; i < 100; i++) {
            try {
                // Código que hace el hilo productor
                objetoCompartido.accionDeProducir();
                // La espera es opcional
                Thread.sleep((long) (Math.random() * 1000 + 1000));
            } catch (InterruptedException ex) {

            }
        }
    }
}
