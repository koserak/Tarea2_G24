import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * Esta clase escribe un archivo .txt con datos de la reunion tales como, El tipo de reunion, el organizador,
 * la fecha, hora de inicio, termino y duracion, asi como sus participantes, el porcentaje de asistencia y
 * las notas hechas en la reunion.
 */
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
            DateTimeFormatter horaFmt = DateTimeFormatter.ofPattern("HH:mm:ss");

            String inicioFormateado = reunion.horaInicio != null
                    ? LocalDateTime.ofInstant(reunion.horaInicio, ZoneId.systemDefault()).format(horaFmt)
                    : "No iniciada";

            String finFormateado = reunion.horaFin != null
                    ? LocalDateTime.ofInstant(reunion.horaFin, ZoneId.systemDefault()).format(horaFmt)
                    : "No finalizada";

            writer.write("Hora de inicio real: " + inicioFormateado + "\n");
            writer.write("Hora de término real: " + finFormateado + "\n");

            writer.write("Duración real: " + reunion.calcularTiempoReal() + " segundos\n");
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
                writer.write(" - " + n + "\n");
            }
        }
    }
}
