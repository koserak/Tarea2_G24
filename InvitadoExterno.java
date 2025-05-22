public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;

    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    @Override
    public void invitar() {
        System.out.println("Invitación externa enviada a " + nombreCompleto);
    }

    public String getNombreCompleto() {
        return nombreCompleto; }

    public String getCorreo() {
        return correo; }

    @Override
    public String toString() {
        return nombreCompleto + " (" + correo + ")";
    }
}
