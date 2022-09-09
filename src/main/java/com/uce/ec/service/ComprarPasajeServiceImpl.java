package com.uce.ec.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.ComprarPasaje;
import com.uce.ec.repository.IComprarPasajeRepo;

@Service
public class ComprarPasajeServiceImpl implements IComprarPasajeService{

	@Autowired
	private IComprarPasajeRepo comprarPasajeRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarCompra(ComprarPasaje comprarPasaje) {
		// TODO Auto-generated method stub
		this.comprarPasajeRepo.insertarCompra(comprarPasaje);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizaCompra(ComprarPasaje comprarPasaje) {
		// TODO Auto-generated method stub
		this.comprarPasajeRepo.actualizaCompra(comprarPasaje);
	}



}
