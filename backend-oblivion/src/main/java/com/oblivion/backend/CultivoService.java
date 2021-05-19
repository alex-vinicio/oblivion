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

import com.oblivion.backend.Cultivo;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.CultivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CultivoService {

	@Autowired
	CultivoRepository repo;

	public List<Cultivo> getAll(){
		List<Cultivo> cultivoList = repo.findAll();
		if(cultivoList.size() > 0) {
			return cultivoList;
		} else {
			return new ArrayList<Cultivo>();
		}
	}
     		
	public Cultivo findByIdCultivo(Long idCultivo) throws RecordNotFoundException{
		Optional<Cultivo> cultivo = repo.findByIdCultivo(idCultivo);
		if(cultivo.isPresent()) {
			return cultivo.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Cultivo createCultivo(Cultivo cultivo){
		return repo.save(cultivo);
	}

	public Cultivo updateCultivo(Cultivo cultivo) throws RecordNotFoundException {
		Optional<Cultivo> cultivoTemp = repo.findByIdCultivo(cultivo.getIdCultivo());
	
		if(cultivoTemp.isPresent()){
			return repo.save(cultivo);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteCultivoByIdCultivo(Long idCultivo) throws RecordNotFoundException{
		Optional<Cultivo> cultivo = repo.findByIdCultivo(idCultivo);
		if(cultivo.isPresent()) {
		repo.deleteByIdCultivo(idCultivo);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
