package model.logic;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.IListaEncadenada;
import model.data_structures.ListaEncadenada;
import model.data_structures.Nodo;
import model.data_structures.Pelicula;
import model.data_structures.ShellSort;
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

	private ListaEncadenada<Nodo<Pelicula>> listaPeliculas;
	private ListaEncadenada listaElenco;




	private int counterPeliculas;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		peliculas = new ArregloDinamico(120);
		listaPeliculas= new ListaEncadenada<Nodo<Pelicula>>();
		listaElenco= new ListaEncadenada();
	}



	public void cargarDato() throws IOException 
	{

		String csvFileS = "./data/SmallMoviesDetailsCleaned.csv";
		String archivoS = "./data/MoviesCastingRaw-small.csv";
		String csvFileB = "./data/AllMoviesCastingRaw.csv";
		String archivoB = "./data/AllMoviesDetailsCleaned.csv";
		BufferedReader br = null;
		BufferedReader pr = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFileS));
			while ((line = br.readLine()) != null) {

				String[] movie = line.split(cvsSplitBy);
				String id = movie[0];
				String budget = movie[1];
				String genres = movie[2];
				String imbd = movie[3];
				String originalLang = movie[4];
				String originalTitle = movie[5];
				String overview = movie[6];
				String popularity = movie[7];
				String proCompanies = movie[8];
				String proCountries = movie[9];
				String releaseDate = movie[10];
				String revenue = movie[11];
				String runtime = movie[12];
				String spokenLanguages = movie[13];
				String status = movie[14];
				String tagline = movie[15];
				String title = movie[16];
				String voteAverage = movie[17];
				String voteCount = movie[18];
				String proCompaniesNumber = movie[19];
				String proCompaniesCountryNumber = movie[20];
				String spokenLanguagesNumber = movie[21];
				if(!id.equals("id"))
				{
					Pelicula actual = new Pelicula (id,budget, genres,imbd,originalLang, originalTitle,overview,popularity,proCompanies,
							proCountries,releaseDate,revenue,runtime,spokenLanguages,status,tagline,title,voteAverage,voteCount,
							proCompaniesNumber,proCompaniesCountryNumber,spokenLanguagesNumber);
					peliculas.agregar(actual);

				}



			}
			pr = new BufferedReader(new FileReader(archivoS));
			while ((line = pr.readLine()) != null) {
				String[] cast = line.split(cvsSplitBy);

				String id = cast[0];
				String actor1 = cast[1];
				String gender1 = cast[2];
				String actor2 = cast[3];	
				String gender2 = cast[4];
				String actor3 = cast[5];
				String gender3 = cast[6];
				String actor4 = cast[7];
				String gender4 = cast[8];
				String actor5 = cast[9];
				String gender5 = cast[10];
				String actorNumber = cast[11];
				String directorName = cast[12];
				String directorGender = cast[13];
				String directorNumber = cast[14];
				String producerName = cast[15];
				String producerNumber = cast[16];
				String screenName = cast[17];
				String editorName = cast[18];

				if(!id.equals("id"))
				{
					Elenco agregar = new Elenco (id, actor1,gender1,actor2, gender2,actor3,gender3, actor4,gender4,actor5,gender5, actorNumber,directorName,directorGender,directorNumber, producerName, producerNumber, screenName, editorName ); 


					for(int i=0; i<peliculas.darTamano();i++ )
					{

						if( peliculas.darElemento(i).darId().equals(id))
						{
							peliculas.darElemento(i).añadirElenco(agregar);


						}
					}
				}


			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/*	public void cargarDatoLista() throws IOException 
        {

        	String csvFile = "./data/SmallMoviesDetailsCleaned.csv";
        	String archivo = "./data/MoviesCastingRaw-small.csv";
            BufferedReader br = null;
            BufferedReader pr = null;
            String line = "";
            String cvsSplitBy = ";";
            int posicionPeli =1;
            int posicionElenco=1;

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    String[] movie = line.split(cvsSplitBy);
                    String id = movie[0];
                    String genres = movie[1];
                    String imbd = movie[2];
                    String originalLang = movie[3];
                    String originalTitle = movie[4];
                    String overview = movie[5];
                    String popularity = movie[6];
                    String proCompanies = movie[7];
                    String proCountries = movie[8];
                    String releaseDate = movie[9];
                    String revenue = movie[10];
                    String runtime = movie[11];
                    String spokenLanguages = movie[12];
                    String status = movie[13];
                    String tagline = movie[14];
                    String title = movie[15];
                    String voteAverage = movie[16];
                    String voteCount = movie[17];
                    String proCompaniesNumber = movie[18];
                    String proCompaniesCountryNumber = movie[19];
                    String spokenLanguagesNumber = movie[20];

                     Pelicula actual = new Pelicula (id,genres,imbd,originalLang, originalTitle,overview,popularity,proCompanies,
                    		proCountries,releaseDate,revenue,runtime,spokenLanguages,status,tagline,title,voteAverage,voteCount,
                    		proCompaniesNumber,proCompaniesCountryNumber,spokenLanguagesNumber);
                     Nodo<Pelicula> algo = new Nodo<Pelicula>(actual, null,null,posicionPeli);
                     listaPeliculas.addLast(algo);
                     posicionPeli++;



                }
                pr = new BufferedReader(new FileReader(archivo));
                while ((line = pr.readLine()) != null) {
                	String[] cast = line.split(cvsSplitBy);
                    int id = Integer.parseInt(cast[0]);
                    String actor1 = cast[1];
                    String gender1 = cast[2];
                    String actor2 = cast[3];	
                    String gender2 = cast[4];
                    String actor3 = cast[5];
                    String gender3 = cast[6];
                    String actor4 = cast[7];
                    String gender4 = cast[8];
                    String actor5 = cast[9];
                    String gender5 = cast[10];
                    String actorNumber = cast[11];
                    String directorName = cast[12];
                    String directorGender = cast[13];
                    String directorNumber = cast[14];
                    String producerName = cast[15];
                    String producerNumber = cast[16];
                    String screenName = cast[17];
                    String editorName = cast[18];

                  //  Elenco agregar = new Elenco (id, actor1,gender1,actor2, gender2,actor3,gender3, actor4,gender4,actor5,gender5, actorNumber,directorName,directorGender,directorNumber, producerName, producerNumber, screenName, editorName ); 
                   // Nodo<Elenco> agrego = (Nodo<Elenco>) new Nodo<Elenco>(agregar, null,null, posicionElenco);
                 //   listaElenco.addLast(agrego);




                    posicionElenco++;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


//    	public String buenasPeliculas(String director)
//    	{
//    		String respuesta = "";
//    		String idABuscar="";
//    		int i = 1;
//    		int j = 1;
//    		while(i<listaElenco.size())
//    		{
//    			//peliculas.darElemento(2).
//    			
//    			Nodo<Elenco> algo = listaElenco.element(i);
//    			
//    			
//    			String directorA = algo.darDatos().darDirectorName();
//    			if(directorA.equalsIgnoreCase(director))
//    			{
//    				idABuscar= algo.darDatos().darId();
//    				respuesta += elenco.darElemento(i).darActores();
//    			}
//    			i++;
//    		}
//    		while(j<listaPeliculas.size())
//    		{
//    			Nodo<Pelicula> peli = listaPeliculas.element(j);
//    			String actualID = peli.darDatos().darId();
//    			if (actualID.equalsIgnoreCase(idABuscar))
//    			{
//    				respuesta+=", "+ peli.darDatos().darDatosReq();
//    			}
//    		j++;	
//    		}
//    		
//    		return respuesta;
//    	}*/
	public String cantidadBuenasPeliculas(String director)
	{
		int buenasPeliculas = 0;
		Double promedio = 0.0;
		String respuesta = null;
		boolean encontrado = false;
		for (int i=0; i< peliculas.darTamano();i++)
		{ 
			Pelicula actual = peliculas.darElemento(i);
			String delActual =actual.darElenco().darDirectorName();
			if (delActual.equals(director))
			{
				encontrado = true;
				double voteAverage = Double.parseDouble(actual.darVoteAverage());
				if(voteAverage >= 6)
				{

					buenasPeliculas = buenasPeliculas+1;
					promedio = promedio + voteAverage;

				}
			}			

		}
		promedio = promedio/ buenasPeliculas;
		if(encontrado)
		{
			respuesta = "El numero de peliculas buenas para el director "+director+ " es de: "+buenasPeliculas+". El promedio de la votacion es de: "+ promedio;
		}
		else
		{
			respuesta = "El director no se encontro.";
		}

		return respuesta;
	}

	public String conocerDirector (String nombre)
	{

		ArregloDinamico <String> listaPelis = new ArregloDinamico(335);
		String respuesta1 = null;
		String respuesta2 = null;
		String respuesta3 = null;
		int numeroPeliculas = 0;
		double promedio = 0.0;
		double promedioFinal= 0.0;
		boolean encontrado = false;
		for (int i=0; i< peliculas.darTamano();i++)
		{ 
			Pelicula actual = peliculas.darElemento(i);
			Elenco delActual = actual.darElenco();
			if (delActual.darDirectorName().equals(nombre))
			{
				encontrado = true;
				listaPelis.agregar(actual.darTitle());
				numeroPeliculas = numeroPeliculas + 1; 				
				promedio = promedio + Double.parseDouble(actual.darVoteAverage());				

			}

		}
		promedioFinal = promedio/ listaPelis.darTamano();
		if (encontrado)
		{
			respuesta1 = "El numero de peliculas del director "+ nombre+ " es de: "+ numeroPeliculas+".";
			respuesta2 = "Las peliculas dirigidas por ese director son:  "+ listaPelis;
			respuesta3= "El promedio de la calificacion de sus peliculas es de: " + promedioFinal+".";
		}
		else
		{
			respuesta1 = "El director que ha escrito, no existe";
		}

		return respuesta1 +" "+ respuesta2+" "+ respuesta3;
	}

	public String entenderGenero (String genero)
	{

		ArregloDinamico <String> listaPelis = new ArregloDinamico(335);
		String respuesta1 = null;
		String respuesta2 = null;
		String respuesta3 = null;
		
		int numeroPeliculas = 0;
		Double promedio = 0.0;
		Double promedioVotos= 0.0;
		boolean encontrado = false;
		for (int i=0; i< peliculas.darTamano();i++)
		{ 
			Pelicula actual1 = peliculas.darElemento(i);
			String voteCount = actual1.darVoteCount();
			String generoPorPartes = actual1.darGenres();
			
			if ( generoPorPartes.contains(genero))
			{				
				encontrado = true;
				listaPelis.agregar(actual1.darTitle());
				numeroPeliculas = numeroPeliculas + 1; 
				Double voteCountInt = Double.parseDouble(voteCount);
				promedio = promedio + voteCountInt;				

			}

		}
		promedioVotos = promedio/ listaPelis.darTamano();
		if (encontrado)
		{
			respuesta1 = "Las peliculas de este genero son:  "+ listaPelis;
			respuesta2 = "El numero de peliculas de ese genero son: "+ numeroPeliculas;
			respuesta3= "El promedio de votos del genero es de: " + promedioVotos+". \n";
			
		}
		else
		{
			respuesta1 = "El genero que ha escrito, no existe";
		}

		return respuesta1 +" "+ respuesta2+" "+ respuesta3;
	}



	public String Ranking(int x)
	{

		int i =0;

		String respuesta ="";
		Pelicula[] arreglo = new Pelicula[x];
		while (i<peliculas.darTamano())
		{
			Pelicula actual=peliculas.darElemento(i);
			if(arreglo[x-1]!=null)
			{
				ShellSort.sort(arreglo);
				if(actual.darVoteAverage().compareTo(arreglo[x-1].darVoteAverage())>0)
				{
					arreglo[x-1]=actual;
				}

			}
			if(i<x-1)
			{
				arreglo[i]=actual;
			}
		}
		respuesta+=arreglo.toString();
		return respuesta;

	}

	public boolean isFull(Pelicula[] a)
	{
		boolean respuesta=false;
		int i=0;
		while(i<a.length)
		{

		}
		return respuesta;
	}

	public String conocerActor(String actor)
	{
		String respuesta="";
		int cantidad =0;
		double votacion = 0;
		String director = MasColaboraciones(actor);

		String pelis= "";
		int i =0;
		while(i<peliculas.darTamano())
		{
			Pelicula actual = peliculas.darElemento(i);


			String actual1 = peliculas.darElemento(i).darElenco().darActor1();
			String actual2 = peliculas.darElemento(i).darElenco().darActor2();
			String actual3 = peliculas.darElemento(i).darElenco().darActor3();
			String actual4 = peliculas.darElemento(i).darElenco().darActor4();
			String actual5 = peliculas.darElemento(i).darElenco().darActor5();

			if(actual1.equalsIgnoreCase(actor)||actual2.equalsIgnoreCase(actor)||actual3.equalsIgnoreCase(actor)||actual4.equalsIgnoreCase(actor)||actual5.equalsIgnoreCase(actor))
			{
				cantidad++;
				votacion += Double.parseDouble(actual.darVoteAverage());
				pelis+=actual.toString();

			}

			i++;
		}

		double promedio = votacion/cantidad;
		respuesta= "el actor "+actor+" ha participado en "+cantidad+" peliculas. Con un promedio de votacion de "+promedio+
				". El director con el que mas ha colaborado es:"+director+" Y la lista de sus peliculas es: \n"+pelis;
		return respuesta;
	}

	public String MasColaboraciones(String actor)
	{

		ArregloDinamico<String> algo = new ArregloDinamico<String>(20);			
		String respuesta= algo.darElemento(0);

		int i=0;
		int j=0;
		int k=0;
		while(i<peliculas.darTamano())
		{
			Pelicula actual=peliculas.darElemento(i);
			String actual1 = peliculas.darElemento(i).darElenco().darActor1();
			String actual2 = peliculas.darElemento(i).darElenco().darActor2();
			String actual3 = peliculas.darElemento(i).darElenco().darActor3();
			String actual4 = peliculas.darElemento(i).darElenco().darActor4();
			String actual5 = peliculas.darElemento(i).darElenco().darActor5();
			if(actual1.equalsIgnoreCase(actor)||actual2.equalsIgnoreCase(actor)||actual3.equalsIgnoreCase(actor)||actual4.equalsIgnoreCase(actor)||actual5.equalsIgnoreCase(actor))
			{
				String directorA = actual.darElenco().darDirectorName();

				algo.agregar(directorA);

			}
			i++;
		}

		while(j<algo.darTamano())
		{

			String compare = algo.darElemento(j);
			if(repetido(algo, respuesta)<repetido(algo,compare))
			{
				respuesta=compare;
			}
			j++;
		}


		return respuesta;
	}

	public int repetido(ArregloDinamico<String> a, String b )
	{
		int respuesta =0;
		int i=0;
		while (i<a.darTamano())
		{
			if(a.darElemento(i).equals(b))
			{
				respuesta++;
			}
			i++;
		}

		return respuesta;
	}

	public String rankingGenero(int x, String genero)
	{
		String respuesta="";
		int i =0;
		
		Pelicula[] arreglo = new Pelicula[x];
		while (i<peliculas.darTamano())
		{

			Pelicula actual=peliculas.darElemento(i);
			if(actual.darGenres().contains(genero))
			{
				if(arreglo[x-1]!=null)
				{
					ShellSort.sort(arreglo);
					if(actual.darVoteAverage().compareTo(arreglo[x-1].darVoteAverage())>0)
					{
						arreglo[x-1]=actual;
					}

				}
				if(i<x-1)
				{
					arreglo[i]=actual;
				}
			}
		}
		respuesta+=arreglo.toString();
		return respuesta;
		
	}
	public String toStringPeli()
	{
		return listaPeliculas.toString();
	}
	public String toStringElenco()
	{
		return listaElenco.toString();
	}

	public ListaEncadenada darListaPeli()
	{
		return listaPeliculas;
	}
	public ListaEncadenada darListaElenco()
	{
		return listaElenco;
	}



}
