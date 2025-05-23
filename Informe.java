import java.io.*;
import java.time.format.DateTimeFormatter;

public class Informe {
    public static void generarInformeTxt(Reunion reunion, String rutaArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("INFORME DE REUNIÓN\n");
            writer.write("-------------------\n");
            writer.write("Tipo de reunión: " + reunion.getTipo() + "\n");
            writer.write("Organizador: " + reunion.getOrganizador() + "\n");
            writer.write("Fecha: " + reunion.fecha.format(DateTimeFormatter.ISO_DATE) + "\n");
            writer.write("Hora prevista: " + reunion.horaPrevista + "\n");
            writer.write("Duración prevista: " + reunion.duracionPrevista.toMinutes() + " min\n");
            writer.write("Hora de inicio real: " + reunion.horaInicio + "\n");
            writer.write("Hora de término real: " + reunion.horaFin + "\n");
            writer.write("Duración real: " + reunion.calcularTiempoReal() + " min\n");
            writer.write("\nParticipantes: " + reunion.obtenerTotalAsistencia() + "/" + reunion.invitaciones.size() +
                    " (" + String.format("%.2f", reunion.obtenerPorcentajeAsistencia()) + "%)\n");

            writer.write("\nAsistentes:\n");
            for (Empleado e : reunion.obtenerAsistencias()) {
                writer.write(" - " + e + "\n");
            }

            writer.write("\nRetrasos:\n");
            for (Empleado e : reunion.obtenerRetrasos()) {
                writer.write(" - " + e + "\n");
            }

            writer.write("\nAusencias:\n");
            for (Invitable i : reunion.obtenerAusencias()) {
                writer.write(" - " + i + "\n");
            }

            writer.write("\nNotas:\n");
            for (Nota n : reunion.getNotas()) {
                writer.write(" - [" + n.getHora() + "] " + n.getContenido() + "\n");
            }
        }
    }
}
