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
				view.printMessage("se cargaron "+modelo.darPeliculas().darTamano()+" peliculas");
				view.printMessage("la primera pelicula cargada es: "+modelo.darPeliculas().darPrimer().toString()+"\n");
				view.printMessage("la ultima pelicula cargada es: "+modelo.darPeliculas().darUlt().toString()+"\n");
				
				
					break;

				case 2:
					view.printMessage("--------- \nIngresar nombre del director deseado: ");
					Scanner lector1 = new Scanner(System.in);
					String directorDeseado = lector1.nextLine();
					view.printMessage(modelo.cantidadBuenasPeliculas(directorDeseado));				
					break;

				case 3: 
					Scanner algo = new Scanner(System.in);
					view.printMessage("inserte un numero mayor o igual a 10 para crear el ranking");
					int tamaño = Integer.parseInt(algo.nextLine())+1;
					if(tamaño-1>=10)
					{
						view.printMessage("ingrese el numero 1 si desea que el ranking se cree por votacion promedio, o ingrese el numero 2 si decea que el ranking sea creado por cantidad de votos");
						int atributo = Integer.parseInt(algo.nextLine());
						view.printMessage("ingrese el numero 1 si desea que el ranking sea ascendente, o el numero 2 si desea que el ranking sea descendente");
						int ordenacion = Integer.parseInt(algo.nextLine());
						view.printMessage(modelo.Ranking(tamaño, atributo, ordenacion));	
					}
					else
					{
						view.printMessage("el numero debe ser mayor a 10");
					}
					break;
				case 4: 
					view.printMessage("--------- \nIngresar nombre del director deseado: ");
					Scanner lector2 = new Scanner(System.in);
					String directorDeseado2 = lector2.nextLine();
					view.printMessage(modelo.conocerDirector(directorDeseado2));				
					break;
				case 5: 
					Scanner lector4 = new Scanner(System.in);
					view.printMessage("ingrese el nombre del actor que desea conocer");
					String algo2= lector4.nextLine();
					view.printMessage(modelo.conocerActor(algo2));
					break;
				
				case 6: 
					view.printMessage("--------- \nIngresar el genero de interes: ");
					Scanner lector3 = new Scanner(System.in);
					String generoDeseado = lector3.nextLine();
					view.printMessage(modelo.entenderGenero(generoDeseado));				
					break;
				case 7: 
					Scanner segundoR = new Scanner(System.in);
					view.printMessage("inserte un numero mayor o igual a 10 para crear el ranking");
					int tamaño2 = Integer.parseInt(segundoR.nextLine())+1;
					if(tamaño2-1>=10)
					{
						view.printMessage("ingrese el numero 1 si desea que el ranking se cree por votacion promedio, o ingrese el numero 2 si decea que el ranking sea creado por cantidad de votos");
						int atributo2 = Integer.parseInt(segundoR.nextLine());
						view.printMessage("ingrese el numero 1 si desea que el ranking sea ascendente, o el numero 2 si desea que el ranking sea descendente");
						int ordenacion2 = Integer.parseInt(segundoR.nextLine());
						view.printMessage("por ultimo, ingrese el genero del cual desea crear el ranking");
						String generoRa = segundoR.nextLine();
						view.printMessage(modelo.rankingGenero(tamaño2, atributo2, ordenacion2, generoRa));	
					}
					else
					{
						view.printMessage("el numero debe ser mayor a 10");
					}
					
					break;
				case 8: 
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
