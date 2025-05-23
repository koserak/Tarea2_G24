import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Nota {
    private String contenido;
    private LocalTime hora;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Nota(String contenido) {
        this.contenido = contenido;
        this.hora = LocalTime.now();
    }

    public String getContenido() {
        return contenido;
    }

    public String getHoraFormateada() {
        return hora.format(FORMATTER);
    }

    @Override
    public String toString() {
        return "[" + getHoraFormateada() + "] " + contenido;
    }
}
