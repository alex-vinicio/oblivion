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
import com.oblivion.backend.MonitoreoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/api/oblivion")
public class MonitoreoController {
	@Autowired
	MonitoreoService service;
	
	@GetMapping("/monitoreo")
	public ResponseEntity<List<Monitoreo>> getAll() {
		List<Monitoreo> list = service.getAll();
		return new ResponseEntity<List<Monitoreo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/monitoreo/{id}")
	public ResponseEntity<Monitoreo> getMonitoreoByIdMonitoreo(@PathVariable("id") Long idMonitoreo) throws RecordNotFoundException {
		Monitoreo entity = service.findByIdMonitoreo(idMonitoreo);
		return new ResponseEntity<Monitoreo>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/monitoreo")
	public ResponseEntity<Monitoreo> createMonitoreo(@RequestBody Monitoreo monitoreo){
		service.createMonitoreo(monitoreo);
		return new ResponseEntity<Monitoreo>(monitoreo, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/monitoreo")
	public ResponseEntity<Monitoreo> updateMonitoreo(@RequestBody Monitoreo monitoreo) throws RecordNotFoundException{
		service.updateMonitoreo(monitoreo);
		return new ResponseEntity<Monitoreo>(monitoreo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/monitoreo/{id}")
	public HttpStatus deleteMonitoreoByIdMonitoreo(@PathVariable("id") Long idMonitoreo) throws RecordNotFoundException {
		service.deleteMonitoreoByIdMonitoreo(idMonitoreo);
		return HttpStatus.OK;
	}
}				
