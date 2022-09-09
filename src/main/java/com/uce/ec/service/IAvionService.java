package com.uce.ec.service;

import com.uce.ec.modelo.Avion;

public interface IAvionService {
	void insertarAvion(Avion avion);
	void actualizarAvion(Avion avion);
	Avion buscarNumeroAvion(String numeroAvion);

}
