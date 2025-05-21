import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> Empleados;

    public Departamento(String n){
        this.nombre = n;
        Empleados = new ArrayList<>();
    }

    public int obtenerCantidadEmpleados(){

        return Empleados.size();
    }

    public void addEmpleado(Empleado e){
        Empleados.add(e);
    }
}
