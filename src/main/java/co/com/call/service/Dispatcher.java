package co.com.call.service;

import java.io.Serializable;
import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;

/**
 * Servicio encargado de recepcionar y asignar empleados a una llamada
 * 
 * @author ServioAndres
 *
 */
public final class Dispatcher implements Serializable {

  private static final int MAX_LLAMADAS_CONCURRENT = 10;

  private static final long serialVersionUID = 1L;

  private static Dispatcher instance;

  private Dispatcher() {}

  public static Dispatcher getInstance() {
    synchronized (Dispatcher.class) {
      if (instance == null) {
        instance = new Dispatcher();
      }
    }
    return instance;
  }

  /**
   * Encargado de recepcionar una llamada y asignar un empleado
   * 
   * @param llamada
   * @throws Exception
   */
  public void dispatchCall(final LlamadaDto llamada) throws Exception {
    final Long cantidadLlamadas = LlamadaService.getInstance().getCantidadLlamadas();
    if (cantidadLlamadas < MAX_LLAMADAS_CONCURRENT) {
      final EmpleadoDto empleado = EmpleadoService.getInstance().buscarUsuarioDisponible();
      if (empleado == null) {
        final Integer posicion = LlamadaService.getInstance().encolarLlamada(llamada);
        System.out.println("Operadores no disponibles la llamada de " + llamada.getCliente() + " fue encolada en la posicion " + posicion);
      } else {
        empleado.setLlamada(llamada);
        empleado.iniciarLlamada();
        LlamadaService.getInstance().aumentarLlamada();
        System.out.println("La llamada fue correctamente asignada cliente " + llamada.getCliente() + " empleado " + empleado.getNombre());
      }
    } else {
      final Integer posicion = LlamadaService.getInstance().encolarLlamada(llamada);
      System.out.println("Operadores ocupados la llamada de " + llamada.getCliente() + " fue encolada en la posicion " + posicion);
    }
  }

  /**
   * Encargado de recepcionar una llamada encolada y asignar un empleado
   * 
   * @param llamada
   * @throws Exception
   */
  public void dispatchQueuedCall(final LlamadaDto llamada) throws Exception {
    boolean asignada = false;
    final Long cantidadLlamadas = LlamadaService.getInstance().getCantidadLlamadas();
    while (!asignada) {
      if (cantidadLlamadas < MAX_LLAMADAS_CONCURRENT) {
        final EmpleadoDto empleado = EmpleadoService.getInstance().buscarUsuarioDisponible();
        if (empleado != null) {
          empleado.setLlamada(llamada);
          empleado.iniciarLlamada();
          LlamadaService.getInstance().aumentarLlamada();
          System.out.println(
              "La llamada encolada fue correctamente asignada cliente " + llamada.getCliente() + " empleado " + empleado.getNombre());
          asignada = true;
        }
      }
    }
  }

}
