package co.com.call.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import co.com.call.dto.EmpleadoDto;
import co.com.call.enums.EstadosEnum;
import co.com.call.enums.TipoEmpleadoEnum;

public class EmpleadoService {

  private static EmpleadoService instance;

  private List<EmpleadoDto> lstEmpleados;

  private EmpleadoService() {
    lstEmpleados = Collections.synchronizedList(new ArrayList<EmpleadoDto>());
  }

  public static EmpleadoService getInstance() {
    if (instance == null) {
      instance = new EmpleadoService();
    }
    return instance;
  }

  public EmpleadoDto buscarUsuarioDisponible() throws Exception {
    EmpleadoDto usuarioAsignar = null;
    for (final EmpleadoDto usuarioDto : lstEmpleados) {
      if (usuarioDto.getTipo().equals(TipoEmpleadoEnum.OPERADOR)
          && usuarioDto.getEstado().equals(EstadosEnum.LIBRE)) {
        usuarioDto.setEstado(EstadosEnum.LLAMADA);
        usuarioAsignar = usuarioDto;
        break;
      }
    }
    if (usuarioAsignar == null) {
      for (final EmpleadoDto usuarioDto : lstEmpleados) {
        if (usuarioDto.getTipo().equals(TipoEmpleadoEnum.SUPERVISOR)
            && usuarioDto.getEstado().equals(EstadosEnum.LIBRE)) {
          usuarioDto.setEstado(EstadosEnum.LLAMADA);
          usuarioAsignar = usuarioDto;
          break;
        }
      }
    }
    if (usuarioAsignar == null) {
      for (final EmpleadoDto usuarioDto : lstEmpleados) {
        if (usuarioDto.getTipo().equals(TipoEmpleadoEnum.DIRECTOR)
            && usuarioDto.getEstado().equals(EstadosEnum.LIBRE)) {
          usuarioDto.setEstado(EstadosEnum.LLAMADA);
          usuarioAsignar = usuarioDto;
          break;
        }
      }
    }

    return usuarioAsignar;
  }

  public void agregarEmpleado(final EmpleadoDto usuario) {
    usuario.conectar();
    lstEmpleados.add(usuario);
  }

  public List<EmpleadoDto> obtenerEmpleados() {
    return new ArrayList<EmpleadoDto>(lstEmpleados);
  }

  public void desconectarEmpleados() {
    for (final EmpleadoDto empleadoDto : lstEmpleados) {
      empleadoDto.stop();
    }
    lstEmpleados = new ArrayList<EmpleadoDto>();
  }

}
