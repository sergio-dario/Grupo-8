package org.argentinaprograma.Stropeni.models;



public class Equipo {
	private String nombre;
	private String descripcion;
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	
	}
	public String getNombre() {
		return nombre;
	
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
}
}