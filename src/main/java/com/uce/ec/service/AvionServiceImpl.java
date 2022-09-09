package com.uce.ec.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Avion;
import com.uce.ec.repository.IAvionRepo;

@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepo avionRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarAvion(Avion avion) {
		// TODO Auto-generated method stub
		
		this.avionRepo.insertarAvion(avion);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepo.actualizarAvion(avion);
	}

	@Override
	public Avion buscarNumeroAvion(String numero) {
		// TODO Auto-generated method stub
		return this.avionRepo. buscarNumeroAvion(numero);
	}

}
