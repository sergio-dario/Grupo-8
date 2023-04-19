package org.argentinaprograma.Stropeni.models;

import java.util.List;



import java.util.ArrayList;

public class Ronda {
	
	private String nroFase;
	private String nroRonda;
	private List<Ronda>partidos;
	
	
	public Ronda(String nroFase,String nroRonda) {
		this.nroFase= nroFase;
		this.nroRonda= nroRonda;
			this.partidos = new ArrayList<Ronda>();
      }

     public void agregarRondadePartidos(Ronda ronda) {
         	this.partidos.add(ronda);	
        }

       public String getNroFase() {
		return nroFase;
	}

	public void setNroFase(String nroFase) {
		this.nroFase = nroFase;
	}

	public String getNroRonda() {
		return nroRonda;
	}

	public void setNroRonda(String nroRonda) {
		this.nroRonda = nroRonda;
	}

	public List<Ronda> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Ronda> partidos) {
		this.partidos = partidos;
	}
	
	// tamaño de la fase elegida
	
	public  int fase() {
		
		int x=0;
		for(Ronda fase : this.getPartidos()) {
		
			x= +Integer.parseInt(fase.nroFase);
		}
	return  x;
		
	
		}}
	



	
	
	


