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

  @Test
  public void diezLlamadasConcurrentes() throws Exception {

    LlamadaDto llamada = new LlamadaDto("Andres");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Corson");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Camila");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Melida");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Mauricio");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Camilo");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Anastasia");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Nidia");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Consuelo");
    Dispatcher.getInstance().dispatchCall(llamada);

  }

  @Test
  public void masDiezLlamadasConcurrentes() {



  }

}
