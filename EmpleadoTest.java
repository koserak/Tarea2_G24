import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para los empleados.
 */
public class EmpleadoTest {
    @Test
    public void testToString() {
        Departamento depto = new Departamento("TI");
        Empleado e = new Empleado("1", "Soto", "Ariel", "ariel@mail.com", depto);
        assertEquals("Ariel Soto (ariel@mail.com)", e.toString());
    }
}