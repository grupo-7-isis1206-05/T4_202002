package controller;

import java.io.IOException;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					
				try {
					modelo.cargarDato();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
					break;

				case 2:
					view.printMessage("--------- \nIngresar nombre del director deseado: ");
					
					dato = lector.next();
					
					view.printMessage("las peliculas con un promedio mayor o igual a 6 del director"+dato+"son:"+modelo.buenasPeliculas(dato));				
					break;

				
					
				case 3: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
