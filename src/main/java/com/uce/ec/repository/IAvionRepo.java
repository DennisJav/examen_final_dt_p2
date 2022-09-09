package com.uce.ec.repository;

import com.uce.ec.modelo.Avion;

public interface IAvionRepo {

	void insertarAvion(Avion avion);
	void actualizarAvion(Avion avion);
	Avion buscarNumeroAvion(String numeroAvion);
	
}
