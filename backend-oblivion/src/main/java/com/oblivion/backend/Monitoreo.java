																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G�mez (2020)
| File Date: Wed May 19 13:39:30 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.oblivion.backend;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "monitoreo_table")
public class Monitoreo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMonitoreo;
	
	private Long idCultivo;
	private Long arbol;
	private Long fruto;
	private Long incidencia;
	private Long severidad;
	private String fechaMonitoreo;
	
	public Long getIdMonitoreo() {
		return idMonitoreo;
	}
	
	public void setIdMonitoreo(Long idMonitoreo) {
		this.idMonitoreo = idMonitoreo;
	}
	
	public Long getIdCultivo() {
		return idCultivo;
	}
	
	public void setIdCultivo(Long idCultivo) {
		this.idCultivo = idCultivo;
	}
	
	public Long getArbol() {
		return arbol;
	}
	
	public void setArbol(Long arbol) {
		this.arbol = arbol;
	}
	
	public Long getFruto() {
		return fruto;
	}
	
	public void setFruto(Long fruto) {
		this.fruto = fruto;
	}
	
	public Long getIncidencia() {
		return incidencia;
	}
	
	public void setIncidencia(Long incidencia) {
		this.incidencia = incidencia;
	}
	
	public Long getSeveridad() {
		return severidad;
	}
	
	public void setSeveridad(Long severidad) {
		this.severidad = severidad;
	}
	
	public String getFechaMonitoreo() {
		return fechaMonitoreo;
	}
	
	public void setFechaMonitoreo(String fechaMonitoreo) {
		this.fechaMonitoreo = fechaMonitoreo;
	}
	
}
