package com.misiontic2022.grupo51.tiendasgenericas.lagenrica51.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.lagenerica.lagenerica51.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByNombre_Completo(String nombre);
	

}
