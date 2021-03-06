																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G?mez (2020)
| File Date: Wed May 19 13:39:30 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.oblivion.backend;

import com.oblivion.backend.Rol;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.RolService;
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
public class RolController {
	@Autowired
	RolService service;
	
	@GetMapping("/rol")
	public ResponseEntity<List<Rol>> getAll() {
		List<Rol> list = service.getAll();
		return new ResponseEntity<List<Rol>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/rol/{id}")
	public ResponseEntity<Rol> getRolByIdRol(@PathVariable("id") Long idRol) throws RecordNotFoundException {
		Rol entity = service.findByIdRol(idRol);
		return new ResponseEntity<Rol>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/rol")
	public ResponseEntity<Rol> createRol(@RequestBody Rol rol){
		service.createRol(rol);
		return new ResponseEntity<Rol>(rol, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/rol")
	public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) throws RecordNotFoundException{
		service.updateRol(rol);
		return new ResponseEntity<Rol>(rol, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/rol/{id}")
	public HttpStatus deleteRolByIdRol(@PathVariable("id") Long idRol) throws RecordNotFoundException {
		service.deleteRolByIdRol(idRol);
		return HttpStatus.OK;
	}
}				
