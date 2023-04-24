package org.argentinaprograma.Stropeni.models;


public class Ronda {

   private Integer Fase;
    private Integer Ronda;
    private Equipo equipo1;
    private Equipo equipo2;
    
    public Ronda(Equipo equipo1, Equipo equipo2,Integer Ronda, Integer Fase) {
    	this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.Ronda = Ronda;
    	this.Fase = Fase;
    }
	
	public Integer getFase() {
		return Fase;
	}

	public void setFase(Integer fase) {
		Fase = fase;
	}

	public Integer getRonda() {
		return Ronda;
	}


	public void setRonda(Integer ronda) {
		Ronda = ronda;
	}



	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}



	public Equipo getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

   
}
			
