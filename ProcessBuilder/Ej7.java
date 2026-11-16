package ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej7 {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        boolean windows = os.contains("win");

        String verde = "\u001B[32m";
        String rojo = "\u001B[31m";
        String reset = "\u001B[0m";

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        ProcessBuilder constructor = new ProcessBuilder();

        if (windows) {
            constructor.command("curl.exe", "-s", "-L", "-w", "\nTIME:%{time_total}", url);
        } else {
            constructor.command("curl", "-s", "-L", "-w", "\nTIME:%{time_total}", url);
        }

        constructor.redirectErrorStream(true);

        try {
            Process proceso = constructor.start();
            String charset = windows ? "CP850" : "UTF-8";

            String json = "";
            double tiempo = -1;

            try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream(), charset))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    if (linea.startsWith("TIME:")) {
                        String tiempoTexto = linea.substring(5).trim().replace(",", ".");
                        tiempo = Double.parseDouble(tiempoTexto);
                    } else {
                        json += linea + "\n";
                    }
                }
            }

            int codigoSalida = proceso.waitFor();

            System.out.println("SO: " + os);
            System.out.println("JSON: " + json.trim());

            if (codigoSalida == 0 && tiempo >= 0 && tiempo < 1.0) {
                System.out.printf("Tiempo de respuesta: " + verde + "%.3f s" + reset + "%n", tiempo);
            } else if (codigoSalida == 0 && tiempo >= 1.0) {
                System.out.printf("Tiempo de respuesta: " + rojo + "%.3f s" + reset + "%n", tiempo);
            } else {
                System.out.println(rojo + "Error en la peticion (codigo: " + codigoSalida + ")" + reset);
            }

        } catch (IOException e) {
            System.err.println(rojo + "ERROR" + e.getMessage() + reset);
        } catch (InterruptedException e) {
            System.err.println(rojo + "ERROR" + reset);
        } catch (NumberFormatException e) {
            System.err.println(rojo + "ERROR" + reset);
        }
    }
}
