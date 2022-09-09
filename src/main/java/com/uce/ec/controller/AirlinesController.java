package com.uce.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.ec.modelo.VueloTO;
import com.uce.ec.service.IGestorAirlines;

@Controller
@RequestMapping("/vuelos")
public class AirlinesController {

	@Autowired
	private IGestorAirlines gestorAirlines;
	
	
	@GetMapping("/vuelosDisponibles")
	public String vistaDisponibles(VueloTO vuelo, Model modelo) {
		modelo.addAttribute("vuelo",new VueloTO());	
		return "vuelosDisponibles";
	}
	
	@GetMapping("/listaDisponibles")
	public String listaDisponibles(VueloTO vuelo, Model modelo) {
		List<VueloTO> vueloLista = this.gestorAirlines.buscarVuelosDisponibles(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaVuelo());
		modelo.addAttribute("vueloLista",vueloLista);	
		return "vuelosLista";
	}
	
	
	@GetMapping("/buscarVuelos")
	public String vistaIngresoDatosVuelos(VueloTO vuelo, Model modelo) {
		modelo.addAttribute("vuelo",new VueloTO());	
		return "vistaBuscar";
	}
	
	
	
	@GetMapping("/confirmarAsientos")
	public String vistaReserva(VueloTO vuelo, Model modelo) {
		modelo.addAttribute("vuelo",vuelo);	
		return "vistaReserva"; 
	}
	
	
	@PostMapping("/reservar")
	public String realizarReserva(VueloTO vuelo, Model modelo) {
		
		this.gestorAirlines.reservarPasajes(vuelo.getNumeroVuelo(), vuelo.getCantidadAsiento(),vuelo.getCedula());
		
		
		return "redirect:/vuelos/buscarVuelos?exito";
	}
	
	

	
	
}
