package co.com.call.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class LlamadaDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long duracion;
  private String cliente;

  public LlamadaDto(final String cliente) {
    this.cliente = cliente;
    duracion = (long) ThreadLocalRandom.current().nextInt(5, 10 + 1);
    System.out.println("Nueva llamda " + cliente + " duración de la llamada: " + duracion + "s");
  }

  public Long getDuracion() {
    return duracion;
  }

  public void setDuracion(final Long duracion) {
    this.duracion = duracion;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(final String cliente) {
    this.cliente = cliente;
  }

}
