package co.com.call.service;

import java.io.Serializable;
import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;

public class Dispatcher implements Serializable {

  private static final long serialVersionUID = 1L;

  private static Dispatcher instance;

  private Dispatcher() {}

  public static Dispatcher getInstance() {
    if (instance == null) {
      instance = new Dispatcher();
    }
    return instance;
  }

  public void dispatchCall(final LlamadaDto llamada) throws Exception {
    final Long cantidadLlamadas = LlamadaService.getInstance().cantidadLlamadas();
    if (cantidadLlamadas < 10) {
      final EmpleadoDto empleado = EmpleadoService.getInstance().buscarUsuarioDisponible();
      if (empleado != null) {
        empleado.setLlamada(llamada);
        empleado.iniciarLlamada();
        LlamadaService.getInstance().aumentarLlamada();
        System.out.println("La llamada fue correctamente asignada cliente " + llamada.getCliente() + " empleado " + empleado.getNombre());
      } else {
        final Integer posicion = LlamadaService.getInstance().encolarLlamada(llamada);
        System.out.println("Operadores no disponibles la llamada de " + llamada.getCliente() + " fue encolada en la posicion " + posicion);
      }
    } else {
      final Integer posicion = LlamadaService.getInstance().encolarLlamada(llamada);
      System.out.println("Operadores ocupados la llamada de " + llamada.getCliente() + " fue encolada en la posicion " + posicion);
    }
  }

  public void dispatchQueuedCall(final LlamadaDto llamada) throws Exception {
    boolean asignada = false;
    final Long cantidadLlamadas = LlamadaService.getInstance().cantidadLlamadas();
    while (!asignada) {
      if (cantidadLlamadas < 10) {
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
