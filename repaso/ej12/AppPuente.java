package repaso.ej12;

public class AppPuente {
    public static void main(String[] args) {
        PuenteEstrecho puente = new PuenteEstrecho();

        Thread[] coches = new Thread[5];
        for (int i = 0; i < coches.length; i++) {
            String nombreCoche = "Coche-" + (i + 1);
            coches[i] = new Thread(new Coche(nombreCoche, puente), nombreCoche);
        }
        System.out.println("[INICIO]");

        for (Thread c : coches) {
            c.start();
        }

        try {
            for (Thread c : coches) {
                c.join();
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
        System.out.println("[FIN]");
    }
}
