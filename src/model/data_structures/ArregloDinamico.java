package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {


	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private String elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( String dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			String [ ] copia = elementos;
			elementos = new String[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public String darElemento(int i) {

		String respuesta = "";
		respuesta+=elementos[i];
		return respuesta;
	}

	public String buscar(String dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String respuesta="el dato a buscar no existe dentro del arreglo dinamico";
		int i =0;
		boolean centinel = false;
		while(i<tamanoAct && !centinel)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				respuesta= elementos[i]+"el dato se encuentra en la posicion"+i;
				centinel=true;
			}
			i++;
		}
		return respuesta;

	}

	public String eliminar(String dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String buscado="el elemento a eliminar no existe en este arreglo dinamico";
		int i =0;
		boolean centinel = false;
		while(i<tamanoAct && !centinel)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				buscado= elementos[i];
				centinel=true;
				
			}
			i++;
		}
		while(i<tamanoAct)
		{
			elementos[i-1]=elementos[i];
			i++;
		}
		tamanoAct--;
		return buscado;
	}
	
	public String toString()
	{
		String respuesta ="";
		int i=0;
		while(i<tamanoAct)
		{
			respuesta+=elementos[i]+"\n";
			i++;
		}
		return respuesta;
	}

}
