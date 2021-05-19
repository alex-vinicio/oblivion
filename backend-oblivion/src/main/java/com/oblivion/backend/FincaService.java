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

import com.oblivion.backend.Finca;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.FincaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FincaService {

	@Autowired
	FincaRepository repo;

	public List<Finca> getAll(){
		List<Finca> fincaList = repo.findAll();
		if(fincaList.size() > 0) {
			return fincaList;
		} else {
			return new ArrayList<Finca>();
		}
	}
     		
	public Finca findByIdFinca(Long idFinca) throws RecordNotFoundException{
		Optional<Finca> finca = repo.findByIdFinca(idFinca);
		if(finca.isPresent()) {
			return finca.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Finca createFinca(Finca finca){
		return repo.save(finca);
	}

	public Finca updateFinca(Finca finca) throws RecordNotFoundException {
		Optional<Finca> fincaTemp = repo.findByIdFinca(finca.getIdFinca());
	
		if(fincaTemp.isPresent()){
			return repo.save(finca);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteFincaByIdFinca(Long idFinca) throws RecordNotFoundException{
		Optional<Finca> finca = repo.findByIdFinca(idFinca);
		if(finca.isPresent()) {
		repo.deleteByIdFinca(idFinca);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
