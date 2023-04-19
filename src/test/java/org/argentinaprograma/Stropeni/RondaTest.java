package org.argentinaprograma.Stropeni;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.argentinaprograma.Stropeni.models.*;
import org.junit.Test;

public class RondaTest {
	
	@Test
	public void validarElPuntajeEnDosRondasConsecutivas() {
		
		//Instancie 8 partidos
		
		Partido partido1 = new Partido(Argentina,Arabia,1,1);
		Partido Partido2 = new Partido(Polonia,Mexico,1,1);
		Partido partido3 = new Partido (Argentina,Mexico,1,1);
		Partido partido4 = new Partido (Arabia,Polonia,1,1);
		Partido Partido5= new Partido (Qatar,Ecuador,2,1);
		Partido Partido6= new Partido (Senegal,P.bajos,2,1);
		Partido partido7= new Partido (Qatar,Senegal,2,1);
		Partido partido8= new Partido (Ecuador,P.Bajos,2,1);
		
       // Instancie 8 Pronosticos
		Pronostico(Partido partido, Equipo equipo, EnumResultado resultado, String participante,String ronda,String fase)
    	Pronostico pronostico1 = new Pronostico ();
		

	}