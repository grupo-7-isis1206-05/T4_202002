package model.logic;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import model.data_structures.ArregloDinamico;
import model.data_structures.BST;
import model.data_structures.ListaEncadenada;
import model.data_structures.Nodo;
import model.data_structures.Pelicula;
import model.data_structures.Sort;
import model.data_structures.Elenco;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico<Pelicula> peliculas;
	private ArregloDinamico<Accidente> accidentess;
	private ListaEncadenada<Nodo<Pelicula>> listaPeliculas;
	
	private BST<String, ArregloDinamico<Accidente>> bst;





	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		peliculas = new ArregloDinamico<Pelicula>(120);
		accidentess = new ArregloDinamico<Accidente>(120);

		listaPeliculas= new ListaEncadenada<Nodo<Pelicula>>();
		bst = new BST<String, ArregloDinamico<Accidente>>();
	}

	
	public void cargar() throws IOException
	{
		String archivo = "./data/us_accidents_small.csv";
		BufferedReader reader = null;
		String linea ="";
		try {
		reader= new BufferedReader(new FileReader(archivo));
		while ((linea=reader.readLine())!=null)
		{
			linea=reader.readLine();
			String[] accidentes = linea.split(",");
			String id = accidentes[0];
			String source = accidentes[1];
			
			 double tmc= 0;
			 if(!accidentes[2].isEmpty())
			 {
				 tmc=Double.parseDouble(accidentes[2]);
			 }
			 double severity= Double.parseDouble(accidentes[3]);
			 String start_time= accidentes[4];
			 String end_time= accidentes[5];
			 double start_lat= Double.parseDouble(accidentes[6]);
			 double start_long= Double.parseDouble(accidentes[7]);
			double end_lat=0;
			 if(!accidentes[8].isEmpty())
			 {
				end_lat= Double.parseDouble(accidentes[8]);
			 }
			 
				 double end_long=0;
			 
			 if(!accidentes[9].isEmpty())
			 {
				  end_long= Double.parseDouble(accidentes[9]);
			 }
			 
			
			 double distance= Double.parseDouble(accidentes[10]);
			 String description= accidentes[11];
			 
			 double number= 0;
			 if(!accidentes[12].isEmpty())
			 {
				 number=Double.parseDouble(accidentes[12]);
			 }
			 String street= accidentes[13];
			 String side= accidentes[14];
			 String city= accidentes[15];
			 String county= accidentes[16];
			 String state= accidentes[17];
			 String zipCode= accidentes[18];
			 String country = accidentes[19];
			 String timeZone= accidentes[20];
			 String airportCode= accidentes[21];
			 String weathertimestamp=accidentes[22];
			 
			 double temperatureFarenheit=0;
			 if(!accidentes[23].isEmpty())
			 {
				 temperatureFarenheit=Double.parseDouble(accidentes[23]);
			 }
			 
			 double windChillFarenheit=0;
			 if(!accidentes[24].isEmpty())
			 {
				 windChillFarenheit=Double.parseDouble(accidentes[24]);
			 }
			 double humidity=0;
			 if(!accidentes[25].isEmpty())
			 {
				 humidity=Double.parseDouble(accidentes[25]);
			 }
			 double preassure=0;
			 if(!accidentes[26].isEmpty())
			 {
				 preassure=Double.parseDouble(accidentes[26]);
			 }
			 double visibility=0;
			 if(!accidentes[27].isEmpty())
			 {
				 visibility=Double.parseDouble(accidentes[27]);
			 }
			 String windDirection=accidentes[28];
			 double windSpeed=0;
			 if(!accidentes[29].isEmpty())
			 {
				 windSpeed=Double.parseDouble(accidentes[29]);
			 }
			 double precipitacion=0;
			 if(!accidentes[30].isEmpty())
			 {
				 precipitacion=Double.parseDouble(accidentes[30]);
			 }
			 String weatherCondition=accidentes[31];
			 
			 boolean amenity=Boolean.parseBoolean(accidentes[32]);
			 boolean bump=Boolean.parseBoolean(accidentes[33]);
			 boolean crossing=Boolean.parseBoolean(accidentes[34]);
			 boolean give_way=Boolean.parseBoolean(accidentes[35]);
			 boolean junction=Boolean.parseBoolean(accidentes[36]);
			 boolean noExit=Boolean.parseBoolean(accidentes[37]);
			 boolean railway=Boolean.parseBoolean(accidentes[38]);
			 boolean roundAbout=Boolean.parseBoolean(accidentes[39]);
			 boolean station=Boolean.parseBoolean(accidentes[40]);
			 boolean stop=Boolean.parseBoolean(accidentes[41]);
			 boolean trafficCalming=Boolean.parseBoolean(accidentes[42]);
			 boolean trafficSignal=Boolean.parseBoolean(accidentes[43]);
			 boolean turningLoop=Boolean.parseBoolean(accidentes[44]);
			 String sunriseSunset=accidentes[45];
			 String civilTwilight=accidentes[46];
			 String nauticalTwilight=accidentes[47];
			 String astronomicalTwilight=accidentes[48];
			 
			 String[] llave = start_time.split(" ");
			 
			 Accidente agregar = new Accidente(id, source, tmc, severity, start_time, end_time, start_lat, start_long, end_lat, end_long, distance, description, number, street, side, city, county, state, zipCode, country, timeZone, airportCode, weathertimestamp, temperatureFarenheit, windChillFarenheit, humidity, preassure, visibility, windDirection, windSpeed, precipitacion, weatherCondition, amenity, bump, crossing, give_way, junction, noExit, railway, roundAbout, station, stop, trafficCalming, trafficSignal, turningLoop, sunriseSunset, civilTwilight, nauticalTwilight, astronomicalTwilight);
			// bst.put(id, agregar);
			 accidentess.agregar(agregar);
			

		}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
		}
	}
	
	
	public int cargarABST()
	{
		int counter =0;
		int i =0;
		while(i<accidentess.darTamano())
		{
			Accidente actual = accidentess.darElemento(i);
			String[] sum = actual.darStartTime().split(" ");
			String llave = sum[0];
			System.out.println(llave);
			if(!bst.contains(llave))
			{
				ArregloDinamico<Accidente> add = new ArregloDinamico<Accidente>(20);
				add.agregar(actual);
				bst.put(llave, add);
			}
			else 
			{
				bst.get(llave).agregar(actual);
			}
			counter++;
			i++;
		}
		return counter;
	}
	
	public String req1(String fecha)
	{
		String respuesta = "";
		if(bst.contains(fecha))
		{
			int i =0;
			while (i<bst.get(fecha).darTamano())
			{
				
				Accidente actual = bst.get(fecha).darElemento(i);
				respuesta+=actual.toStringCorto();
				i++;
			}
		}
		else 
		{
			respuesta="no se encontraron accidentes en esa fecha";
		}
		
		return respuesta;
	}
	
	public void ordenarPorSeveridad(ArregloDinamico<Accidente> algo)
	{
		for (int i = 0; i < algo.darTamano(); i++) {
			Accidente actual = algo.darElemento(i);
			for (int j = 1; j < algo.darTamano(); j++) {
				Accidente actual2 = algo.darElemento(j);
				if(actual2.darSeverity()>actual.darSeverity())
				{
					Accidente swap = actual;
					algo.set(i, actual2);
					algo.set(j, actual);
				}
			}
		}
	}
	public BST<String, ArregloDinamico<Accidente>> prueba()
	{
		return bst;
	}
	public ArregloDinamico<Accidente> prueba2()
	{
		return accidentess;
	}
	
	public String toStringPeli()
	{
		return listaPeliculas.toString();
	}

	public ArregloDinamico darPeliculas()
	{
		return peliculas;
	}





}
