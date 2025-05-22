import java.time.Instant;

public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;

    public Asistencia(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado; }

    public Instant getHoraLlegada() {
        return horaLlegada; }
}
