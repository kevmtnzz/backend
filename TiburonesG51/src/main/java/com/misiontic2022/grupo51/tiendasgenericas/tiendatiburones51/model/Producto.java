package com.misiontic2022.grupo51.tiendasgenericas.tiendatiburones51.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Productos")
public class Producto {
	
	private int codigoProducto;
	private String nombreProducto;
	private int nitProveedor;
	private Double precioCompra;
	private Double ivaCompra;
	private Double precioVenta;
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Double getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(Double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	

}
