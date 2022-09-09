package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.ComprarPasaje;

@Repository
@Transactional
public class ComprarPasajeRepoImpl implements IComprarPasajeRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarCompra(ComprarPasaje comprarPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.persist(comprarPasaje);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizaCompra(ComprarPasaje comprarPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.merge(comprarPasaje);
	}



}
