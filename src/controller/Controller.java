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
					Scanner lector1 = new Scanner(System.in);
					String directorDeseado = lector1.nextLine();
					view.printMessage(modelo.cantidadBuenasPeliculas(directorDeseado));				
					break;

				case 3: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
					
				case 4: 
					view.printMessage("--------- \n Ingresa el nombre del director deseado: \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
				case 5: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
				case 6: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
				case 7: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
				case 8: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					System.exit(0);
					break;
					
				case 9: 
					view.printMessage(modelo.toStringPeli());
					break;
					
				
				
					
					

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
