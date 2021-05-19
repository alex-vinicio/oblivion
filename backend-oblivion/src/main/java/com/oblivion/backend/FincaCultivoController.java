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
import com.oblivion.backend.FincaCultivoService;
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
public class FincaCultivoController {
	@Autowired
	FincaCultivoService service;
	
	@GetMapping("/fincaCultivo")
	public ResponseEntity<List<FincaCultivo>> getAll() {
		List<FincaCultivo> list = service.getAll();
		return new ResponseEntity<List<FincaCultivo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/fincaCultivo/{id}")
	public ResponseEntity<FincaCultivo> getFincaCultivoByIdFinca(@PathVariable("id") Long idFinca) throws RecordNotFoundException {
		FincaCultivo entity = service.findByIdFinca(idFinca);
		return new ResponseEntity<FincaCultivo>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/fincaCultivo")
	public ResponseEntity<FincaCultivo> createFincaCultivo(@RequestBody FincaCultivo fincaCultivo){
		service.createFincaCultivo(fincaCultivo);
		return new ResponseEntity<FincaCultivo>(fincaCultivo, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/fincaCultivo")
	public ResponseEntity<FincaCultivo> updateFincaCultivo(@RequestBody FincaCultivo fincaCultivo) throws RecordNotFoundException{
		service.updateFincaCultivo(fincaCultivo);
		return new ResponseEntity<FincaCultivo>(fincaCultivo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/fincaCultivo/{id}")
	public HttpStatus deleteFincaCultivoByIdFinca(@PathVariable("id") Long idFinca) throws RecordNotFoundException {
		service.deleteFincaCultivoByIdFinca(idFinca);
		return HttpStatus.OK;
	}
}				
