package ProcessBuilder.Ej6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

public class LanzadorFiltro {
    public static void main(String[] args) {
        File entrada = new File("datos_entrada.txt");
        File log = new File("Salida_filtro.log");

        try (PrintWriter escritor = new PrintWriter(new FileWriter(entrada))) {
            escritor.println("Hola");
            escritor.println("Procesos y servicios");
            escritor.println("Redireccion de flujos");
        } catch (IOException e) {
            System.err.println("ERROR");
            return;
        }

        ProcessBuilder constructor = new ProcessBuilder("java", "ProcesBuilder.FiltroTexto");
        constructor.directory(new File("build/classes"));

        constructor.redirectInput(Redirect.from(entrada.getAbsoluteFile()));
        constructor.redirectOutput(Redirect.appendTo(log.getAbsoluteFile()));

        try {
            Process proceso = constructor.start();
            int codigo = proceso.waitFor();

            System.out.println("Codigo salida: " + codigo);
        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
