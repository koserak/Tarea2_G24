import java.util.ArrayList;
import java.util.List;

/**
 * Clase que agrupa Empleados en un departamento.
 */
public class Departamento {
    private String nombre;
    private List<Empleado> empleados;
    /**
     * Constructor para el Departamento.
     * @param nombre Nombre del Departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Getter para el nombre del departamento.
     * @return String con el nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Añade empleados al departamento.
     *
     * @param e Empleado a añadir.
     */
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }
    /**
     * Obtiene la cantidad de empleados actual en el departamento.
     * @return entero con la cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     * Getter para conseguir los empleados del departamento.
     * @return Lista con todos los empleados del departamento.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
