package org.argentinaprograma.Stropeni;



import static org.junit.Assert.assertEquals;

import org.argentinaprograma.Stropeni.models.EnumResultado;
import org.argentinaprograma.Stropeni.models.Equipo;
import org.argentinaprograma.Stropeni.models.Partido;
import org.junit.Before;
import org.junit.Test;

public class PartidoTest {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Partido partido ;
	private Integer Fase;
	private Integer Ronda;

	@Before
	public void setUp() {
		
		this.partido.setGolesEq1(3);
		this.partido.setGolesEq2(3);
		this.equipo1 = new Equipo("Boca");
		this.equipo2 = new Equipo("San Lorenzo");
		this.partido = new Partido(this.equipo1, this.equipo2,Ronda,Fase );
	}

	@Test
	public void testPartidoGanadorPerdedor() {

		// nuestro escenario
		

		// Procesar
		EnumResultado resultadoObtenido1 = partido.resultado(this.equipo1);
		EnumResultado resultadoObtenido2 = partido.resultado(this.equipo2);

		// Evaluar
		assertEquals(EnumResultado.PERDEDOR, resultadoObtenido1);
		assertEquals(EnumResultado.GANADOR, resultadoObtenido2);

	}

	@Test
	public void testPartidoEmpatado() {
		

		EnumResultado resultadoObtenido = partido.resultado(this.equipo1);
		assertEquals(EnumResultado.EMPATE, resultadoObtenido);

	}



}
