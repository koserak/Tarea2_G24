/**
 * Clase que representa a un empleado con Nombre, Apellidos, el departamento al que pertenece, su id,
 * y su correo electronico.
 */

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;

    /**
     * Constructor de la clase Empleado, guarda los siguientes parámetros:
     *
     * @param id Id del empleado.
     * @param apellidos Apellidos del empleado separados por un espacio.
     * @param nombre Nombre del empleado.
     * @param correo Correo electrónico del empleado.
     * @param departamento Departamento al que pertenece el empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }


    @Override
    public void invitar() {
        System.out.println("Invitación enviada a " + nombre + " " + apellidos);
    }

    public String getId() {
        return id; }

    public String getApellidos() {
        return apellidos; }

    public String getNombre() {
        return nombre; }

    public String getCorreo() {
        return correo; }

    public Departamento getDepartamento() {
        return departamento; }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + correo + ")";
    }
}
