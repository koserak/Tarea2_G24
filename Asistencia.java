public class Asistencia {
    private Empleado empleado;
    private boolean asistio;

    public Asistencia(Empleado e, boolean a){
        this.empleado = e;
        this.asistio = a;
    }

    public Empleado getEmpleado() { return empleado; }
    public boolean isAsistio() { return asistio; }
}

