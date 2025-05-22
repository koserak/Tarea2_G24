import java.util.ArrayList;

public class Empleado implements Invitable {

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String i, String n, String a, String c){
        this.id = i;
        this.nombre = n;
        this.apellidos = a;
        this.correo = c;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getCorreo() { return correo; }

    @Override
    public ArrayList<Empleado> getEmpleadosInvitados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add(this);
        return lista;
    }
}