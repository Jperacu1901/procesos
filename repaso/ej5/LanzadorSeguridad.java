package repaso.ej5;

import java.io.File;
import java.util.Scanner;

public class LanzadorSeguridad {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce la contraseña: ");
        String Clave = leer.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java target/classes  repaso.ej5 ValidadorClave " + Clave);
    }
}
