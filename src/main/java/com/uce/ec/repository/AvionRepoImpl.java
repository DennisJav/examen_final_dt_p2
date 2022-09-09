package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Avion;

@Repository
@Transactional
public class AvionRepoImpl implements IAvionRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(avion);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Avion buscarNumeroAvion(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Avion> myQuery = this.entityManager.createQuery("SELECT a FROM Avion a WHERE a.numero=:valor",
				Avion.class);
		myQuery.setParameter("valor", numero);
		return myQuery.getSingleResult();
	}

}
