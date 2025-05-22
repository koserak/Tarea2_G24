import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
