import java.util.ArrayList;

public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String n){
        this.nombre = n;
        empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado e){
        empleados.add(e);
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    @Override
    public ArrayList<Empleado> getEmpleadosInvitados() {
        return empleados;
    }
}
