package mingeso.ev2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

@SpringBootTest
public class OficinaMaratonTest {
    // Se crean 3 corredores para realizar las pruebas
    Corredor corredor1 = new Corredor();
    Corredor corredor2 = new Corredor();
    Corredor corredor3 = new Corredor();
    Corredor corredor4 = new Corredor();

    OficinaMaraton oficina = new OficinaMaraton();

    @Test
    void calcularTiempoTestTiempoNormal(){
        corredor1.setCheckPoint1("00:02:12");
        int tiempo = oficina.calcularTiempo(corredor1.getCheckPoint1());
        System.out.println(tiempo);
        assertEquals(132,tiempo);
    }
    @Test
    void calcularTiempoTestTiempo0(){
        corredor1.setCheckPoint1("00:00:00");
        int tiempo = oficina.calcularTiempo(corredor1.getCheckPoint1());
        System.out.println(tiempo);
        assertEquals(0,tiempo);
    }

    // TESTS calcularCorredorPrimerPuesto
    @Test
    void calcularCorredorPrimerPuestoTestLucas(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("01:52:44");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("02:01:05");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointLlegada("01:35:16");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointLlegada("02:25:09");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        String ganador;
        ganador = oficina.calcularCorredorPrimerPuesto(corredores);
        assertEquals("Lucas", ganador);
    }
    @Test
    void calcularCorredorPrimerPuestoTestJoseYUnoNoCorre() {
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("01:52:44");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("01:01:05");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointLlegada("01:35:16");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointLlegada("00:00:00");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        String ganador;
        ganador = oficina.calcularCorredorPrimerPuesto(corredores);
        assertEquals("Jose", ganador);
    }

    // TESTS calcularTiempoPromedioCorredores()
    @Test
    void calcularTiempoPromedioCorredoresTestDosCorredores(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("01:52:44");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("02:01:05");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        String promedio;
        promedio = oficina.calcularTiempoPromedioCorredores(corredores);
        assertEquals("01:56:54", promedio);
    }
    @Test
    void calcularTiempoPromedioCorredoresTestCuatroCorredores(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("01:10:00");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("01:20:00");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointLlegada("01:00:00");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointLlegada("01:30:00");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        String promedio;
        promedio = oficina.calcularTiempoPromedioCorredores(corredores);
        assertEquals("01:15:00", promedio);
    }
    // TESTS calcularPorcentajeCorredoresQueLlegaronMeta()
    @Test
    void calcularPorcentajeCorredoresQueLlegaronMetaTestTodosLLegaron(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("01:52:44");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("02:01:05");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointLlegada("01:35:16");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointLlegada("02:25:09");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        double porcentaje;
        porcentaje = oficina.calcularPorcentajeCorredoresQueLlegaronMeta(corredores);
        assertEquals(100, porcentaje);
    }
    @Test
    void calcularPorcentajeCorredoresQueLlegaronMetaTestUnoNoLLego(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointLlegada("00:00:00");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointLlegada("02:01:05");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointLlegada("01:35:16");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointLlegada("02:25:09");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        double porcentaje;
        porcentaje = oficina.calcularPorcentajeCorredoresQueLlegaronMeta(corredores);
        assertEquals(75, porcentaje);
    }

    // TESTS calcularPorcentajeCorredoresQueNoCorrieron()
    @Test
    void calcularPorcentajeCorredoresQueNoCorrieronTestTodosCorrieron(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointPartida("00:00:08");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointPartida("00:00:08");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointPartida("00:00:07");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointPartida("00:00:09");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        double porcentaje;
        porcentaje = oficina.calcularPorcentajeCorredoresQueNoCorrieron(corredores);
        assertEquals(0, porcentaje);
    }
    @Test
    void calcularPorcentajeCorredoresQueNoCorrieronTestDosNoCorrieron(){
        corredor1.setNombre("Juan");
        corredor1.setCheckPointPartida("00:00:00");
        corredor2.setNombre("Jose");
        corredor2.setCheckPointPartida("00:00:08");
        corredor3.setNombre("Lucas");
        corredor3.setCheckPointPartida("00:00:07");
        corredor4.setNombre("Javier");
        corredor4.setCheckPointPartida("00:00:00");
        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);
        double porcentaje;
        porcentaje = oficina.calcularPorcentajeCorredoresQueNoCorrieron(corredores);
        assertEquals(50, porcentaje);
    }
}