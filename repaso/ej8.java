package repaso;

import java.io.IOException;
import java.time.Instant;

public class ej8 {
    public static void main(String[] args) {
        boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
        String[] comando = windows ? new String[] { "notepad.exe" } : new String[] { "sleep", "10" };

        ProcessBuilder constructor = new ProcessBuilder(comando);

        try {
            ProcessHandle handlePadre = ProcessHandle.current();
            Process procesoHijo = constructor.start();
            ProcessHandle handleHijo = procesoHijo.toHandle();

            Thread.sleep(500);
            System.out.println("Proceso padre:");
            mostrarInfoProceso(handlePadre);

            System.out.println("\nProceso hijo:");
            mostrarInfoProceso(handleHijo);

            System.out.println("\nCerrando subproceso...");
            procesoHijo.destroy();
            procesoHijo.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    private static void mostrarInfoProceso(ProcessHandle handle) {
        ProcessHandle.Info info = handle.info();
        System.out.println("  • PID:                 " + handle.pid());
        System.out.println("  • Comando ejecutable:  " + info.command().orElse("Desconocido"));
        System.out.println("  • Usuario propietario: " + info.user().orElse("N/A"));
        System.out.println(
                "  • Instante de inicio:  " + info.startInstant().map(Instant::toString).orElse("No disponible"));
        System.out.println("  • Tiempo CPU total:    "
                + info.totalCpuDuration().map(d -> d.toMillis() + " ms").orElse("No disponible"));
    }
}