package org.argentinaprograma.Stropeni.models;

public class Puntaje {
	private int PuntosxPartido;
	private int PuntosxRonda;
    private int PuntosxFase;
    
    public Puntaje(int PuntosxPartido, int PuntosxRonda, int PuntosxFase) {
    	
		this.PuntosxPartido = PuntosxPartido;
		this.PuntosxRonda = PuntosxRonda;
		this.PuntosxFase = PuntosxFase;
		
}

	public int getPuntosxPartido() {
		return PuntosxPartido;
	}

	public void setPuntosxPartido(int puntosxPartido) {
		PuntosxPartido = puntosxPartido;
	}

	public int getPuntosxRonda() {
		
		return PuntosxRonda;
	}

	public void setPuntosxRonda(int puntosxRonda) {
		PuntosxRonda = puntosxRonda;
	}

	public int getPuntosxFase() {
		return PuntosxFase;
	}

	public void setPuntosxFase(int puntosxFase) {
		PuntosxFase = puntosxFase;
	}

}
