package ProcessBuilder.Ej6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltroTexto {
    public static void main(String[] args) {
        boolean entrada = false;

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    entrada = true;
                }
                System.out.println(linea.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("ERROR");
            System.exit(1);
        }

        if (!entrada) {
            System.exit(1);
        }
        System.exit(0);
    }
}
