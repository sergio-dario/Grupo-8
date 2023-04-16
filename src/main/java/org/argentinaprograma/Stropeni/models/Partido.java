package org.argentinaprograma.Stropeni.models;


public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEq1;
	private Integer golesEq2;

	public Partido(Equipo equipo1, Equipo equipo2) {
	
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public Partido(Equipo equipo1, Equipo equipo2, int golesEq1, int golesEq2) {

		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEq1 = golesEq1;
		this.golesEq2 = golesEq2;
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
	public int getGolesEq1() {
		return golesEq1;
	}
	public void setGolesEq1(int golesEq1) {
		this.golesEq1 = golesEq1;
	}
	public int getGolesEq2() {
		return golesEq2;
	}
	public void setGolesEq2(int golesEq2) {
		this.golesEq2 = golesEq2;
	}

	public EnumResultado resultado(Equipo equipo) {
		if(golesEq1 == golesEq2) {
			return EnumResultado.EMPATE;
			}
		
		if(equipo2.getNombre().equals(equipo1.getNombre())) {
			if(golesEq1>golesEq2) {
				return EnumResultado.GANADOR;	
			}	else {
				return EnumResultado.PERDEDOR;
			}			
		} else {
			
			if(golesEq2<golesEq1) {
				return EnumResultado.GANADOR;	
		}	else {
				return EnumResultado.PERDEDOR;
			}	
		}

	}}



	
