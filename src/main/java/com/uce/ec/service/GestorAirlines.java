package com.uce.ec.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Cliente;
import com.uce.ec.modelo.ComprarPasaje;
import com.uce.ec.modelo.Vuelo;
import com.uce.ec.modelo.VueloTO;
import com.uce.ec.repository.IVueloRepo;

@Service
public class GestorAirlines implements IGestorAirlines{

	@Autowired
	private IVueloRepo vueloRepo;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IComprarPasajeService comprarPasajeService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void reservarPasajes(String numeroVuelo, Integer asientosCompra, String cedula) {
		// TODO Auto-generated method stub
		
		ComprarPasaje compra = new ComprarPasaje();
		Cliente cliente = this.clienteService.buscarCedula(cedula);
		Vuelo vuelo = this.vueloRepo.buscarVueloNumero(numeroVuelo);
				
		//DateTimeFormatter form = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
		//String fecha = vuelo.getFechaVuelo().format(form);
		
		//List<VueloTO> v =this.buscarVuelosDisponibles(vuelo.getOrigen(), vuelo.getDestino(), fecha);
		
		if(vuelo.getEstado().equals("DIS")) {
			if(vuelo.getAsientesDisponibles() < asientosCompra) {
				throw new RuntimeException("No hay cantidad de asientos");
			}else {
				compra.setCliente(cliente);
				compra.setVuelo(vuelo);
				compra.setEstado("RES");
				compra.setFechaCompra(LocalDateTime.now());
				compra.setNumeroTarjeta(cedula);
				compra.setCantidadAsientosComprados(asientosCompra);
				compra.setNumero(numeroVuelo.concat(cliente.getCedula()));
				vuelo.setAsientesDisponibles(vuelo.getAsientesDisponibles() - asientosCompra);
				vuelo.setAsientosOcupados(vuelo.getAsientosOcupados() + asientosCompra);
				if(vuelo.getAsientesDisponibles() == 0) {
					vuelo.setEstado("ND");
				}
				this.vueloRepo.actualizarVuelo(vuelo);
				this.comprarPasajeService.insertarCompra(compra);
			}
		}else {
			throw new RuntimeException("No Disponibles");
		}
		
			
	}


	@Override
	public List<VueloTO> buscarVuelosDisponibles(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaVuelo = LocalDate.parse(fecha,formato);
		LocalDateTime fechaConvertida = LocalDateTime.of(fechaVuelo, LocalDateTime.MIN.toLocalTime());
		
		List<Vuelo> vuelos = this.vueloRepo.buscarVueloDisponible(origen, destino, fechaConvertida);
		
		List<Vuelo> vuelosDisponibles = vuelos.parallelStream().filter(v -> v.getEstado().equals("DIS")).collect(Collectors.toList());
		
		
		List<VueloTO> vueloEncontrado = vuelosDisponibles.stream().map(v -> {
			VueloTO vueloTO = new VueloTO();
			
			vueloTO.setNumeroVuelo(v.getNumero());
			vueloTO.setCantidadAsiento(v.getAvion().getCapacidadAsientos());
			vueloTO.setCantidadAsientoDisponibles(v.getAsientesDisponibles());
			vueloTO.setCantidadAsientoOcupados(v.getAsientosOcupados());
			vueloTO.setDestino(v.getDestino());
			vueloTO.setOrigen(v.getOrigen());
			vueloTO.setValorAsiento(v.getValorAsiento());
			vueloTO.setEstado(v.getEstado());
			
			return vueloTO;
			
		}).collect(Collectors.toList());
		
		return vueloEncontrado;
	}
	
	
	
	

}
