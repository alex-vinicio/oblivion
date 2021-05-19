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

import com.oblivion.backend.Usuario;
import com.oblivion.backend.RecordNotFoundException;
import com.oblivion.backend.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;

	public List<Usuario> getAll(){
		List<Usuario> usuarioList = repo.findAll();
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<Usuario>();
		}
	}
     		
	public Usuario findByCedulaUsuario(Long cedulaUsuario) throws RecordNotFoundException{
		Optional<Usuario> usuario = repo.findByCedulaUsuario(cedulaUsuario);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Usuario createUsuario(Usuario usuario){
		return repo.save(usuario);
	}

	public Usuario updateUsuario(Usuario usuario) throws RecordNotFoundException {
		Optional<Usuario> usuarioTemp = repo.findByCedulaUsuario(usuario.getCedulaUsuario());
	
		if(usuarioTemp.isPresent()){
			return repo.save(usuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteUsuarioByCedulaUsuario(Long cedulaUsuario) throws RecordNotFoundException{
		Optional<Usuario> usuario = repo.findByCedulaUsuario(cedulaUsuario);
		if(usuario.isPresent()) {
		repo.deleteByCedulaUsuario(cedulaUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
