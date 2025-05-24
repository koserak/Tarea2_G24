import java.time.*;

/**
 * Clase para las Reuniones de forma presencial.
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Constructor que llama al super de Reunion.
     * @param fecha la fecha de la Reunion.
     * @param hora la hora de inicio de la Reunion.
     * @param duracion duracion estimada de la Reunion.
     * @param organizador Empleado organizado de la Reunion.
     * @param sala Sala presencial de la Reunion.
     */
    public ReunionPresencial(LocalDate fecha, LocalTime hora, Duration duracion, Empleado organizador, String sala) {
        super(fecha, hora, duracion, organizador);
        this.sala = sala;
    }

    /**
     * Getter para la sala donde se realizara la reunion.
     * @return String con la sala donde se realizara.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Getter para el tipo de Reunion.
     * @return String con "Presencial"
     */
    @Override
    public String getTipo() {
        return "Presencial";
    }
}
