import java.time.Instant;

public class Invitacion {
    private Invitable invitado;
    private Instant horaInvitacion;

    public Invitacion(Invitable invitado) {
        this.invitado = invitado;
        this.horaInvitacion = Instant.now();
    }


    public Invitable getInvitado() {
        return invitado;
    }

    public Instant getHoraInvitacion() {
        return horaInvitacion;
    }
}