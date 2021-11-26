package com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clientes")
public class Cliente {
	
	@Id
	private String id;
	
	private int cedula;
	private String nombreCompleto;
	private String direccion;
	private int telefono;
	private String email;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int cedula, String nombrecompleto, String direccion, int telefono, String email) {
		super();
		this.cedula = cedula;
		this.nombreCompleto = nombrecompleto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
	

