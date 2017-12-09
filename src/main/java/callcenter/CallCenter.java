package callcenter;

import java.util.Date;
import co.com.call.dto.LlamadaDto;
import co.com.call.dto.UsuarioDto;
import co.com.call.service.Dispatcher;
import co.com.call.service.UsuarioService;

public class CallCenter {

  public static void main(final String[] args) {

    final UsuarioDto usuario = new UsuarioDto(new Date().getTime());
    usuario.setUsuario("Alejandro");
    usuario.setTipo("OPERADOR");
    usuario.start();
    UsuarioService.getInstance().agregarUsuario(usuario);

    final UsuarioDto usuarioCuatro = new UsuarioDto(new Date().getTime());
    usuarioCuatro.setUsuario("Moises");
    usuarioCuatro.setTipo("OPERADOR");
    usuarioCuatro.start();
    UsuarioService.getInstance().agregarUsuario(usuarioCuatro);

    final UsuarioDto usuarioTres = new UsuarioDto(new Date().getTime());
    usuarioTres.setUsuario("Nidia");
    usuarioTres.setTipo("SUPERVISOR");
    usuarioTres.start();
    UsuarioService.getInstance().agregarUsuario(usuarioTres);

    final UsuarioDto usuarioDos = new UsuarioDto(new Date().getTime());
    usuarioDos.setUsuario("Alberto");
    usuarioDos.setTipo("DIRECTOR");
    usuarioDos.start();
    UsuarioService.getInstance().agregarUsuario(usuarioDos);

    try {
      LlamadaDto llamada = new LlamadaDto("Servio");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Andres");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Corson");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Camila");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Melida");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

      llamada = new LlamadaDto("Mauricio");
      llamada = Dispatcher.getInstance().dispatchCall(llamada);

    } catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
