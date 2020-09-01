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
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
		
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

	@Override
	public int darCapacidad() {
		// TODO Auto-generated method stub
		return tamanoMax;
	}

	@Override
	public int darTamano() {
		// TODO Auto-generated method stub
		return tamanoAct;

	}

	@Override
	public void agregar(T dato) {
		// TODO Auto-generated method stub
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;

	}

	@Override
	public T buscar(T dato) {
		// TODO Auto-generated method stub


		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T respuesta=null;
		int i =0;
		boolean centinel = false;
		while(i<tamanoAct && !centinel)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				respuesta= elementos[i];
				centinel=true;
			}
			i++;
		}
		return respuesta;


	}

	@Override
	public T eliminar(T dato) {
		// TODO Auto-generated method stub


		T buscado=null;
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






	@Override
	public T darElemento(int i) {
		 
		return elementos[i];
	}






	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}


