package com.uce.ec.service;

import java.util.List;

import com.uce.ec.modelo.VueloTO;

public interface IGestorAirlines {

	void reservarPasajes(String numeroVuelo, Integer asientosCompra, String cedula);
	List<VueloTO>  buscarVuelosDisponibles(String origen, String destino, String fecha);
}
