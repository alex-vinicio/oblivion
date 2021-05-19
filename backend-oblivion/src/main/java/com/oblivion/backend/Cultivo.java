																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
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
@Table(name = "cultivo_table")
public class Cultivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCultivo;
	
	private String estadoCultivo;
	private String nombreCultivo;
	private String densidadSiembraCultivo;
	
	public Long getIdCultivo() {
		return idCultivo;
	}
	
	public void setIdCultivo(Long idCultivo) {
		this.idCultivo = idCultivo;
	}
	
	public String getEstadoCultivo() {
		return estadoCultivo;
	}
	
	public void setEstadoCultivo(String estadoCultivo) {
		this.estadoCultivo = estadoCultivo;
	}
	
	public String getNombreCultivo() {
		return nombreCultivo;
	}
	
	public void setNombreCultivo(String nombreCultivo) {
		this.nombreCultivo = nombreCultivo;
	}
	
	public String getDensidadSiembraCultivo() {
		return densidadSiembraCultivo;
	}
	
	public void setDensidadSiembraCultivo(String densidadSiembraCultivo) {
		this.densidadSiembraCultivo = densidadSiembraCultivo;
	}
	
}
