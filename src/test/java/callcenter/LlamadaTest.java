package callcenter;

import org.junit.Test;
import co.com.call.dto.LlamadaDto;
import co.com.call.service.Dispatcher;

public class LlamadaTest {

  @Test
  public void agregarLlamada() throws Exception {
    final LlamadaDto llamada = new LlamadaDto("Servio");
    Dispatcher.getInstance().dispatchCall(llamada);
  }

}
