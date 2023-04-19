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
	ArrayList<Ronda> rondas = new ArrayList<Ronda>();
	
   
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
			String Fase=null;
			String Ronda=null;
			
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[4]);
			Fase=campos[5];
			Ronda=campos[0];
			Partido partido = new Partido(equipo1, equipo2,Ronda,Fase);
			partido.setGolesEq1(Integer.parseInt(campos[2]));
			partido.setGolesEq2(Integer.parseInt(campos[3]));
			
			partidos.add(partido);
		  
			
  // agregue rondas
			
		
			Ronda ronda = new Ronda(campos[5], campos[0]);
	        ronda.agregarRondadePartidos(ronda);;	      
	       rondas.add(ronda);
	        
	    //   System.out.println(ronda.fase()); 
			  
		}}
	
              
       
	Integer tamañoFase = rondas.size();
    
 //   System.out.println(tamañoFase); 
    
	// Leer pronostico
	

	Collection<Pronostico> pronosticos = new ArrayList<Pronostico>();
	HashSet<String>participan=new HashSet<String>();
	 ArrayList<String> nombres2 = new ArrayList<String>();
	ArrayList<String> nombresFase1 = new ArrayList<String>();
	ArrayList<String> nombresFase2 = new ArrayList<String>();
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
	
		    
		 
	
			Equipo equipo1 = new Equipo(campos[1]);
			Equipo equipo2 = new Equipo(campos[5]);
			
			
	
			String participante = null;
			String ronda=null;
			String fase=null;
			Equipo equipo = null;
			
		
			EnumResultado resultado = null;
			for (Partido partidoCol : partidos) {
				if (partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre())
						&& partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) {

			
				if("x".equals(campos[2])) {
					
					equipo = equipo1;
					resultado = EnumResultado.GANADOR;
					participante = campos[0];
					ronda= campos[6];
					fase= campos[7];
				}
				if("x".equals(campos[3])) {
					equipo = equipo1;
					resultado = EnumResultado.EMPATE;
				}participante = campos[0];
				ronda= campos[6];
				fase= campos[7];
				if("x".equals(campos[4])) {
					equipo = equipo1;
					resultado = EnumResultado.PERDEDOR;
				}participante = campos[0];
				ronda= campos[6];
				fase= campos[7];
				
				
				Pronostico pronostico = new Pronostico(partidoCol,equipo,resultado,participante,ronda,fase);
				
				pronosticos.add(pronostico);
				participan.add(participante);
		
				
			String  ganadores = pronostico.puntos(); 
			String ganadoresxFase1 = pronostico.puntosxFase1();
			String ganadoresxFase2 = pronostico.puntosxFase2();
		   
		
			
			 if(!ganadoresxFase1.equals("1")) {	  
			      nombresFase1.add(ganadores);}
			 
			 if(!ganadoresxFase2.equals("1")) {	  
			      nombresFase2.add(ganadores);}
			
			  if (ganadores.equals(pronostico.getParticipante())) {
				 
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
	
			    	Integer puntosxronda= puntaje.getPuntosxPartido();
			    			
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
						
						  Map<String, Integer> contadorFase1 = new HashMap<>();
						  
						  for (String participanteFase1 : nombresFase1) { 
							  if (contadorFase1.containsKey(participanteFase1)) {				  
						 contadorFase1.put(participanteFase1, contadorFase1.get(participanteFase1) + 1);
                      } else { 
                    	
						  
						  contadorFase1.put(participanteFase1, 1); 
						  }}
                      Map<String, Integer> contadorFase2 = new HashMap<>();
						  
						  for (String participanteFase2 : nombresFase2) { 
							  if (contadorFase2.containsKey(participanteFase2)) {				  
						 contadorFase2.put(participanteFase2, contadorFase2.get(participanteFase2) + 1);
                      } else { 
                    	
						  
						  contadorFase2.put(participanteFase2, 1); 
						  }}
			       
			    System.out.println(contador+"->Los asiertos son 7 y 3 respectivamente, pero se multiplican x 2 por el valor de puntaje elegido");
			        System.out.println(contadorFase1+"->para obtener puntaje extra en fase1 se necesitan 8 asiertos");
			        System.out.println(contadorFase2+"->para obtener puntaje extra en fase2 se necesitan 2 asiertos");
			     
	
		}}}}
	
	
		
				
			
			
			
				
				
			
