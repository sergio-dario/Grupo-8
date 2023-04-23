package org.argentinaprograma.Stropeni;



import static org.junit.Assert.assertEquals;

import org.argentinaprograma.Stropeni.models.EnumResultado;
import org.argentinaprograma.Stropeni.models.Equipo;
import org.argentinaprograma.Stropeni.models.Partido;
import org.argentinaprograma.Stropeni.models.Pronostico;
import org.junit.Before;
import org.junit.Test;

public class PronosticoTest {

	
	private Equipo equipo1;
	private Equipo equipo2;
	private Partido partido ;
	private String participante;
	private Integer Fase;
	private Integer Ronda;
	
	@Before
	public void setUp() {
		this.equipo1 = new Equipo("Boca");
		this.equipo2 = new Equipo("San Lorenzo");
		this.partido.setGolesEq1(1);
		this.partido.setGolesEq2(3);
		this.participante = new String ("Mariana");
	}

	@Test
	public void testControlarAciertos() {

		// Escenario
		Partido partido = new Partido(this.equipo1,this.equipo2,Ronda, Fase);
		
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.PERDEDOR,participante,Ronda,Fase);

		// Procesar
		String puntos = pronostico.puntos();

		// Evaluar

		assertEquals("Mariana", puntos);


	} 

	@Test
	public void testControlarDesaciertos() {

		// Escenario
		Partido partido = new Partido(this.equipo1,this.equipo2,Ronda,Fase);
		
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.EMPATE,participante,Ronda,Fase);

		// Procesar
		String puntos = pronostico.puntos();

		// Evaluar

		assertEquals("1", puntos);


	} 

}



