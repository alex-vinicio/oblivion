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

import com.oblivion.backend.FincaCultivo;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.FincaCultivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FincaCultivoService {

	@Autowired
	FincaCultivoRepository repo;

	public List<FincaCultivo> getAll(){
		List<FincaCultivo> fincaCultivoList = repo.findAll();
		if(fincaCultivoList.size() > 0) {
			return fincaCultivoList;
		} else {
			return new ArrayList<FincaCultivo>();
		}
	}
     		
	public FincaCultivo findByIdFinca(Long idFinca) throws RecordNotFoundException{
		Optional<FincaCultivo> fincaCultivo = repo.findByIdFinca(idFinca);
		if(fincaCultivo.isPresent()) {
			return fincaCultivo.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public FincaCultivo createFincaCultivo(FincaCultivo fincaCultivo){
		return repo.save(fincaCultivo);
	}

	public FincaCultivo updateFincaCultivo(FincaCultivo fincaCultivo) throws RecordNotFoundException {
		Optional<FincaCultivo> fincaCultivoTemp = repo.findByIdFinca(fincaCultivo.getIdFinca());
	
		if(fincaCultivoTemp.isPresent()){
			return repo.save(fincaCultivo);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteFincaCultivoByIdFinca(Long idFinca) throws RecordNotFoundException{
		Optional<FincaCultivo> fincaCultivo = repo.findByIdFinca(idFinca);
		if(fincaCultivo.isPresent()) {
		repo.deleteByIdFinca(idFinca);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
