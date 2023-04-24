package org.argentinaprograma.Stropeni;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
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
	List<Ronda> rondas = new ArrayList<>();
	List<Integer> NroRondas = new ArrayList<>();
	List<Integer> NroFases = new ArrayList<>();
	
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
			Integer Fase=null;
			Integer Ronda=null;
			
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[4]);
			
			
			Ronda=Integer.parseInt(campos[0]);
			Fase= Integer.parseInt(campos[5]);
			
			
			Partido partido = new Partido(equipo1, equipo2,Ronda,Fase);
			partido.setGolesEq1(Integer.parseInt(campos[2]));
			partido.setGolesEq2(Integer.parseInt(campos[3]));
			
			partidos.add(partido);
		  
			
  // agregue rondas
			
			
	        Ronda ronda = new Ronda(equipo1,equipo2,Ronda,Fase);
	        rondas.add(ronda);
	       
	// determino cual es el numero max de rondas y Fases
	        
	        Integer NumeroRondas = partido.numeroRondas();
	       if (!NumeroRondas.equals(0)) {
	    	   NroRondas.add(NumeroRondas);
	   
	       }
	       Integer NumeroFases = partido.numeroFases();
	       if (!NumeroFases.equals(0)) {
	    	   NroFases.add(NumeroFases);
	       }
	       }
		}
	
	// Leer pronostico
	

	Collection<Pronostico> pronosticos = new ArrayList<Pronostico>();
	HashSet<String>participan=new HashSet<String>();
	 ArrayList<String> nombres2 = new ArrayList<String>();
	ArrayList<String> nombresFase = new ArrayList<String>();
	ArrayList<String> nombresRonda = new ArrayList<String>();
	
	
	//registrar el Driver
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	//crear el objeto de coneccion
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pronostico","root","Policloruro_de_Aluminio3");
		// Creacion de sentencia
		Statement stmt = con.createStatement();
		
	// ejecutamos y obtenemos los resultados de la sentencia (en este caso trae la columna2
	// podria modificar la tabla	stmt.executeUpdate(null)
		ResultSet rs = stmt.executeQuery("SELECT * FROM pronosticos");
		//Recorrer el resultado que me devolvio
		
		
		
		String[] campos = new String[8];
		while(rs.next()) {
			
			campos[0]=rs.getString(1);
		    campos[1]=rs.getString(2);
		    campos[2]=rs.getString(3);
		    campos[3]=rs.getString(4);
		   campos[4]=rs.getString(5);
		    campos[5]=rs.getString(6);
		   campos[6]=rs.getString(7);
		    campos[7]=rs.getString(8);
	
		    Integer.parseInt(campos[6]);
		 
	
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[5]);
			
			
	
			String participante = null;
			Integer ronda=null;
			Integer fase=null;
			Equipo equipo = null;
			
		
			EnumResultado resultado = null;
			for (Partido partidoCol : partidos) {
				if (partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre())
						&& partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) {

			
				if("x".equals(campos[2])) {
					
					equipo = equipo1;
					resultado = EnumResultado.GANADOR;
					participante = campos[0];
					ronda=Integer.parseInt(campos[6]);
					
					fase= Integer.parseInt(campos[7]);
				}
				if("x".equals(campos[3])) {
					equipo = equipo1;
					resultado = EnumResultado.EMPATE;
				participante = campos[0];
				ronda=Integer.parseInt(campos[6]);
				fase= Integer.parseInt(campos[7]);}
				if("x".equals(campos[4])) {
					equipo = equipo1;
					resultado = EnumResultado.PERDEDOR;
				participante = campos[0];
				ronda=Integer.parseInt(campos[6]);
				fase= Integer.parseInt(campos[7]);}
				
				
				Pronostico pronostico = new Pronostico(partidoCol,equipo,resultado,participante,ronda,fase);
				
				pronosticos.add(pronostico);
				
				participan.add(participante);
		
				
			String  ganadores = pronostico.puntos(); 
			String ganadoresxFase = pronostico.puntosxFase();	
		   String ganadoresxRonda = pronostico.puntosxRonda();	
		
		 
			 if(!ganadoresxFase.equals("1")) {	  
			      nombresFase.add(ganadoresxFase);}
			 
			
			 if(!ganadoresxRonda.equals("1")) {
			       nombresRonda.add(ganadoresxRonda);}
			
			 if(!ganadores.equals("1")) {
 				  nombres2.add(ganadores);}
				
			 
			} } } 
			// cierra la coneccion
			con.close();
	
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	//}
			    
	// leer y asignar los puntos por partido,ronda,fase
	
	Collection<Puntaje> puntajes = new ArrayList<Puntaje>();
	
	Path pathPuntaje = Paths.get("src\\main\\java\\org\\argentinaprograma\\Stropeni\\models\\puntaje.csv");
	List<String> lineasPuntaje = null;
	try {
		lineasPuntaje = Files.readAllLines(pathPuntaje);
	} catch (IOException e1) {
		System.out.println("No se pudo leer la linea de puntajes...");
		System.out.println(e1.getMessage());
		System.exit(1);
	}
	
	
	primera = true;
	for (String lineaPuntaje : lineasPuntaje) {
		
		if (primera) {
			primera = false;
		} else {
			
	 String PuntosxPartido= null;
	 String PuntosxRonda=null;
	String PuntosxFase=null;
			
			String[] campos = lineaPuntaje.split(",");
	 PuntosxPartido= campos[0];
	 PuntosxRonda= campos[1];
	 PuntosxFase= campos[2];

	Puntaje puntaje = new Puntaje( Integer. parseInt(PuntosxPartido), Integer. parseInt(PuntosxRonda), Integer. parseInt(PuntosxFase));
	
	puntajes.add(puntaje);
	
	/// puntos extras por partido
	
			    	Integer puntosxPartido= puntaje.getPuntosxPartido();
			    			
			    	   Map<String, Integer> contador = new HashMap<>();

			           for (String participanteG : nombres2) {
			               if (contador.containsKey(participanteG)) {
			            	
			                   contador.put(participanteG, contador.get(participanteG) + 1);
			               } else {
			            	
			            	   
			                   contador.put(participanteG, 1);
			              
			               }
			           }
			           for (String key : contador.keySet()) {					            
				            Integer valor = contador.get(key);
				            valor = valor * puntosxPartido ;		               
			                contador.put(key, valor);
				            	System.out.println(key + "= Puntos por partido = "+valor);
			           
			           }
			     	  //////// Puntos extras x Ronda
						  
						Integer puntosxRonda= puntaje.getPuntosxRonda();
		 Map<String, Integer> contadorRonda = new HashMap<>();
					  
					  for (String participanteRonda : nombresRonda) { 
						  if (contadorRonda.containsKey(participanteRonda)) {				  
					 contadorRonda.put(participanteRonda, contadorRonda.get(participanteRonda) + 1);
                 } else { 
               						  
					  contadorRonda.put(participanteRonda, 1); 
					  }}
					  
					  for (String key : contadorRonda.keySet()) {					            
				            Integer valor = contadorRonda.get(key);
				            
				            if (valor >=NroRondas.size()) {
				            	System.out.println(key + " ronda = Puntos extras Ronda = "+puntosxRonda);
				            }}     
					
			           
			           //// puntos extras por Fase
			           
			           
				            	Integer puntosxFase= puntaje.getPuntosxFase();		           
						  Map<String, Integer> contadorFase = new HashMap<>();
						  
						  for (String participanteFase : nombresFase) { 
							  if (contadorFase.containsKey(participanteFase)) {				  
						 contadorFase.put(participanteFase, contadorFase.get(participanteFase) + 1);
                      } else { 
                    						  
						  contadorFase.put(participanteFase, 1); 
						  }}
						  
						  for (String key : contadorFase.keySet()) {					            
					            Integer valor = contadorFase.get(key);
					            if (valor >=NroFases.size()) {
					            	System.out.println(key + "= Puntos extras Fase = "+puntosxFase);
					            }}
						  
                  
					
						
			   
		}}}

    }
	
	
	
		
				
			
			
			
				
				
			
