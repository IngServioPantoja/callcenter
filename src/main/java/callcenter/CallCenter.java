package callcenter;

import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;
import co.com.call.enums.NombresEnum;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.Dispatcher;
import co.com.call.service.EmpleadoService;
import co.com.call.service.LlamadaQueueConsumer;

public class CallCenter {

  public CallCenter() {
    LlamadaQueueConsumer.getInstance().escuchar();
  }

  public static void main(final String[] args) {
    try {
      final CallCenter callCenter = new CallCenter();
      callCenter.agregarEmpleados(1);
      callCenter.generarLlamadas(10, 1);
    } catch (final Exception e) {
      System.out.println("Excepcion al montar call center");
    }
  }

  public void generarLlamadas(final Integer cantidad, final Integer segundos) throws Exception {
    Integer contador = 1;
    while (contador <= cantidad) {
      Thread.sleep(segundos * 1000L);
      System.out.println("_______________________________________________________________________________________");
      final LlamadaDto llamada = new LlamadaDto(NombresEnum.aleatorio().toString());
      Dispatcher.getInstance().dispatchCall(llamada);
      contador++;
    }

  }

  public void agregarEmpleados(final Integer cantidad) {
    Integer contador = 1;
    while (contador <= cantidad) {
      final String nombre = NombresEnum.aleatorio().toString();
      final TipoEmpleadoEnum tipoEmpleado = TipoEmpleadoEnum.aleatorio();
      final EmpleadoDto usuario = new EmpleadoDto(nombre, tipoEmpleado);
      EmpleadoService.getInstance().agregarEmpleado(usuario);
      contador++;
    }
  }

}
