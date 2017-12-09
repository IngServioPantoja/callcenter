package co.com.call.service;

import java.io.Serializable;
import co.com.call.dto.LlamadaDto;

/**
 * Consumer de la cola de llamadas
 * 
 * @author ServioAndres
 *
 */
public final class LlamadaQueueConsumer implements Serializable, Runnable {

  private static final long serialVersionUID = 1L;

  private static LlamadaQueueConsumer instance;

  private LlamadaQueueConsumer() {}

  public static LlamadaQueueConsumer getInstance() {
    synchronized (LlamadaQueueConsumer.class) {
      if (instance == null) {
        instance = new LlamadaQueueConsumer();
      }
    }
    return instance;
  }

  /**
   * Hilo encargado de verificar si hay llamadas encoladas y asignarlas a operadores
   */
  @Override
  public void run() {
    try {
      System.out.println("Consumidor de llamadas en cola activado");
      while (true) {
        Thread.sleep(1000);
        final Integer cantidadLlamadas = LlamadaService.getInstance().contarLlamadasEncoladas();
        if (cantidadLlamadas > 0) {
          final LlamadaDto llamada = LlamadaService.getInstance().obtenerLlamada();
          System.out.println("_______________________________________________________________________________________");
          System.out.println("Se ha obtenido la llamada encolada " + cantidadLlamadas + " del cliente " + llamada.getCliente());
          Dispatcher.getInstance().dispatchQueuedCall(llamada);
        }
      }
    } catch (final Exception e) {
      System.out.println("Error al consumir llamadas encoladas");
    }
  }

  /**
   * Activa el consumo de llamadas encoladas
   */
  public void escuchar() {
    new Thread(this).start();
  }

}
