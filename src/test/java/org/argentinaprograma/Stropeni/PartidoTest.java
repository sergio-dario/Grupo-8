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
		
		
		this.equipo1 = new Equipo("Boca");
		this.equipo2 = new Equipo("San Lorenzo");
		this.Fase = 1;
		this.Ronda = 1;
		this.partido = new Partido(this.equipo1, this.equipo2,this.Ronda,this.Fase );
		this.partido.setGolesEq1(3);
		this.partido.setGolesEq2(3);
	}

	@Test
	public void testPartidoPerdedor() {

		this.partido.setGolesEq1(1);
		this.partido.setGolesEq2(3);
		EnumResultado resultadoObtenido1 = partido.resultado(this.equipo1);


		// Evaluar
		assertEquals(EnumResultado.PERDEDOR, resultadoObtenido1);


	}
	@Test
	public void testPartidoGanadoo() {
		this.partido.setGolesEq1(3);
		this.partido.setGolesEq2(1);
		EnumResultado resultadoObtenido2 = partido.resultado(this.equipo2);
		assertEquals(EnumResultado.GANADOR, resultadoObtenido2);

	}
	@Test
	public void testPartidoEmpatado() {
		this.partido.setGolesEq1(3);
		this.partido.setGolesEq2(3);

		EnumResultado resultadoObtenido = partido.resultado(this.equipo1);
		assertEquals(EnumResultado.EMPATE, resultadoObtenido);

	}



}
