import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una nota que se agregara al final de la reunion en el informe.
 */
public class Nota {
    private String contenido;
    private LocalTime hora;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Constructor de la nota.
     * @param contenido String con el contenido de esta.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
        this.hora = LocalTime.now();
    }

    /**
     * Getter para obtener el contenido de la nota.
     * @return String con el contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Metodo que pasa el LocalTime de java por un Formato especifico.
     * @return String con la hora en formato HH:MM:SS.
     */
    public String getHoraFormateada(){
        return hora.format(FORMATTER);
    }

    /**
     * Metodo usado en el informe para entregar los datos de la nota.
     * @return String con la siguiente estructura "[HH:MM:SS] contenido"
     */
    @Override
    public String toString() {
        return "[" + getHoraFormateada() + "] " + contenido;
    }
}