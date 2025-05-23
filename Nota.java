import java.time.LocalTime;

/**
 * Clase que representa una nota que se agregara al final de la reunion en el informe.
 */
public class Nota {
    private String contenido;
    private LocalTime hora;

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

    public String getHora(){
        return hora.getHour()+":"+ hora.getMinute()+":"+hora.getSecond();
    }

    @Override
    public String toString() {
        return hora + ": " + contenido;
    }
}