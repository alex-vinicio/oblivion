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

import com.oblivion.backend.Propietario;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.PropietarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {

	@Autowired
	PropietarioRepository repo;

	@Autowired
	ValidarCedula ciValdiar;

	public List<Propietario> getAll(){
		List<Propietario> propietarioList = repo.findAll();
		if(propietarioList.size() > 0) {
			return propietarioList;
		} else {
			return new ArrayList<Propietario>();
		}
	}
     		
	public Propietario findByCiPropietario(Long ciPropietario) throws RecordNotFoundException{
		Optional<Propietario> propietario = repo.findByCiPropietario(ciPropietario);
		if(propietario.isPresent()) {
			return propietario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Propietario createPropietario(Propietario propietario) throws RecordNotFoundException{
		if(ciValdiar.ingresoDataCedula(propietario.getCelularPropietario()) == true){
			return repo.save(propietario);
		}else{
			throw new RecordNotFoundException("Numero de cedula incorrecta!"); 
		}
		
	}

	public Propietario updatePropietario(Propietario propietario) throws RecordNotFoundException {
		Optional<Propietario> propietarioTemp = repo.findByCiPropietario(propietario.getCiPropietario());
	
		if(propietarioTemp.isPresent()){
			return repo.save(propietario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletePropietarioByCiPropietario(Long ciPropietario) throws RecordNotFoundException{
		Optional<Propietario> propietario = repo.findByCiPropietario(ciPropietario);
		if(propietario.isPresent()) {
		repo.deleteByCiPropietario(ciPropietario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
