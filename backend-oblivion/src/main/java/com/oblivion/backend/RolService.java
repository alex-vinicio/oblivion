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

import com.oblivion.backend.Rol;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

	@Autowired
	RolRepository repo;

	public List<Rol> getAll(){
		List<Rol> rolList = repo.findAll();
		if(rolList.size() > 0) {
			return rolList;
		} else {
			return new ArrayList<Rol>();
		}
	}
     		
	public Rol findByIdRol(Long idRol) throws RecordNotFoundException{
		Optional<Rol> rol = repo.findByIdRol(idRol);
		if(rol.isPresent()) {
			return rol.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Rol createRol(Rol rol){
		return repo.save(rol);
	}

	public Rol updateRol(Rol rol) throws RecordNotFoundException {
		Optional<Rol> rolTemp = repo.findByIdRol(rol.getIdRol());
	
		if(rolTemp.isPresent()){
			return repo.save(rol);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteRolByIdRol(Long idRol) throws RecordNotFoundException{
		Optional<Rol> rol = repo.findByIdRol(idRol);
		if(rol.isPresent()) {
		repo.deleteByIdRol(idRol);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
