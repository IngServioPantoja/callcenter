package co.com.call.service;

import java.io.Serializable;

import co.com.call.dto.LlamadaDto;
import co.com.call.dto.UsuarioDto;

public class Dispatcher implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Dispatcher instance;

	private Dispatcher() {
	}

	public static Dispatcher getInstance() {
		if (instance == null) {
			instance = new Dispatcher();
		}
		return instance;
	}

	public LlamadaDto dispatchCall(final LlamadaDto llamada) throws Exception {
		final Long cantidadLlamadas = LlamadaService.cantidadLlamadas();
		if (cantidadLlamadas < 10) {
			System.out.println("La llamada de " + llamada.getCliente() + " está siendo asignada");
			final UsuarioDto usuario = UsuarioService.buscarUsuarioDisponible();
			usuario.setLlamada(llamada);
			usuario.iniciarLlamada();
			LlamadaService.aumentarLlamada();
			return llamada;
		} else {
			System.out.println("La llamada no puede ser procesada, será encolada");
			return null;
		}
	}

}
