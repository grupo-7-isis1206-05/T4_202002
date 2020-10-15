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
			System.out.println("Bienvenido al explorador de accidentes automvilisticos de los estados unidos.");
		
			System.out.println("Por favor primero oprime la tecla 1 para cargar los datos.");
			System.out.println("1. Cargar datos");
			System.out.println("2. accidentes en una fecha dada");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo.toString());
			
		}
}
