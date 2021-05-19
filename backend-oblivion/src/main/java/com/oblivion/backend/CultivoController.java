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
import com.oblivion.backend.CultivoService;
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
public class CultivoController {
	@Autowired
	CultivoService service;
	
	@GetMapping("/cultivo")
	public ResponseEntity<List<Cultivo>> getAll() {
		List<Cultivo> list = service.getAll();
		return new ResponseEntity<List<Cultivo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/cultivo/{id}")
	public ResponseEntity<Cultivo> getCultivoByIdCultivo(@PathVariable("id") Long idCultivo) throws RecordNotFoundException {
		Cultivo entity = service.findByIdCultivo(idCultivo);
		return new ResponseEntity<Cultivo>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/cultivo")
	public ResponseEntity<Cultivo> createCultivo(@RequestBody Cultivo cultivo){
		service.createCultivo(cultivo);
		return new ResponseEntity<Cultivo>(cultivo, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/cultivo")
	public ResponseEntity<Cultivo> updateCultivo(@RequestBody Cultivo cultivo) throws RecordNotFoundException{
		service.updateCultivo(cultivo);
		return new ResponseEntity<Cultivo>(cultivo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/cultivo/{id}")
	public HttpStatus deleteCultivoByIdCultivo(@PathVariable("id") Long idCultivo) throws RecordNotFoundException {
		service.deleteCultivoByIdCultivo(idCultivo);
		return HttpStatus.OK;
	}
}				
