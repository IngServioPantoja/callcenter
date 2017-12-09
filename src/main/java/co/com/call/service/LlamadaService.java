package co.com.call.service;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import co.com.call.dto.LlamadaDto;

/**
 * Servicio encargado del manejo de llamadas, contadores y colas de llamadas
 * 
 * @author ServioAndres
 *
 */
public final class LlamadaService implements Serializable {

  private static final long serialVersionUID = 1L;

  private static LlamadaService instance;

  /**
   * Cola de llamadas
   */
  private LinkedBlockingQueue<LlamadaDto> lstLlamadas;
  /**
   * Contador de llamadas concurrentes
   */
  private Long cantidadLlamadas;

  private LlamadaService() {
    lstLlamadas = new LinkedBlockingQueue<LlamadaDto>();
    cantidadLlamadas = 0L;
  }

  public static LlamadaService getInstance() {
    synchronized (LlamadaService.class) {
      if (instance == null) {
        instance = new LlamadaService();
      }
    }
    return instance;
  }

  /**
   * Aumenta el contador de las llamadas concurrentes
   */
  public void aumentarLlamada() {
    synchronized (this) {
      cantidadLlamadas = cantidadLlamadas + 1;
    }
  }

  /**
   * Dismuniye el contador de llamadas concurrentes
   */
  public void disminuirLlamada() {
    synchronized (this) {
      cantidadLlamadas = cantidadLlamadas - 1;
    }
  }

  /**
   * Retorna la cantidad de llamadas concurrentes
   * 
   * @return Cantidad de llamadas concurrentes
   */
  public Long getCantidadLlamadas() {
    return cantidadLlamadas;
  }

  /**
   * Encola una llamada en la cola de llamadas
   * 
   * @param llamada con la informacion del cliente y tiempo
   * @return Lugar en la cola de llamadas
   * @throws InterruptedException
   */
  public Integer encolarLlamada(final LlamadaDto llamada) throws InterruptedException {
    lstLlamadas.put(llamada);
    return lstLlamadas.size();
  }

  /**
   * Cuenta la cantidad de llamadas en cola
   * 
   * @return Cantidad llamadas en cola
   */
  public Integer contarLlamadasEncoladas() {
    return lstLlamadas.size();
  }

  /**
   * Limpia las colas de llamadas
   */
  public void limpiarLlamadasEncoladas() {
    lstLlamadas = new LinkedBlockingQueue<LlamadaDto>();
  };

  /**
   * Reinicia los contadores de llamadas concurrentes
   */
  public void limpiarLlamadasConcurrentes() {
    cantidadLlamadas = 0L;
  };

  /**
   * Saca la primera llamada en la cola fifo
   * 
   * @return Llamada encola del tipo fifo
   */
  public LlamadaDto obtenerLlamada() {
    return lstLlamadas.poll();
  }

}
