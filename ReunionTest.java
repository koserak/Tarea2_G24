import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {
    @Test
    public void testAsistenciaYRetraso() {
        Departamento d = new Departamento("TI");
        Empleado org = new Empleado("1", "Soto", "Ariel", "a@mail.com", d);
        Empleado e = new Empleado("2", "Pérez", "Juan", "j@mail.com", d);

        ReunionPresencial r = new ReunionPresencial(LocalDate.now(), LocalTime.of(10, 0), Duration.ofMinutes(60), org, "Sala 101");
        r.invitar(e);
        r.iniciar();
        r.registrarAsistencia(e);
        assertEquals(1, r.obtenerTotalAsistencia());
        assertTrue(r.obtenerAsistencias().contains(e));
    }
}