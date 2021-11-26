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

import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model.Cliente;
import com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.repository.ClienteRepository;




@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	ClienteRepository ClienteRepository;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClientes(@RequestParam(required = false) String user) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			if (user == null) {
				ClienteRepository.findAll().forEach(clientes::add);
			} else {
				ClienteRepository.findByUser(user).forEach(clientes::add);
			}

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	 @GetMapping("/clientes/{id}")
	  public ResponseEntity<Cliente> getClienteById(@PathVariable("id") String id) {
	    Optional<Cliente> clienteData = ClienteRepository.findById(id);

	    if (clienteData.isPresent()) {
	      return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/clientes")
	  public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
	    try {
	      Cliente _cliente = ClienteRepository.save(cliente);
	      return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  
	  @PutMapping("/clientes/{id}")
	  public ResponseEntity<Cliente> updateCliente(@PathVariable("id") String id, @RequestBody Cliente cliente) {
	    Optional<Cliente> clienteData = ClienteRepository.findById(id);

	    if (clienteData.isPresent()) {
	      Cliente _cliente = clienteData.get();
	      _cliente.setCedula(cliente.getCedula());
	      _cliente.setNombreCompleto(cliente.getNombreCompleto());
	      _cliente.setDireccion(cliente.getDireccion());
	      _cliente.setTelefono(cliente.getTelefono());
	      _cliente.setEmail(cliente.getEmail());
	      return new ResponseEntity<>(ClienteRepository.save(_cliente), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/clientes/{id}")
	  public ResponseEntity<HttpStatus> deleteClientes(@PathVariable("id") String id) {
	    try {
	      ClienteRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/clientes")
	  public ResponseEntity<HttpStatus> deleteAllClientes() {
	    try {
	      ClienteRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/clientes/{username}")
	  public ResponseEntity<List<Cliente>> findByUsername(@PathVariable("cliente") String cliente) {
	    try {
	      List<Cliente> clientes = ClienteRepository.findByUser(cliente);

	      if (clientes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(clientes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}

