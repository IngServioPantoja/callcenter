package callcenter;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import co.com.call.service.EmpleadoService;
import co.com.call.service.LlamadaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegracionTest {

  @After
  public void limpiarDependencias() {
    LlamadaService.getInstance().limpiarLlamadasEncoladas();
    LlamadaService.getInstance().limpiarLlamadasConcurrentes();
    EmpleadoService.getInstance().desconectarEmpleados();
  }

  @Test
  public void a1DiezLlamadasConcurrentesSinOperadores() throws Exception {
    System.out.println("0 Operadores con 10 llamadas concurrentes todas son encoladas");

    final CallCenter callCenter = new CallCenter();
    callCenter.generarLlamadas(10, 0);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamadasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(10, llamadasEncoladas.intValue());
  }

  @Test
  public void a2MasDiezLlamadasConcurrentesSinOperador() throws Exception {
    System.out.println("0 Operadores con 11 llamadas concurrentes todas son encoladas");

    final CallCenter callCenter = new CallCenter();
    callCenter.generarLlamadas(11, 0);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamadasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 11);

  }

  @Test
  public void a3DiezLlamadasConcurrentesConDiezOperadores() throws Exception {
    System.out.println("10 Operadores con 10 llamadas concurrentes todas son antendidas");

    final CallCenter callCenter = new CallCenter();
    callCenter.agregarEmpleados(10);
    callCenter.generarLlamadas(10, 0);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamadasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 0);
  }

  @Test
  public void a4MasDiezLlamadasConcurrentesConDiezOperadores() throws Exception {
    System.out.println("10 Operadores con 12 llamadas concurrentes, 2 son encoladas");

    final CallCenter callCenter = new CallCenter();
    callCenter.agregarEmpleados(10);
    callCenter.generarLlamadas(12, 0);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamadasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 2);
  }

}
