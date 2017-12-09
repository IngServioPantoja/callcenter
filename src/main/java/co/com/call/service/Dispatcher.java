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
      System.out.println("La llamada de " + llamada.getCliente() + " está siendo asignada");
      final EmpleadoDto usuario = UsuarioService.getInstance().buscarUsuarioDisponible();
      usuario.setLlamada(llamada);
      usuario.iniciarLlamada();
      LlamadaService.getInstance().aumentarLlamada();
    } else {
      final Integer posicion = LlamadaService.getInstance().encolarLlamada(llamada);
      System.out.println("Operadores ocupados la llamda fue encolada en la posicion " + posicion);
    }
  }

}
