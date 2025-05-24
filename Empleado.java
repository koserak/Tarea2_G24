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

    /**
     * Metodo para informar que la invitacion se realizó.
     */
    @Override
    public void invitar() {
        System.out.println("Invitación enviada a " + nombre + " " + apellidos);
    }

    /**
     * Getter para la ID del empleado.
     * @return String con la ID del empleado.
     */
    public String getId() {
        return id;
    }
    /**
     * Getter para los Apellidos del empleado.
     * @return String con los Apellidos del empleado separados por un espacio.
     */
    public String getApellidos() {
        return apellidos; }
    /**
     * Getter para el nombre del empleado.
     * @return String con el nombre del empleado.
     */
    public String getNombre() {
        return nombre; }
    /**
     * Getter para el correo electronico del empleado.
     * @return String con la direccion de correo del empleado.
     */
    public String getCorreo() {
        return correo; }
    /**
     * Getter para el departamento al que pertenece el empleado.
     * @return String con el nombre del departamento.
     */
    public Departamento getDepartamento() {
        return departamento; }
    /**
     * @return el nombre completo del Empleado y su correo electronico
     */
    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + correo + ")";
    }
}
