package ProcessBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Ej3 {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        boolean windows = os.contains(("win"));

        ProcessBuilder constructor = new ProcessBuilder();

        String tempPath = System.getProperty("java.io.tmpdir");
        File ruta = new File(tempPath);
        constructor.directory(ruta);

        System.out.println("Directorio configurado");

        Map<String, String> entorno = constructor.environment();
        entorno.put("PSP_MODO_EJECUCION", "PRODUCCION_AUTOMATIZADA");

        if (windows) {
            constructor.command("cmd.exe", "/c",
                    "echo Directorio actual: %CD% && echo Modo de ejecucion: %PSP_MODO_EJECUCION%");
        } else {
            constructor.command("sh", "-c",
                    "echo Directorio actual: $(pwd) && echo Modo de ejecucion: $PSP_MODO_EJECUCION");
        }
        try {
            Process proceso = constructor.start();
            String charset = windows ? "CP850" : "UTF-8";
            try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream(), charset))) {
                String linea;
                System.out.println("Salida hijo");
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            int codigoSalia = proceso.waitFor();
            System.out.println("Codigo de finalizacion: " + codigoSalia);
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }
}
