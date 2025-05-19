import java.time.Instant;

public class Invitacion {

    private Instant hora;

    public Invitacion(Instant h){
        this.hora = h;
    }

    public String getHora() {
        return "La invitacion fue enviada a las" + hora;
    }

}
