import java.time.*;

public class ReunionVirtual extends Reunion {
    private String enlace;


    public ReunionVirtual(LocalDate fecha, LocalTime hora, Duration duracion, Empleado organizador, String enlace) {
        super(fecha, hora, duracion, organizador);
        this.enlace = enlace;
    }

    public String getEnlace() { return enlace; }

    @Override
    public String getTipo() {
        return "Virtual";
    }
}
