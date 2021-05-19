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

import com.oblivion.backend.Monitoreo;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.MonitoreoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoreoService {

	@Autowired
	MonitoreoRepository repo;

	public List<Monitoreo> getAll(){
		List<Monitoreo> monitoreoList = repo.findAll();
		if(monitoreoList.size() > 0) {
			return monitoreoList;
		} else {
			return new ArrayList<Monitoreo>();
		}
	}
     		
	public Monitoreo findByIdMonitoreo(Long idMonitoreo) throws RecordNotFoundException{
		Optional<Monitoreo> monitoreo = repo.findByIdMonitoreo(idMonitoreo);
		if(monitoreo.isPresent()) {
			return monitoreo.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Monitoreo createMonitoreo(Monitoreo monitoreo){
		return repo.save(monitoreo);
	}

	public Monitoreo updateMonitoreo(Monitoreo monitoreo) throws RecordNotFoundException {
		Optional<Monitoreo> monitoreoTemp = repo.findByIdMonitoreo(monitoreo.getIdMonitoreo());
	
		if(monitoreoTemp.isPresent()){
			return repo.save(monitoreo);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteMonitoreoByIdMonitoreo(Long idMonitoreo) throws RecordNotFoundException{
		Optional<Monitoreo> monitoreo = repo.findByIdMonitoreo(idMonitoreo);
		if(monitoreo.isPresent()) {
		repo.deleteByIdMonitoreo(idMonitoreo);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
