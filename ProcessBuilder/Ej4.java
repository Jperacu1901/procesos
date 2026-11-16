package ProcessBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ej4 {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String comando;

        if (os.contains("win")) {
            comando = "notepad.exe";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            comando = "gedit";
        } else {
            System.out.println("ERROR");
            return;
        }

        System.out.println("Iniciando");
        ProcessBuilder constructor = new ProcessBuilder(comando);

        try {
            Process proceso = constructor.start();
            System.out.println("Esperando 4segundos");
            boolean terminadoATiempo = proceso.waitFor(4, TimeUnit.SECONDS);

            if (!terminadoATiempo && proceso.isAlive()) {
                System.out.println("Tiempo terminado");
                proceso.destroyForcibly();
                proceso.waitFor();
            } else {
                System.out.println("Proceso finalizado");
            }

            int codigoSalida = proceso.exitValue();
            System.out.println("Codigo: " + codigoSalida);
        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
