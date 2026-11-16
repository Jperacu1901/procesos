package ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej5 {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        boolean windows = os.contains("win");

        String charset = windows ? "CP850" : "UTF-8";

        // Bloque de constructor funcional [1]

        System.out.println("Salida STDOUT");
        ProcessBuilder constructor = new ProcessBuilder();

        if (windows) {
            constructor.command("cmd.exe", "/c", "dir /b");
        } else {
            constructor.command("sh", "-c", "ls");
        }
        try {
            Process proceso1 = constructor.start();
            try (BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso1.getInputStream(), charset))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            int codigoSalida1 = proceso1.waitFor();
            System.out.println("Codigo 1:" + codigoSalida1);
        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }

        System.out.println("Comando erroneo REDIRECTERRORSSTREAM(TRUE");
        // Bloque de constructor erroneo [2]
        ProcessBuilder Malconstructor = new ProcessBuilder();

        if (windows) {
            Malconstructor.command("cmd.exe\", \"/c\", \"dir C:\\ejemplo");
        } else {
            Malconstructor.command("sh", "-c", "ls /ejemplo");
        }

        Malconstructor.redirectErrorStream(true);
        try {
            Process proceso2 = Malconstructor.start();
            try (BufferedReader lectorError = new BufferedReader(
                    new InputStreamReader(proceso2.getInputStream(), charset))) {
                String linea;
                while ((linea = lectorError.readLine()) != null) {
                    System.out.println("Flujo " + linea);
                }
            }
            int codigoSalida2 = proceso2.waitFor();
            System.out.println("Codigo de salida 2: " + codigoSalida2);
        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        }
    }
}
