package repaso.ej5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzadorSeguridad {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce la contraseña: ");
        String Clave = leer.nextLine();

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "target/classes", "repaso.ej5.ValidadorClave", Clave);

        pb.directory(new File("."));
        try {
            Process p = pb.start();
            int Codigo = p.waitFor();

            switch (Codigo) {
                case 0:
                    System.out.println("Contraseña valida");
                    break;
                case 10:
                    System.out.println("Contraseña debil");
                    break;
                case 20:
                    System.out.println("No se proporciono nada");
                    break;
                default:
                    System.out.println("ERROR (código " + Codigo + ")");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        leer.close();
    }
}