import java.time.LocalTime;

public class Nota {
    private String contenido;
    private LocalTime hora;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.hora = LocalTime.now();
    }

    public String getContenido() { return contenido; }
    public LocalTime getHora() { return hora; }

    @Override
    public String toString() {
        return hora + ": " + contenido;
    }
}