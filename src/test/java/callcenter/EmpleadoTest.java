package callcenter;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import co.com.call.dto.EmpleadoDto;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.EmpleadoService;
import co.com.call.service.LlamadaService;

/**
 * Clase encargada de los test unitarios relacionados con empleados
 * 
 * @author ServioAndres
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpleadoTest {

  /**
   * Realiza la limpieza de colar, empleados y contadores despues de cada test
   */
  @After
  public void limpiarDependencias() {
    LlamadaService.getInstance().limpiarLlamadasEncoladas();
    LlamadaService.getInstance().limpiarLlamadasConcurrentes();
    EmpleadoService.getInstance().desconectarEmpleados();
  }

  /**
   * Prueba la creación de un empleado
   */
  @Test
  public void a1agregarEmpleado() {
    final CallCenter callCenter = new CallCenter();
    callCenter.agregarEmpleados(1);
  }

  /**
   * Prueba el conteo de empleados
   */
  @Test
  public void a2contarEmpleados() {
    EmpleadoService.getInstance().obtenerEmpleados();
  }

  /**
   * Crea un empleado y valida que el numero de empleados sea aumentado en 1
   */
  @Test
  public void a3crearYContarEmpleados() {
    List<EmpleadoDto> lstUsuario = EmpleadoService.getInstance().obtenerEmpleados();
    final int cantiadInicial = lstUsuario.size();
    System.out.println("Cantidad inicial de usuarios " + cantiadInicial);

    final CallCenter callCenter = new CallCenter();
    callCenter.agregarEmpleados(1);

    lstUsuario = EmpleadoService.getInstance().obtenerEmpleados();
    final int cantidadFinal = lstUsuario.size();

    System.out.println("Cantidad final de usuarios " + cantidadFinal);
    assertEquals(cantiadInicial + 1, cantidadFinal);
  }

  /**
   * Valida si el primer tipo de empleado asignado es operador
   */
  @Test
  public void a4verificarPrioridadAsignacion() {

    final CallCenter callCenter = new CallCenter();
    callCenter.agregarEmpleados(5);

    final EmpleadoDto disponible = EmpleadoService.getInstance().buscarUsuarioDisponible();
    System.out.println("Tipo disponible " + disponible.getTipo());
    assertEquals(disponible.getTipo(), TipoEmpleadoEnum.OPERADOR);
  }

}
