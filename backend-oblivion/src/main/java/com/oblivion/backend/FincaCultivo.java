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
@Table(name = "Finca_Cultivo")
public class FincaCultivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinca;
	
	private Long idCultivo;
	
	public Long getIdFinca() {
		return idFinca;
	}
	
	public void setIdFinca(Long idFinca) {
		this.idFinca = idFinca;
	}
	
	public Long getIdCultivo() {
		return idCultivo;
	}
	
	public void setIdCultivo(Long idCultivo) {
		this.idCultivo = idCultivo;
	}
	
}
