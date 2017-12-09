package callcenter;

import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.Dispatcher;
import co.com.call.service.UsuarioService;

public class CallCenter {

  public CallCenter() {
    System.out.println("Call center inicializado");
  }

  public static void main(final String[] args) {

    try {

      agregarEmpleados();

      LlamadaDto llamada = new LlamadaDto("Servio");
      Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Andres");
      Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Corson");
      Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Camila");
      Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Melida");
      Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Mauricio");
      Dispatcher.getInstance().dispatchCall(llamada);

    } catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private static void agregarEmpleados() {

    final EmpleadoDto usuario = new EmpleadoDto("Alejandro", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuario);

    final EmpleadoDto usuarioCuatro = new EmpleadoDto("Moises", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioCuatro);

    final EmpleadoDto usuarioTres = new EmpleadoDto("Nidia", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioTres);

    final EmpleadoDto usuarioDos = new EmpleadoDto("Alberto", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioDos);
  }

}
