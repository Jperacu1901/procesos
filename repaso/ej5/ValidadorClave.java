package repaso.ej5;

public class ValidadorClave {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            System.exit(20);
        }

        String Clave = args[0];
        if (Clave.length() < 8) {
            System.exit(10);
        }

        boolean hayNumero = false;
        for (int i = 0; i < Clave.length(); i++) {
            char letra = Clave.charAt(i);
            if (Character.isDigit(letra)) {
                hayNumero = true;
                break;
            }
        }

        if (hayNumero) {
            System.exit(0);
        } else {
            System.exit(10);
        }
    }
}