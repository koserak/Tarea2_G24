import java.time.*;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(LocalDate fecha, LocalTime hora, Duration duracion, Empleado organizador, String sala) {
        super(fecha, hora, duracion, organizador);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    @Override
    public String getTipo() {
        return "Presencial";
    }
}
