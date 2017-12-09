package co.com.call.dto;

import callcenter.EstadosEnum;
import co.com.call.service.LlamadaService;

public class UsuarioDto implements Runnable {
  // ------------------------------ FIELDS ------------------------------

  private Long id;

  private boolean running;

  private boolean llamadaActiva;

  private EstadosEnum status;

  private String tipo;

  private String usuario;

  private LlamadaDto llamada;

  // --------------------------- CONSTRUCTORS ---------------------------

  public UsuarioDto(final Long id) {
    this.id = id;
    status = EstadosEnum.LIBRE;
    tipo = "ESCLAVO";
    llamadaActiva = false;
  }

  @Override
  public void run() {
    while (running) {
      try {
        Thread.sleep(5000L);
        if (llamadaActiva) {
          final long tiempo = 1000 * llamada.getDuracion();
          System.out.println("Llamada en curso con duración " + tiempo + " con "
              + llamada.getCliente() + " atendido por " + tipo + " " + usuario);
          Thread.sleep(tiempo);
          LlamadaService.disminuirLlamada();
          llamadaActiva = false;
          setStatus(EstadosEnum.LIBRE);
          System.out.println("Llamada terminada con duración " + tiempo + " con "
              + llamada.getCliente() + " atendido por " + tipo + " " + usuario);
        }
      } catch (final InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  // -------------------------- OTHER METHODS --------------------------

  public void start() {
    running = true;
    new Thread(this).start();
  }

  public void iniciarLlamada() {
    llamadaActiva = true;
  }

  public void stop() {
    running = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(final String tipo) {
    this.tipo = tipo;
  }

  public EstadosEnum getStatus() {
    return status;
  }

  public void setStatus(final EstadosEnum status) {
    this.status = status;
  }

  public LlamadaDto getLlamada() {
    return llamada;
  }

  public void setLlamada(final LlamadaDto llamada) {
    this.llamada = llamada;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(final String usuario) {
    this.usuario = usuario;
  }

}
