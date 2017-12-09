package callcenter;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import co.com.call.dto.EmpleadoDto;
import co.com.call.dto.LlamadaDto;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.Dispatcher;
import co.com.call.service.LlamadaService;
import co.com.call.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegracionTest {

  @Test
  public void a1DiezLlamadasConcurrentesSinOperadores() throws Exception {
    System.out.println("0 Operadores con 10 llamadas concurrentes todas son encoladas");

    LlamadaDto llamada = new LlamadaDto("Andres");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Mauricio");
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

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamdasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 10);
    LlamadaService.getInstance().limpiarLlamadasEncoladas();
  }

  @Test
  public void a2MasDiezLlamadasConcurrentesSinOperador() throws Exception {
    System.out.println("0 Operadores con 11 llamadas concurrentes todas son encoladas");

    LlamadaDto llamada = new LlamadaDto("Andres");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Mauricio");
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

    llamada = new LlamadaDto("Francia");
    Dispatcher.getInstance().dispatchCall(llamada);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamdasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 11);

    LlamadaService.getInstance().limpiarLlamadasEncoladas();

  }

  @Test
  public void a3DiezLlamadasConcurrentesConDiezOperadores() throws Exception {
    System.out.println("10 Operadores con 10 llamadas concurrentes todas son antendidas");

    final EmpleadoDto usuario = new EmpleadoDto("Alejandro", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuario);

    final EmpleadoDto usuarioCuatro = new EmpleadoDto("Moises", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioCuatro);

    final EmpleadoDto usuarioTres = new EmpleadoDto("Nidia", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioTres);

    final EmpleadoDto alberto = new EmpleadoDto("Alberto", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(alberto);

    final EmpleadoDto mario = new EmpleadoDto("Mario", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(mario);

    final EmpleadoDto juan = new EmpleadoDto("Juan", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(juan);

    final EmpleadoDto david = new EmpleadoDto("David", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(david);

    final EmpleadoDto marcos = new EmpleadoDto("Marcos", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(marcos);

    final EmpleadoDto alfonso = new EmpleadoDto("Alfonso", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(alfonso);

    final EmpleadoDto christian = new EmpleadoDto("Christian", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(christian);

    LlamadaDto llamada = new LlamadaDto("Andres");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Mauricio");
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

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamdasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 0);

    LlamadaService.getInstance().limpiarLlamadasEncoladas();
    LlamadaService.getInstance().limpiarLlamadasConcurrentes();
  }

  @Test
  public void a4MasDiezLlamadasConcurrentesConDiezOperadores() throws Exception {
    System.out.println("10 Operadores con 12 llamadas concurrentes, 2 son encoladas");

    final EmpleadoDto alejandro = new EmpleadoDto("Alejandro", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(alejandro);

    final EmpleadoDto usuarioCuatro = new EmpleadoDto("Moises", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioCuatro);

    final EmpleadoDto usuarioTres = new EmpleadoDto("Nidia", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(usuarioTres);

    final EmpleadoDto alberto = new EmpleadoDto("Alberto", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(alberto);

    final EmpleadoDto mario = new EmpleadoDto("Mario", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(mario);

    final EmpleadoDto juan = new EmpleadoDto("Juan", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(juan);

    final EmpleadoDto david = new EmpleadoDto("David", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(david);

    final EmpleadoDto marcos = new EmpleadoDto("Marcos", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(marcos);

    final EmpleadoDto alfonso = new EmpleadoDto("Alfonso", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(alfonso);

    final EmpleadoDto christian = new EmpleadoDto("Christian", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(christian);

    LlamadaDto llamada = new LlamadaDto("Andres");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Mauricio");
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

    llamada = new LlamadaDto("Martina");
    Dispatcher.getInstance().dispatchCall(llamada);

    llamada = new LlamadaDto("Alejandra");
    Dispatcher.getInstance().dispatchCall(llamada);

    final Integer llamadasEncoladas = LlamadaService.getInstance().contarLlamdasEncoladas();
    System.out.println("Cantida de llamadas encoladas " + llamadasEncoladas);

    assertEquals(llamadasEncoladas.intValue(), 2);

    LlamadaService.getInstance().limpiarLlamadasEncoladas();
    LlamadaService.getInstance().limpiarLlamadasConcurrentes();
  }



}
