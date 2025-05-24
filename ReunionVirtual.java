import java.time.*;

/**
 * Clase para las Reuniones de forma virtual.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor que llama al super de Reunion.
     * @param fecha la fecha de la Reunion.
     * @param hora la hora de inicio de la Reunion.
     * @param duracion duracion estimada de la Reunion.
     * @param organizador Empleado organizado de la Reunion.
     * @param enlace String con el link de la Reunion.
     */
    public ReunionVirtual(LocalDate fecha, LocalTime hora, Duration duracion, Empleado organizador, String enlace) {
        super(fecha, hora, duracion, organizador);
        this.enlace = enlace;
    }

    /**
     * Getter para el Enlace de la reunion.
     * @return String con el link.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Getter para el tipo de Reunion.
     * @return String con "Virtual"
     */
    @Override
    public String getTipo() {
        return "Virtual";
    }
}
