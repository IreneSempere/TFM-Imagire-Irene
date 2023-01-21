package com.ireneokami.productos;

import java.util.Date;

public class Producto {
	
	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private float precioOferta;
	private int stock;
	private String tipoProducto;
	private Date fecha;
	private String pathImg;
	
	
	
	public Producto() {
		
	}
	
	public Producto(int id, String nombre, String descripcion, float precio, float precioOferta, int stock,
			String tipoProducto, Date fecha, String pathImg) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.stock = stock;
		this.tipoProducto = tipoProducto;
		this.fecha = fecha;
		this.pathImg = pathImg;
	}
	public Producto(String nombre, String descripcion, float precio, float precioOferta, int stock,
			String tipoProducto, String pathImg) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.stock = stock;
		this.tipoProducto = tipoProducto;
		this.pathImg = pathImg;
	}


	
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", precioOferta=" + precioOferta + ", stock=" + stock + ", tipoProducto=" + tipoProducto + ", fecha="
				+ fecha + ", pathImg=" + pathImg + "]";
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(float precioOferta) {
		this.precioOferta = precioOferta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	
	

	
}
