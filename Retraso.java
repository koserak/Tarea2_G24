import java.time.Instant;

/**
 * Clase para marcar el retraso de un Empleado a la Reunion.
 */
public class Retraso {
    private Empleado empleado;
    private Instant horaLlegada;

    /**
     * Constructor guarda al empleado y la hora a la que llegó.
     * @param empleado El empleado.
     * @param horaLlegada Hora a la que llego el empleado.
     */
    public Retraso(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    /**
     * Getter para el empleado que llego tarde.
     * @return Empleado.
     */
    public Empleado getEmpleado() {
        return empleado; }

    /**
     * Getter para la hora a la que llego el Empleado.
     * @return Instant con la hora de llegada del Empleado.
     */
    public Instant getHoraLlegada() {
        return horaLlegada; }
}
