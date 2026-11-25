package repaso;

import java.io.File;
import java.io.IOException;

public class ej7 {
    public static void main(String[] args) {
        File log = new File("Auditoria_red.log");
        ProcessBuilder constructor = new ProcessBuilder("ping", "-n", "3", "google.com");
        constructor.redirectErrorStream(true);
        constructor.redirectOutput(ProcessBuilder.Redirect.appendTo(log));

        try {
            System.out.println("Ejecutando " + log.getName());
            Process proceso = constructor.start();
            int codigo = proceso.waitFor();

            System.out.println("Codigo salida: " + codigo);
            System.out.println("Ruta del log: " + log.getAbsolutePath());
            System.out.println("Tamaño del log: " + log.length() + " Bytes");

        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
