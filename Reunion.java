import java.time.*;
import java.util.*;

public abstract class Reunion {
    protected LocalDate fecha;
    protected LocalTime horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFin;

    protected Empleado organizador;
    protected List<Invitacion> invitaciones = new ArrayList<>();
    protected List<Nota> notas = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();
    protected List<Retraso> retrasos = new ArrayList<>();

    /**
     *
     * @param fecha Fecha de la Reunion.
     * @param horaPrevista Hora de inicio estimada.
     * @param duracionPrevista Duracion estimada de la reunion.
     * @param organizador Empleado que crea esta reunion.
     */
    public Reunion(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
    }

    public void invitar(Invitable invitado) {
        invitaciones.add(new Invitacion(invitado));
        invitado.invitar();
    }


    public void agregarNota(String contenido) {
        notas.add(new Nota(contenido));
    }

    public void iniciar() {
        horaInicio = Instant.now();
    }

    public void finalizar() {
        horaFin = Instant.now();
    }

    public void registrarAsistencia(Empleado empleado) {
        Instant llegada = Instant.now();
        if (horaInicio != null && llegada.isAfter(horaInicio)) {
            retrasos.add(new Retraso(empleado, llegada));
        }
        asistencias.add(new Asistencia(empleado, llegada));
    }

    public List<Empleado> obtenerAsistencias() {
        List<Empleado> resultado = new ArrayList<>();
        for (Asistencia a : asistencias) resultado.add(a.getEmpleado());
        return resultado;
    }

    public List<Empleado> obtenerRetrasos() {
        List<Empleado> resultado = new ArrayList<>();
        for (Retraso r : retrasos) resultado.add(r.getEmpleado());
        return resultado;
    }

    public List<Invitable> obtenerAusencias() {
        List<Invitable> ausentes = new ArrayList<>();
        for (Invitacion inv : invitaciones) {
            if (inv.getInvitado() instanceof Empleado empleado) {
                boolean asistio = asistencias.stream().anyMatch(a -> a.getEmpleado().equals(empleado));
                if (!asistio) ausentes.add(empleado);
            } else {
                ausentes.add(inv.getInvitado());
            }
        }
        return ausentes;
    }

    public int obtenerTotalAsistencia() {
        return asistencias.size();
    }

    public float obtenerPorcentajeAsistencia() {
        if (invitaciones.isEmpty()) {
            return 0f; }

        return (float) asistencias.size() / invitaciones.size() * 100f;
    }

    public float calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin).toMinutes();
        }
        return 0;
    }

    public abstract String getTipo();

    public List<Nota> getNotas() {
        return notas; }

    public Empleado getOrganizador() {
        return organizador; }
}
