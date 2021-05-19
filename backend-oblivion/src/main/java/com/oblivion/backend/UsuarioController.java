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

import com.oblivion.backend.Usuario;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.UsuarioService;
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
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> list = service.getAll();
		return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioByCedulaUsuario(@PathVariable("id") Long cedulaUsuario) throws RecordNotFoundException {
		Usuario entity = service.findByCedulaUsuario(cedulaUsuario);
		return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/usuario/nurevo")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) throws RecordNotFoundException{
		service.createUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/usuario/modificar")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) throws RecordNotFoundException{
		service.updateUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/usuario/{id}")
	public HttpStatus deleteUsuarioByCedulaUsuario(@PathVariable("id") Long cedulaUsuario) throws RecordNotFoundException {
		service.deleteUsuarioByCedulaUsuario(cedulaUsuario);
		return HttpStatus.OK;
	}
}				
