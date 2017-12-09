package co.com.call.service;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import co.com.call.dto.LlamadaDto;

public class LlamadaService implements Serializable {

  private static final long serialVersionUID = 1L;

  private static LlamadaService instance;

  private final LinkedBlockingQueue<LlamadaDto> lstLlamadas;
  private Long cantidadLlamadas;

  private LlamadaService() {
    lstLlamadas = new LinkedBlockingQueue<LlamadaDto>();
    cantidadLlamadas = 0L;
  }

  public static LlamadaService getInstance() {

    if (instance == null) {
      instance = new LlamadaService();
    }
    return instance;
  }

  public static void aumentarLlamada() {
    getInstance().cantidadLlamadas = getInstance().cantidadLlamadas + 1;
  }

  public static void disminuirLlamada() {
    getInstance().cantidadLlamadas = getInstance().cantidadLlamadas - 1;
  }

  public static Long cantidadLlamadas() {
    return getInstance().cantidadLlamadas;
  }

}
