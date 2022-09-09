package com.uce.ec.service;

import com.uce.ec.modelo.Cliente;

public interface IClienteService {
	void insertarCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	Cliente buscarCedula(String cedula);
}
