package com.uce.ec.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VueloTO {

	private String numeroVuelo;
	private String origen;
	private String  destino;
	private BigDecimal valorAsiento;
	private Integer cantidadAsiento;
	private Integer cantidadAsientoDisponibles;
	private Integer cantidadAsientoOcupados;
	private String fechaVuelo;
	private String cedula;
	private String estado;
	private String nombreAvion;
	
	
	public VueloTO() {
		
	}
	
	
	public VueloTO(String numeroVuelo, String origen, String destino, BigDecimal valorAsiento, Integer cantidadAsiento,
			Integer cantidadAsientoDisponibles, Integer cantidadAsientoOcupados, String fechaVuelo, String cedula,
			String estado, String nombreAvion) {
		super();
		this.numeroVuelo = numeroVuelo;
		this.origen = origen;
		this.destino = destino;
		this.valorAsiento = valorAsiento;
		this.cantidadAsiento = cantidadAsiento;
		this.cantidadAsientoDisponibles = cantidadAsientoDisponibles;
		this.cantidadAsientoOcupados = cantidadAsientoOcupados;
		this.fechaVuelo = fechaVuelo;
		this.cedula = cedula;
		this.estado = estado;
		this.nombreAvion = nombreAvion;
	}
	
	
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}
	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}
	public Integer getCantidadAsiento() {
		return cantidadAsiento;
	}
	public void setCantidadAsiento(Integer cantidadAsiento) {
		this.cantidadAsiento = cantidadAsiento;
	}
	public Integer getCantidadAsientoDisponibles() {
		return cantidadAsientoDisponibles;
	}
	public void setCantidadAsientoDisponibles(Integer cantidadAsientoDisponibles) {
		this.cantidadAsientoDisponibles = cantidadAsientoDisponibles;
	}
	public Integer getCantidadAsientoOcupados() {
		return cantidadAsientoOcupados;
	}
	public void setCantidadAsientoOcupados(Integer cantidadAsientoOcupados) {
		this.cantidadAsientoOcupados = cantidadAsientoOcupados;
	}
	public String getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreAvion() {
		return nombreAvion;
	}
	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}


	
	
	
	
}
