package co.com.call.enums;

import java.util.Random;

public enum TipoEmpleadoEnum {
  OPERADOR, SUPERVISOR, DIRECTOR;

  public static TipoEmpleadoEnum aleatorio() {
    final Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
