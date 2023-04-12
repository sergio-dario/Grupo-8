package org.argentinaprograma.Stropeni;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.argentinaprograma.Stropeni.models.*;



public class App {

    

	public static void main( String[] args ){
    	
    
	// Leer resultados
	Collection<Partido> partidos = new ArrayList<Partido>();
	
   
	Path pathResultados = Paths.get("src\\main\\java\\org\\argentinaprograma\\Stropeni\\models\\resultado.csv");
	List<String> lineasResultados = null;
    try {
	 
		lineasResultados = Files.readAllLines(pathResultados);
	} catch (IOException e) {
		System.out.println("No se pudo leer la linea de resultados...");
		System.out.println(e.getMessage());
		System.exit(1);}

	boolean primera = true;
	for (String lineaResultado : lineasResultados) {
		if (primera) {
			primera = false;
		} else {
		

			
			String[] campos = lineaResultado.split(",");
			
			
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[4]);
			Partido partido = new Partido(equipo1, equipo2);
			partido.setGolesEq1(Integer.parseInt(campos[2]));
			partido.setGolesEq2(Integer.parseInt(campos[3]));
			partidos.add(partido);
		  
			
  // agregue rondas
			
			Ronda nro = new Ronda(campos[0]);
			nro.agregarRondadePartidos(nro);
			
			  
		}}

	
	// Leer pronostico

	
	Collection<Pronostico> pronosticos = new ArrayList<Pronostico>();
	HashSet<String>participan=new HashSet<String>();
	 ArrayList<String> nombres2 = new ArrayList<String>();
	
	Path pathPronostico = Paths.get("src\\main\\java\\org\\argentinaprograma\\Stropeni\\models\\pronostico.csv");
	List<String> lineasPronostico = null;
	try {
		lineasPronostico = Files.readAllLines(pathPronostico);
	} catch (IOException e1) {
		System.out.println("No se pudo leer la linea de pronosticos...");
		System.out.println(e1.getMessage());
		System.exit(1);
	}
	
	primera = true;
	for (String lineaPronostico : lineasPronostico) {
		
		if (primera) {
			primera = false;
		} else {
			
			
			String[] campos = lineaPronostico.split(",");
	
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[5]);
			
			
	
			String participante = null;
			Equipo equipo = null;
			EnumResultado resultado = null;
			for (Partido partidoCol : partidos) {
				if (partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre())
						&& partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) {

			
				
			
			
				if("x".equals(campos[2])) {
					
					equipo = equipo1;
					resultado = EnumResultado.GANADOR;
					participante = campos[0];
				}
				if("x".equals(campos[3])) {
					equipo = equipo1;
					resultado = EnumResultado.EMPATE;
				}participante = campos[0];
				if("x".equals(campos[4])) {
					equipo = equipo1;
					resultado = EnumResultado.PERDEDOR;
				}participante = campos[0];
				
				
				Pronostico pronostico = new Pronostico(partidoCol,equipo,resultado,participante);
				
				pronosticos.add(pronostico);
				participan.add(participante);
		
				
			String  ganadores = pronostico.puntos(); 
		
				
			  if (ganadores.equals(pronostico.getParticipante())) {
				 
				  nombres2.add(ganadores);
			
				  
				}}}}}
			    	
			    	Integer puntosxronda= Ronda.PuntosxRonda();
			    			
			    	   Map<String, Integer> contador = new HashMap<>();

			           for (String participanteG : nombres2) {
			               if (contador.containsKey(participanteG)) {
			            	   
			            	   // solo tengo que cambiar el 1 por el numero que quiera para aumentar el puntaje por ronda
			                   contador.put(participanteG, contador.get(participanteG) + puntosxronda);
			               } else {
			            	   // solo tengo que cambiar el 1 por el numero que quiera para aumentar el puntaje por ronda
			            	   
			                   contador.put(participanteG, puntosxronda);
			              
			               }
			           }
                    
			         System.out.println();
			         System.out.println(Ronda.PuntosExtrasxRonda());
			         System.out.println(Ronda.PuntosExtrasxFase());
			         System.out.println(contador);
	
	
	}}
	
	
		
				
			
			
			
				
				
			
