package ProcessBuilder;

import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();
        String comando;

        if (os.contains("win")) {
            comando = "notepad.exe";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            comando = "gedit";
        } else {
            System.err.println("SO invalido");
            return;
        }

        System.out.println("Ejecutando: " + comando);
        ProcessBuilder constructor = new ProcessBuilder(comando);

        try {
            Process proceso = constructor.start();

            int salida = proceso.waitFor();

            System.out.println("Proceso terminado");
            System.out.println("Codigo de salida: " + salida);

            if (salida == 0) {
                System.out.println("El proceso termino sin problemas");
            } else {
                System.out.println("El proceso termino con problemas");
            }

        } catch (IOException e) {
            System.err.println("ERROR");
        } catch (InterruptedException e) {
            System.err.println("Error");
        }
    }
}
