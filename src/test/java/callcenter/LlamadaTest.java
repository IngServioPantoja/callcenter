package callcenter;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import co.com.call.service.EmpleadoService;
import co.com.call.service.LlamadaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LlamadaTest {

  @After
  public void limpiarDependencias() {
    LlamadaService.getInstance().limpiarLlamadasEncoladas();
    LlamadaService.getInstance().limpiarLlamadasConcurrentes();
    EmpleadoService.getInstance().desconectarEmpleados();
  }

  @Test
  public void a1agregarLlamada() throws Exception {
    final CallCenter callCenter = new CallCenter();
    callCenter.generarLlamadas(1, 0);
  }

}
