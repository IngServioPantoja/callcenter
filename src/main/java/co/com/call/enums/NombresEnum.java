package co.com.call.enums;

import java.util.Random;

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

  public static NombresEnum aleatorio() {
    final Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
