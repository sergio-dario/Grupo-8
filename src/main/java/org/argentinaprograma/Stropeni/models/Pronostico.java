package org.argentinaprograma.Stropeni.models;



public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private EnumResultado resultado;
    private String participante;
   
    
	public Pronostico(Partido partido, Equipo equipo, EnumResultado resultado, String participante) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
		this.participante = participante;

	}





	public Partido getPartido() {
		return this.partido;
	}



	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

		

	public EnumResultado getResultado() {
		return resultado;
	}

	public void setResultado(EnumResultado resultado) {
		this.resultado = resultado;
	}

	
	
	public  String puntos() {
		
		EnumResultado resultadoReal = this.partido.resultado(getEquipo());
	
		if (this.resultado.equals(resultadoReal)) { 
		
		   return participante;
		} else {
			return "1";
		}}}





	





	
	


