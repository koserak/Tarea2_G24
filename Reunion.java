import java.time.*;
import java.util.*;

public abstract class Reunion {

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private ArrayList<Empleado> invitados = new ArrayList<>();
    private ArrayList<Asistencia> asistencias = new ArrayList<>();

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
    }

    public void agregarInvitado(Invitable invitado) {
        for (Empleado e : invitado.getEmpleadosInvitados()) {
            if (!invitados.stream().anyMatch(emp -> emp.getId().equals(e.getId()))) {
                invitados.add(e);
            }
        }
    }

    public void registrarAsistencia(Empleado e, boolean asistio) {
        asistencias.add(new Asistencia(e, asistio));
    }

    public ArrayList<Empleado> obtenerAsistencias() {
        ArrayList<Empleado> presentes = new ArrayList<>();
        for (Asistencia a : asistencias) {
            if (a.isAsistio()) {
                presentes.add(a.getEmpleado());
            }
        }
        return presentes;
    }

    public ArrayList<Empleado> obtenerAusencias() {
        ArrayList<Empleado> ausentes = new ArrayList<>();
        for (Empleado invitado : invitados) {
            boolean asistio = false;
            for (Asistencia a : asistencias) {
                if (a.getEmpleado().getId().equals(invitado.getId()) && a.isAsistio()) {
                    asistio = true;
                    break;
                }
            }
            if (!asistio) {
                ausentes.add(invitado);
            }
        }
        return ausentes;
    }

    public int obtenerTotalAsistencias() {
        int total = 0;
        for (Asistencia a : asistencias) {
            if (a.isAsistio()) {
                total++;
            }
        }
        return total;
    }

    public double obtenerPorcentajeAsistencias() {
        if (invitados.isEmpty()) return 0;
        return (100.0 * obtenerTotalAsistencias()) / invitados.size();
    }
}
