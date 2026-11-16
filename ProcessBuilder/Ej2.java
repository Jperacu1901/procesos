package ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Introduce la instruccion: ");
        String entrada = leer.nextLine().trim();

        if (entrada.isEmpty()) {
            System.err.println("No se ha introducido ninguna instrucción.");
            return;
        }

        String[] tokens = entrada.split("\\s+");

        ProcessBuilder constructor = new ProcessBuilder(tokens);

        List<String> comandoConfigurado = constructor.command();
        System.out.println("Comando: " + comandoConfigurado);
        System.out.println("Programa: " + comandoConfigurado.get(0));
        System.out.println("Argumentos: " + comandoConfigurado.subList(1, comandoConfigurado.size()));

        try {
            Process proceso = constructor.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            int codigoSalida = proceso.waitFor();

            System.out.println("Proceso terminado");
            System.out.println("Código (exit code): " + codigoSalida);

        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("ERROR");
        } finally {
            leer.close();
        }
    }
}