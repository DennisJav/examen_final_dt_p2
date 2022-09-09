package com.uce.ec.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepoImpl implements IVueloRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarVueloNumero(String numeroVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero=:valor",
				Vuelo.class);
		myQuery.setParameter("valor", numeroVuelo);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVueloDisponible(String origen, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub

		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v WHERE v.origen=:valor1 AND v.destino=:valor2 AND v.fechaVuelo >=:valor3", Vuelo.class);
		myQuery.setParameter("valor1", origen).setParameter("valor2", destino).setParameter("valor3", fecha);

		return myQuery.getResultList();
	}

}
