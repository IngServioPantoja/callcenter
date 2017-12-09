package co.com.call.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import co.com.call.dto.EmpleadoDto;
import co.com.call.enums.EstadosEnum;
import co.com.call.enums.TipoEmpleadoEnum;

/**
 * Servicio encargado de gestionar agregar, buscar disponibles, contar
 * 
 * @author ServioAndres
 *
 */
public final class EmpleadoService {

  private static EmpleadoService instance;

  /**
   * Listado de empleados del callcenter, es una lista sincronizada
   */
  private List<EmpleadoDto> lstEmpleados;

  private EmpleadoService() {
    lstEmpleados = Collections.synchronizedList(new ArrayList<EmpleadoDto>());
  }

  public static EmpleadoService getInstance() {
    synchronized (EmpleadoService.class) {
      if (instance == null) {
        instance = new EmpleadoService();
      }
    }
    return instance;
  }

  /**
   * Busca un empleado disponible segun el orden operador superisor, director
   * 
   * @return EmpleadoDto
   */
  public EmpleadoDto buscarUsuarioDisponible() {
    EmpleadoDto empleadoAsignar = null;
    empleadoAsignar = buscarOperador();
    if (empleadoAsignar == null) {
      empleadoAsignar = buscarSupervisor();
    }
    if (empleadoAsignar == null) {
      empleadoAsignar = buscarDirector();
    }
    return empleadoAsignar;
  }

  private EmpleadoDto buscarDirector() {
    EmpleadoDto empleadoAsignar = null;
    for (final EmpleadoDto usuarioDto : lstEmpleados) {
      if (usuarioDto.getTipo().equals(TipoEmpleadoEnum.DIRECTOR) && usuarioDto.getEstado().equals(EstadosEnum.LIBRE)) {
        usuarioDto.setEstado(EstadosEnum.LLAMADA);
        empleadoAsignar = usuarioDto;
        break;
      }
    }
    return empleadoAsignar;
  }

  private EmpleadoDto buscarSupervisor() {
    EmpleadoDto empleadoAsignar = null;
    for (final EmpleadoDto empleadoDto : lstEmpleados) {
      if (empleadoDto.getTipo().equals(TipoEmpleadoEnum.SUPERVISOR) && empleadoDto.getEstado().equals(EstadosEnum.LIBRE)) {
        empleadoDto.setEstado(EstadosEnum.LLAMADA);
        empleadoAsignar = empleadoDto;
        break;
      }
    }
    return empleadoAsignar;
  }

  private EmpleadoDto buscarOperador() {
    EmpleadoDto empleadoAsignar = null;
    for (final EmpleadoDto empleadoDto : lstEmpleados) {
      if (empleadoDto.getTipo().equals(TipoEmpleadoEnum.OPERADOR) && empleadoDto.getEstado().equals(EstadosEnum.LIBRE)) {
        empleadoDto.setEstado(EstadosEnum.LLAMADA);
        empleadoAsignar = empleadoDto;
        break;
      }
    }
    return empleadoAsignar;
  }

  /**
   * Agrega un empleado al callcenter y lo conecta al sistema de llamadas
   * 
   * @param usuario
   */
  public void agregarEmpleado(final EmpleadoDto usuario) {
    usuario.conectar();
    lstEmpleados.add(usuario);
  }

  /**
   * Retorna la lista de empleadoss
   * 
   * @return
   */
  public List<EmpleadoDto> obtenerEmpleados() {
    return new ArrayList<EmpleadoDto>(lstEmpleados);
  }

  /**
   * Desconecta a todos los empleados del call center
   */
  public void desconectarEmpleados() {
    for (final EmpleadoDto empleadoDto : lstEmpleados) {
      empleadoDto.stop();
    }
    lstEmpleados = new ArrayList<EmpleadoDto>();
  }

}
