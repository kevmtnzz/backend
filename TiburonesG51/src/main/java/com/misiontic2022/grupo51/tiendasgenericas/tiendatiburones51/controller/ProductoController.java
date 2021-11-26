package com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model.Producto;
import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.repository.ProductoRepository;




@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoRepository ProductoRepository;
	
	@GetMapping(value="/")
    public String index() {

        return "This is Home page";
    }
	
	@GetMapping("/Productos")
	public ResponseEntity<List<Producto>> getAllProductos(@RequestParam(required = false) String username) {
		try {
			List<Producto> productos = new ArrayList<Producto>();

			if (username == null) {
				ProductoRepository.findAll().forEach(productos::add);
			} else {
				//ProductoRepository.findByUsername(username).forEach(productos::add);
			}

			if (productos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
/*	@GetMapping("/productos/{id}")
	  public ResponseEntity<Producto> getProductoById(@PathVariable("id") String id) {
	    Optional<Producto> productoData = ProductoRepository.findById(id);

	    if (productoData.isPresent()) {
	      return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/

	@PostMapping("/products")
	  public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
	    try {
	      Producto _producto = ProductoRepository.save(producto); 
	      return new ResponseEntity<>(_producto, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	 
/*	  @PutMapping("/productos/{id}")
	  public ResponseEntity<Producto> updateProducto(@PathVariable("id") String id, @RequestBody Producto user) {
	    Optional<Producto> productoData = ProductoRepository.findById(id);

	    if (productoData.isPresent()) {
	      Producto _producto = productoData.get();
	      _producto.setUsername(user.getUsername());
	      _producto.setPassword(user.getPassword());
	      return new ResponseEntity<>(ProductoRepository.save(_producto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/

/*	  @DeleteMapping("/productos/{id}")
	  public ResponseEntity<HttpStatus> deleteProductos(@PathVariable("id") String id) {
	    try {
	      ProductoRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/

/*	  @DeleteMapping("/productos")
	  public ResponseEntity<HttpStatus> deleteAllProductos() {
	    try {
	      ProductoRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/productos/{username}")
	  public ResponseEntity<List<Producto>> findByUsername(@PathVariable("username") String username) {
	    try {
	      List<Producto> productos = ProductoRepository.findByUsername(username);

	      if (productos.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(productos, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/

}

