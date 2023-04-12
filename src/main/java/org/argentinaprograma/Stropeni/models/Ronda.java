package org.argentinaprograma.Stropeni.models;

import java.util.List;



import java.util.ArrayList;

public class Ronda {
	
	private String nro;
	private List<Ronda>partidos;
	
	
	public  Ronda(String nro) {
		this.setNro(nro);
	this.partidos = new ArrayList<Ronda>();
	
}

public void agregarRondadePartidos(Ronda ronda) {
	this.partidos.add(ronda);	
}
	
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public List<Ronda> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Ronda> partidos) {
		this.partidos = partidos;
	}
	
	public static  int PuntosxRonda() {
		       int PuntosxRonda = 0;
					PuntosxRonda = 1;
						return PuntosxRonda;
				
	}

	public static int PuntosExtrasxRonda() {
		int PuntosExtrasxRonda = 0;		
		     PuntosExtrasxRonda = 5;
		return PuntosExtrasxRonda;
	}

	public static int PuntosExtrasxFase() {
		int PuntosExtrasxFase = 0;
		     PuntosExtrasxFase = 10;
		return PuntosExtrasxFase;
	}

	}

	
	
	


