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
import com.oblivion.backend.FincaService;
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
public class FincaController {
	@Autowired
	FincaService service;
	
	@GetMapping("/finca")
	public ResponseEntity<List<Finca>> getAll() {
		List<Finca> list = service.getAll();
		return new ResponseEntity<List<Finca>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/finca/{id}")
	public ResponseEntity<Finca> getFincaByIdFinca(@PathVariable("id") Long idFinca) throws RecordNotFoundException {
		Finca entity = service.findByIdFinca(idFinca);
		return new ResponseEntity<Finca>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/finca")
	public ResponseEntity<Finca> createFinca(@RequestBody Finca finca){
		service.createFinca(finca);
		return new ResponseEntity<Finca>(finca, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/finca")
	public ResponseEntity<Finca> updateFinca(@RequestBody Finca finca) throws RecordNotFoundException{
		service.updateFinca(finca);
		return new ResponseEntity<Finca>(finca, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/finca/{id}")
	public HttpStatus deleteFincaByIdFinca(@PathVariable("id") Long idFinca) throws RecordNotFoundException {
		service.deleteFincaByIdFinca(idFinca);
		return HttpStatus.OK;
	}
}				
