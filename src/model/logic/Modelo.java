package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico(7);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}


   
    	public ArregloDinamico cargarDato() throws IOException 
        {
        
        	String csvFile = "data/SmallMoviesDetailsCleaned.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ";";
           

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] datos = line.split(cvsSplitBy);
                    String id = datos[0];
                    String genres = datos[1];
                    String imbd = datos[2];
                    String originalLang = datos[3];
                    String originalTitle = datos[4];
                    String overview = datos[5];
                    String popularity = datos[6];
                    String proCompanies = datos[7];
                    String proCountries = datos[8];
                    String releaseDate = datos[9];
                    String revenue = datos[10];
                    String runtime = datos[11];
                    String spokenLanguages = datos[12];
                    String status = datos[13];
                    String tagline = datos[14];
                    String title = datos[15];
                    String voteAverage = datos[16];
                    String voteCount = datos[17];
                    String proCompaniesNumber = datos[18];
                    String proCompaniesCountryNumber = datos[19];
                    String spokenLanguagesNumber = datos[20];
                 
                     Pelicula actual = new Pelicula (id,genres,imbd,originalLang, originalTitle,overview,popularity,proCompanies,
                    		proCountries,releaseDate,revenue,runtime,spokenLanguages,status,tagline,title,voteAverage,voteCount,
                    		proCompaniesNumber,proCompaniesCountryNumber,spokenLanguagesNumber);
                 
                    
                    
                    System.out.println(datos[1]);
                    

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
        	return null;
        }
    

}
