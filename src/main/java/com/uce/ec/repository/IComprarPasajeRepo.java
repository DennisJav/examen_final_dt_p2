package com.uce.ec.repository;

import com.uce.ec.modelo.ComprarPasaje;

public interface IComprarPasajeRepo {

	void insertarCompra(ComprarPasaje comprarPasaje);
	void actualizaCompra(ComprarPasaje comprarPasaje);

}
