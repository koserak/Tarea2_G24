import java.time.*;
import java.util.*;

/**
 * Clase abstracta para las Reuniones, con metodos para invitar, tanto personas como Departamentos. Posibilidad de
 * agregar notas, asi como metodos para iniciar y finalizar la reunion, obtienene asistencias y retrasos.
 */
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
     * Constructor de la Reunion.
     * @param fecha fecha de la Reunion.
     * @param horaPrevista hora estimada de inicio de la Reunion.
     * @param duracionPrevista duracion estimada de la Reunion.
     * @param organizador empleado organizador de la Reunion.
     */
    public Reunion(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
    }

    /**
     * Metodo para invitar a un empleado o externo. Agrega una invitacion al ArrayList de invitaciones.
     * @param invitado Empleado o externo a invitar.
     */
    public void invitar(Invitable invitado) {
        invitaciones.add(new Invitacion(invitado));
        invitado.invitar();
    }

    /**
     * Invita a todo un departamento.
     * @param departamento departamento a invitar.
     */
    public void invitarDepartamento(Departamento departamento) {
        for (Empleado empleado : departamento.getEmpleados()) {
            this.invitar(empleado);
        }
    }

    /**
     * Agrega una nota al ArrayList de notas para luego ser usado en el Informe.
     * @param contenido contenido de la nota.
     */
    public void agregarNota(String contenido) {
        notas.add(new Nota(contenido));
    }

    /**
     * Inicia la Reunion.
     */
    public void iniciar() {
        horaInicio = Instant.now();
    }

    /**
     * Finaliza la Reunion.
     */
    public void finalizar() {
        horaFin = Instant.now();
    }

    /**
     * Registra si el empleado asistio a la Reunion.
     * @param empleado empleado a registrar.
     */
    public void registrarAsistencia(Empleado empleado) {
        boolean fueInvitado = invitaciones.stream()
                .anyMatch(inv -> inv.getInvitado().equals(empleado));

        if (!fueInvitado) {
            throw new EmpleadoNoInvitadoException("El empleado " + empleado.getNombre() + " no fue invitado.");
        }

        boolean yaAsistio = asistencias.stream()
                .anyMatch(a -> a.getEmpleado().equals(empleado));

        if (yaAsistio) {
            throw new AsistenciaDuplicadaException("El empleado " + empleado.getNombre() + " ya fue registrado como asistente.");
        }

        Instant llegada = Instant.now();
        LocalDateTime fechaYHora = fecha.atTime(horaPrevista);
        ZonedDateTime zonaHora = fechaYHora.atZone(ZoneId.systemDefault());
        Instant horaReferencia = zonaHora.toInstant();

        if (llegada.isAfter(horaReferencia)) {
            retrasos.add(new Retraso(empleado, llegada));
        }

        asistencias.add(new Asistencia(empleado, llegada));
    }

    /**
     * Registra la asistencia de un Departamento completo.
     * @param departamento el departamento a registrar.
     */
    public void registrarAsistenciaDepartamento(Departamento departamento) {
        for (Empleado empleado : departamento.getEmpleados()) {
            if (invitaciones.stream().anyMatch(inv -> inv.getInvitado().equals(empleado))) {
                registrarAsistencia(empleado);
            }
        }
    }

    /**
     * Getter de las Asistencias.
     * @return List de las asistencias.
     */
    public List<Empleado> obtenerAsistencias() {
        List<Empleado> resultado = new ArrayList<>();
        for (Asistencia a : asistencias) resultado.add(a.getEmpleado());
        return resultado;
    }

    /**
     * Getter de los Retrasos.
     * @return List con los retrasos.
     */
    public List<Empleado> obtenerRetrasos() {
        List<Empleado> resultado = new ArrayList<>();
        for (Retraso r : retrasos) resultado.add(r.getEmpleado());
        return resultado;
    }

    /**
     * Getter para obtener las Ausencias.
     * @return List con las Inasistencias.
     */
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

    /**
     * Getter del total de Asistencias.
     * @return int con el numero del total de personas presentes en la reunion.
     */
    public int obtenerTotalAsistencia() {
        return asistencias.size();
    }

    /**
     * Calcula el porcentaje de Asistencia a la reunion.
     * @return float con el numero de porcentaje de la Reunion.
     */
    public float obtenerPorcentajeAsistencia() {
        if (invitaciones.isEmpty()) {
            return 0f; }

        return (float) asistencias.size() / invitaciones.size() * 100f;
    }

    /**
     * Calcula la duracion de la Reunion.
     * @return float con la duracion total de la reunion.
     */
    public float calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin).toSeconds();
        }
        return 0;
    }

    /**
     * Metodo para el tipo de Reunion.
     * @return
     */
    public abstract String getTipo();

    /**
     * Getter para las notas generadas en la Reunion.
     * @return List con las notas.
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * Getter para el Organizador de la Reunion.
     * @return Empleado organizador.
     */
    public Empleado getOrganizador() {
        return organizador; }

    /**
     * Getter para los Retrasos registrados.
     * @return List con los retrasos.
     */
    public List<Retraso> getRetrasos() {
        return retrasos;
    }

}