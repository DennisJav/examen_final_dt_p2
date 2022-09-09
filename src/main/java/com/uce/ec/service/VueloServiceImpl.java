package com.uce.ec.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Vuelo;
import com.uce.ec.repository.IVueloRepo;

@Service
public class VueloServiceImpl implements IVueloService{

	@Autowired
	private IVueloRepo vueloRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.insertarVuelo(vuelo);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.actualizarVuelo(vuelo);
	}

	@Override
	public Vuelo buscarVueloNumero(String numeroVuelo) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVueloNumero(numeroVuelo);
	}

	@Override
	@Async
	public List<Vuelo> buscarVueloDisponible(String origen, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVueloDisponible(origen, destino, fecha);
	}
	
	

}
