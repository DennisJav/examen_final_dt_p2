package com.uce.ec.repository;

import com.uce.ec.modelo.Cliente;

public interface IClienteRepo {

	void insertarCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	Cliente buscarCedula(String cedula);
}
