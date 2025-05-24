import java.time.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Departamento depTI = new Departamento("TI");
        Empleado ariel = new Empleado("1", "Fernandez", "Ariel", "ariel@gmail.com", depTI);
        Empleado juan = new Empleado("2", "Perez", "Juan", "juancito@gmail.com", depTI);
        InvitadoExterno externo = new InvitadoExterno("Maria Lopez", "mariatieneuncordero@hotmail.com");

        LocalTime horaPrevista = LocalTime.now().plusSeconds(1);

        ReunionVirtual reunion = new ReunionVirtual(LocalDate.now(), horaPrevista, Duration.ofMinutes(45), ariel, "https://meet.com/123");

        reunion.invitar(ariel);
        reunion.invitar(juan);
        reunion.invitar(externo);

        Departamento marketing = new Departamento("Marketing");
        Empleado cris = new Empleado("3", "Rodriguez", "Juan", "juan@gmail.com", marketing);
        Empleado maria = new Empleado("4", "Valenzuela", "Margarita", "mria32@gmail.com", marketing);
        marketing.agregarEmpleado(cris);
        marketing.agregarEmpleado(maria);

        reunion.invitarDepartamento(marketing);

        reunion.iniciar();
        reunion.registrarAsistencia(ariel);
        Thread.sleep(2000);
        reunion.registrarAsistencia(juan);
        Thread.sleep(2000);
        reunion.registrarAsistenciaDepartamento(marketing);
        reunion.agregarNota("Inicio con presentación de Ariel.");
        Thread.sleep(3000);
        reunion.agregarNota("Juan explicó la teoría de los analfabetos.");
        Thread.sleep(2000);
        reunion.agregarNota("Maria explica estrategia para no reprobar cálculo.");
        reunion.finalizar();

        try {
            Informe.generarInformeTxt(reunion, "informe.txt");
            System.out.println("Informe generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar asistentes
        System.out.println("Asistieron: ");
        for (Empleado e : reunion.obtenerAsistencias()) {
            System.out.println(" - " + e);
        }

        System.out.println("Retrasos:");
        for (Empleado e : reunion.obtenerRetrasos()) {
            System.out.println(" - " + e);
        }

        System.out.println("Ausentes:");
        for (Invitable i : reunion.obtenerAusencias()) {
            System.out.println(" - " + i);
        }
    }
}
