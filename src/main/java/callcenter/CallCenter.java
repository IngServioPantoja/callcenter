package callcenter;

import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;
import co.com.call.enums.NombresEnum;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.Dispatcher;
import co.com.call.service.EmpleadoService;
import co.com.call.service.LlamadaQueueConsumer;

/**
 * Administra el cal center e inicializa las dependencias necesarias
 * 
 * @author ServioAndres
 *
 */
public class CallCenter {

  public CallCenter() {
    LlamadaQueueConsumer.getInstance().escuchar();
  }

  public static void main(final String[] args) {
    try {
      final CallCenter callCenter = new CallCenter();
      callCenter.agregarEmpleados(5);
      callCenter.generarLlamadas(15, 1);
    } catch (final Exception e) {
      System.out.println("Excepcion al montar call center");
    }
  }

  /**
   * Genera llamadas
   * 
   * @param cantidad Numero de llamadas a generar
   * @param segundos Tiempo en segundos entre cada llamada generada
   * @throws Exception
   */
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

  /**
   * Genera empleados para el call center
   * 
   * @param cantidad Numero de empleados a generar
   */
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
