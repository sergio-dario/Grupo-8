package org.argentinaprograma.Stropeni;

import static org.junit.Assert.assertEquals;

import org.argentinaprograma.Stropeni.models.EnumResultado;
import org.argentinaprograma.Stropeni.models.Equipo;
import org.argentinaprograma.Stropeni.models.Partido;
import org.argentinaprograma.Stropeni.models.Pronostico;
import org.junit.Before;
import org.junit.Test;

public class Rondas {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Partido partido ;
	private String participante;
	private int Fase;
	private int Ronda;
	
	@Before
	public void setUp() {
		this.equipo1 = new Equipo("Boca");
		this.equipo2 = new Equipo("San Lorenzo");
		this.participante = new String ("Mariana");
		this.Fase = 1;
		this.Ronda = 1;
		this.partido = new Partido(this.equipo1, this.equipo2,this.Ronda,this.Fase );
		this.partido.setGolesEq1(3);
		this.partido.setGolesEq2(3);
		
	}
	@Test
	public void testControlarAciertos() {

		// Escenario
		Partido partido = new Partido(this.equipo1,this.equipo2,this.Ronda, this.Fase);
		
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.EMPATE,participante,Ronda,Fase);

		// Procesar
		String puntos = pronostico.puntosxRonda();

		// Evaluar

		assertEquals((participante+","+Fase),puntos);
		


	} 

}
