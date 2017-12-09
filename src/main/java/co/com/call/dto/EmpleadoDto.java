package co.com.call.dto;

import java.util.Date;
import co.com.call.enums.EstadosEnum;
import co.com.call.enums.TipoEmpleadoEnum;
import co.com.call.service.LlamadaService;

public class EmpleadoDto implements Runnable {

  private Long id;

  private boolean conectado;

  private boolean llamadaActiva;

  private EstadosEnum estado;

  private TipoEmpleadoEnum tipo;

  private String nombre;

  private LlamadaDto llamada;

  public EmpleadoDto(final String nombre, final TipoEmpleadoEnum tipo) {
    id = new Date().getTime();
    estado = EstadosEnum.LIBRE;
    this.tipo = tipo;
    this.nombre = nombre;
    llamadaActiva = false;
    conectado = true;
  }

  @Override
  public void run() {
    while (conectado) {
      try {
        if (llamadaActiva) {
          final long tiempo = 1000 * llamada.getDuracion();
          System.out
              .println("Llamada en curso con duración " + tiempo + " con " + llamada.getCliente() + " atendido por " + tipo + " " + nombre);
          Thread.sleep(tiempo);
          System.out.println(
              "Llamada terminada con duración " + tiempo + " con " + llamada.getCliente() + " atendido por " + tipo + " " + nombre);
          LlamadaService.getInstance().disminuirLlamada();
          llamadaActiva = false;
          estado = EstadosEnum.LIBRE;
        }
        Thread.sleep(1000L);
      } catch (final InterruptedException e) {
        System.out.println("Error al generar empleado");
      }
    }
  }


  public void iniciarLlamada() {
    llamadaActiva = true;
  }

  public void stop() {
    conectado = false;
  }

  public void conectar() {
    new Thread(this).start();
    System.out.println("Empleado " + tipo + " " + nombre + " ha ingresado en el sistema de atencion ");
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public TipoEmpleadoEnum getTipo() {
    return tipo;
  }

  public void setTipo(final TipoEmpleadoEnum tipo) {
    this.tipo = tipo;
  }

  public EstadosEnum getEstado() {
    return estado;
  }

  public void setEstado(final EstadosEnum estado) {
    this.estado = estado;
  }

  public LlamadaDto getLlamada() {
    return llamada;
  }

  public void setLlamada(final LlamadaDto llamada) {
    this.llamada = llamada;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(final String usuario) {
    nombre = usuario;
  }

}
