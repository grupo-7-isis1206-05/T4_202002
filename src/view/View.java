package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("Bienvenido al explorador de la magia del cine.");
			System.out.println("A continuacion encontraras el menu con todas las opciones que este explorador te ofrece.");
			System.out.println("Por favor primero oprime la tecla 1 para cargar los datos.");
			System.out.println("1. Cargar datos");
			System.out.println("2. Encontrar buenas peliculas de un director dado");
			System.out.println("3. Crear ranking de peliculas");
			System.out.println("4. Conoce el trabajo de un director");
			System.out.println("5. Conoce el trabajo de un actor");
			System.out.println("6. Entiende acerca de las caracteristicas de un genero de peliculas");
			System.out.println("7. Crea un ranking de genero");
			System.out.println("8. Salir");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo.toString());
			
		}
}
