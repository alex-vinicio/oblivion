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
import com.oblivion.backend.PropietarioService;
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
public class PropietarioController {
	@Autowired
	PropietarioService service;
	
	@GetMapping("/propietario")
	public ResponseEntity<List<Propietario>> getAll() {
		List<Propietario> list = service.getAll();
		return new ResponseEntity<List<Propietario>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/propietario/{id}")
	public ResponseEntity<Propietario> getPropietarioByCiPropietario(@PathVariable("id") String ciPropietario) throws RecordNotFoundException {
		Propietario entity = service.findByCiPropietario(ciPropietario);
		return new ResponseEntity<Propietario>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/propietario/nuevo")
	public ResponseEntity<Propietario> createPropietario(@RequestBody Propietario propietario) throws RecordNotFoundException{
		service.createPropietario(propietario);
		return new ResponseEntity<Propietario>(propietario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/propietario/modificar")
	public ResponseEntity<Propietario> updatePropietario(@RequestBody Propietario propietario) throws RecordNotFoundException{
		service.updatePropietario(propietario);
		return new ResponseEntity<Propietario>(propietario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/propietario/{id}")
	public HttpStatus deletePropietarioByCiPropietario(@PathVariable("id") String ciPropietario) throws RecordNotFoundException {
		service.deletePropietarioByCiPropietario(ciPropietario);
		return HttpStatus.OK;
	}
}				
