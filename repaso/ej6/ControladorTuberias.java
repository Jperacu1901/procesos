package repaso.ej6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ControladorTuberias {
    public static void main(String[] args) {
        ProcessBuilder constructor = new ProcessBuilder("java", "-cp", "target/classes",
                "repaso.ej6.TransformadorMayusculas");
        constructor.directory(new File("."));

        String[] frases = {
                "hola mundo",
                "no se que poner",
                "imagina que tienes dos vacas"
        };

        try {
            Process proceso = constructor.start();
            try (PrintWriter escritor = new PrintWriter(
                    new OutputStreamWriter(proceso.getOutputStream(), StandardCharsets.UTF_8), true);
                    BufferedReader lector = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
                for (String frase : frases) {
                    System.out.println("[Padre envia] -> " + frase);
                    escritor.println(frase);

                    String respuesta = lector.readLine();
                    System.out.println("[Padre recibe] <- " + respuesta);
                }
                System.out.println("[Padre envia] -> FIN");
                escritor.println("FIN");
            }
            int codigo = proceso.waitFor();
            System.out.println("Subproceso finalizado: " + codigo);
        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
