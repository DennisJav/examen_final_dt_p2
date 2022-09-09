package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.ec.modelo.Vuelo;

public interface IVueloRepo {

	void insertarVuelo(Vuelo vuelo);

	void actualizarVuelo(Vuelo vuelo);

	Vuelo buscarVueloNumero(String numeroVuelo);

	List<Vuelo> buscarVueloDisponible(String origen, String destino, LocalDateTime fecha);

}
