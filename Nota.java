import java.time.LocalTime;

public class Nota {
    private String contenido;
    private LocalTime hora;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.hora = LocalTime.now();
    }

    public String getContenido() {
        return contenido;
    }

    public String getHora(){
        return hora.getHour()+":"+ hora.getMinute()+":"+hora.getSecond();
    }

    @Override
    public String toString() {
        return hora + ": " + contenido;
    }
}