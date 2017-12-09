package callcenter;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import co.com.call.dto.EmpleadoDto;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.UsuarioService;

public class EmpleadoTest {

  @Test
  public void agregarEmpleado() {
    final EmpleadoDto usuario = new EmpleadoDto("Alejandro", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(usuario);
  }

  @Test
  public void contarEmpleados() {
    UsuarioService.getInstance().obtenerEmpleados();
  }

  @Test
  public void crearYContarEmpleados() {
    List<EmpleadoDto> lstUsuario = UsuarioService.getInstance().obtenerEmpleados();
    final int cantiadInicial = lstUsuario.size();
    System.out.println("Cantidad inicial de usuarios " + cantiadInicial);

    final EmpleadoDto empleado = new EmpleadoDto("Alejandro", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(empleado);

    lstUsuario = UsuarioService.getInstance().obtenerEmpleados();
    final int cantidadFinal = lstUsuario.size();

    System.out.println("Cantidad final de usuarios " + cantidadFinal);
    assertEquals(cantiadInicial + 1, cantidadFinal);
  }

  @Test
  public void verificarPrioridadAsignacion() throws Exception {

    final EmpleadoDto operador = new EmpleadoDto("Maria", TipoEmpleadoEnum.OPERADOR);
    UsuarioService.getInstance().agregarEmpleado(operador);
    final EmpleadoDto director = new EmpleadoDto("Alejandra", TipoEmpleadoEnum.DIRECTOR);
    UsuarioService.getInstance().agregarEmpleado(director);
    final EmpleadoDto supervisor = new EmpleadoDto("Miguel", TipoEmpleadoEnum.SUPERVISOR);
    UsuarioService.getInstance().agregarEmpleado(supervisor);

    final EmpleadoDto disponible = UsuarioService.getInstance().buscarUsuarioDisponible();
    System.out.println("Tipo disponible " + disponible.getTipo());
    assertEquals(disponible.getTipo(), TipoEmpleadoEnum.OPERADOR);
  }

}
