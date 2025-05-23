/**
 * Clase para un Invitado externo a todos los departamentos, que no es empleado.
 */

public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;

    /**
     * Constructor que guarda los datos de la persona externa.
     * @param nombreCompleto Nombre Completo del externo separado por espacios.
     * @param correo Correo del externo.
     */
    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    @Override
    public void invitar() {
        System.out.println("Invitación externa enviada a " + nombreCompleto);
    }
    /**
     * Getter para obtener el nombre completo del externo.
     * @return un String con el nombre del externo.
     */
    public String getNombreCompleto() {
        return nombreCompleto; }

    /**
     * Getter para obtener el correo del externo.
     * @return un String con el correo del externo.
     */
    public String getCorreo() {
        return correo; }

    /**
     * Getter para obtener el correo del externo.
     * @return un String con el correo del externo.
     */
    @Override
    public String toString() {
        return nombreCompleto + " (" + correo + ")";
    }
}
