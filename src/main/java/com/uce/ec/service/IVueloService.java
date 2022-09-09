package com.uce.ec.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Vuelo;

public interface IVueloService {
	void insertarVuelo(Vuelo vuelo);
	void actualizarVuelo(Vuelo vuelo);
	Vuelo buscarVueloNumero(String numeroVuelo);
	List<Vuelo> buscarVueloDisponible(String origen, String destino, LocalDateTime fecha);
}
