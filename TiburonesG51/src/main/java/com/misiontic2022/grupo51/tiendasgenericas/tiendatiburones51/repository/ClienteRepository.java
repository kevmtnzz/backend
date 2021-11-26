package com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
	
	List<Cliente> findByUser(String user);
	
	List<Cliente> findByNombrecompleto(String nombrecompleto);
	

}