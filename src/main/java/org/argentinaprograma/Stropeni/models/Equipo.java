package org.argentinaprograma.Stropeni.models;



public class Equipo {
	private String nombre;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private String descripcion;
	
	
	
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