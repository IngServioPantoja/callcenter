package co.com.call.enums;

import java.util.Random;

/**
 * Nombres para empleados y clientes
 * 
 * @author ServioAndres
 *
 */
public enum NombresEnum {
  LUIS, 
  ANTONIO, 
  NIDIA, 
  CONSUELO, 
  MARY, 
  DEBHORA, 
  MARIA, 
  CECILIA, 
  ELENA, 
  FRANCIA, 
  CAMILA, 
  DANIEL, 
  ANDRES, 
  SERVIO, 
  CHRISTIAN, 
  JOSUE, 
  SAMUEL, 
  BLANCA, 
  DORA, 
  DOLLY, 
  AMANDA, 
  ROSAURA,
  ALVARO,
  MAURICIO,
  MANUEL,
  DINNO,
  PAULO,
  FRANCY,
  NAZLY,
  NANCY,
  ALEJANDRA,
  KATHERINE;
  
  /**
   * Busca un nombre de forma aleatoria
   * @return NombresEnum
   */
  public static NombresEnum aleatorio() {
    final Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
