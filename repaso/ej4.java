package repaso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ej4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java ProcessTimeoutMonitor <comando> [argumentos...]");
            System.err.println("Ejemplo Windows: java ProcessTimeoutMonitor ping 127.0.0.1 -n 10");
            System.err.println("Ejemplo Linux/Mac: java ProcessTimeoutMonitor sleep 10");
            System.exit(1);
        }

        ProcessBuilder constructor = new ProcessBuilder(args);
        constructor.inheritIO();
        try {
            System.out.println("Iniciando comando: " + String.join(" ", args));
            Process proceso = constructor.start();
            boolean finalizado = proceso.waitFor(3, TimeUnit.SECONDS);

            if (finalizado) {
                int exitCode = proceso.exitValue();
                System.out.println("\n[OK] El proceso finalizó a tiempo. Código de salida: " + exitCode);
            } else {
                System.err.println("Tiempo limite alcanzado, abortando");
                proceso.destroyForcibly();

                proceso.waitFor(500, TimeUnit.MILLISECONDS);

                if (!proceso.isAlive()) {
                    System.err.println("Proceso eliminado");
                } else {
                    System.err.println("ERROR: el proceso sigue activo");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al intentar ejecutar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El hilo monitor fue interrumpido mientras esperaba.");
            Thread.currentThread().interrupt();
        }
    }
}
