package repaso.ej6;

import java.util.Scanner;

public class TransformadorMayusculas {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();

            if ("FIN".equals(linea)) {
                break;
            }
            System.out.println("Transformado: " + linea.toUpperCase());
        }
        leer.close();
    }
}
