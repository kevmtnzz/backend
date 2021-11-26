package com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String>{
	
	//List<Producto> findByUsername(String username);
	
	//List<Producto> findByNombrecompleto(String nombrecompleto);
	

}
