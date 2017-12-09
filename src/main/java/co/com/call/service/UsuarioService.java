package co.com.call.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import callcenter.EstadosEnum;
import co.com.call.dto.UsuarioDto;

public class UsuarioService {

  private static UsuarioService instance;

  private final List<UsuarioDto> lstUsuarios;

  private UsuarioService() {
    lstUsuarios = Collections.synchronizedList(new ArrayList<UsuarioDto>());
  }

  public static UsuarioService getInstance() {
    if (instance == null) {
      instance = new UsuarioService();
    }
    return instance;
  }

  public static UsuarioDto buscarUsuarioDisponible() throws Exception {
    UsuarioDto usuarioAsignar = null;
    for (final UsuarioDto usuarioDto : getInstance().lstUsuarios) {
      if (usuarioDto.getTipo().equals("OPERADOR")
          && usuarioDto.getStatus().equals(EstadosEnum.LIBRE)) {
        usuarioDto.setStatus(EstadosEnum.LLAMADA);
        usuarioAsignar = usuarioDto;
        break;
      }
    }
    if (usuarioAsignar == null) {
      for (final UsuarioDto usuarioDto : getInstance().lstUsuarios) {
        if (usuarioDto.getTipo().equals("SUPERVISOR")
            && usuarioDto.getStatus().equals(EstadosEnum.LIBRE)) {
          usuarioDto.setStatus(EstadosEnum.LLAMADA);
          usuarioAsignar = usuarioDto;
          break;
        }
      }
    }
    if (usuarioAsignar == null) {
      for (final UsuarioDto usuarioDto : getInstance().lstUsuarios) {
        if (usuarioDto.getTipo().equals("DIRECTOR")
            && usuarioDto.getStatus().equals(EstadosEnum.LIBRE)) {
          usuarioDto.setStatus(EstadosEnum.LLAMADA);
          usuarioAsignar = usuarioDto;
          break;
        }
      }
    }

    return usuarioAsignar;
  }

  public void agregarUsuario(final UsuarioDto usuario) {
    getInstance().lstUsuarios.add(usuario);
  }

  public static List<UsuarioDto> obtenerUsuarios() {
    final List<UsuarioDto> lstUsuarios = new ArrayList<UsuarioDto>(getInstance().lstUsuarios);
    return lstUsuarios;
  }

}
