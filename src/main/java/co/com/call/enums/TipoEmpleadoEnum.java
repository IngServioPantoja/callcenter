package co.com.call.enums;

import java.util.Random;

/**
 * Define los tipos de empleado existentes
 * 
 * @author ServioAndres
 *
 */
public enum TipoEmpleadoEnum {
  OPERADOR, SUPERVISOR, DIRECTOR;

  /**
   * Retorna un tipo de empleado de forma aleatoria
   * 
   * @return TipoEmpleadoEnum
   */
  public static TipoEmpleadoEnum aleatorio() {
    final Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
