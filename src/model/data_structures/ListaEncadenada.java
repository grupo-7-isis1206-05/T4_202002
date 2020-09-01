package model.data_structures;

import com.sun.javafx.collections.ElementObservableListDecorator;

public class ListaEncadenada<T> implements IListaEncadenada<Nodo>{


	private Nodo primero;
	private Nodo ultimo;
	private int tamano;

	public ListaEncadenada()
	{
		primero=null;
		ultimo=null;
		tamano=0;
	}

	public void addFirst(Nodo element) {
		// TODO Auto-generated method stub
		if (tamano==0)
		{
			primero=element;
			ultimo= element;
			tamano++;
		}
		else {
		Nodo salvar = primero;

		primero=element;

		

		element.cambiarSiguiente(salvar);
		salvar.cambiarAnterior(primero);
		int i =1;
		Nodo actual = primero;
		while (actual!=null)
		{
			actual.cambiarPosicion(i);
			i++;
			actual=actual.darSiguiente();
		}
		tamano++;
		}

	}

	@Override
	public void addLast(Nodo element) {
		// TODO Auto-generated method stub
		if(tamano==0)
		{
			primero=element;
			ultimo= element;
			tamano++;
		}
		else {
		ultimo.cambiarSiguiente(element);
		element.cambiarAnterior(ultimo);
		ultimo=element;
		tamano++;
		}
	}

	@Override
	public void insert(Nodo element, int posicion) {
		// TODO Auto-generated method stub
		Nodo actual=primero;
		element.cambiarPosicion(posicion);
		boolean agregado =false;
		while(actual!=null&&!agregado)
		{
			
			if (actual.darPosicion()==posicion-1)
			{
				element.cambiarSiguiente(actual.darSiguiente());
				element.cambiarAnterior(actual);
				actual.darSiguiente().cambiarAnterior(element);
				actual.cambiarSiguiente(element);
				element.darSiguiente().cambiarPosicion(posicion++);
				agregado=true;
			}
			actual=actual.darSiguiente();
		}
		tamano++;
	}

	@Override
	public Nodo removeFist() {
		// TODO Auto-generated method stub
		Nodo respuesta = primero;
		primero.darSiguiente().cambiarAnterior(null);
		primero=primero.darSiguiente();

		Nodo actual=primero;
		while(actual!=null)
		{
			actual.cambiarPosicion(actual.darPosicion()-1);
			actual=actual.darSiguiente();
		}
		tamano--;
		return respuesta;
	}

	@Override
	public Nodo removeLast() {
		// TODO Auto-generated method stub
		Nodo respuesta = ultimo;
		ultimo=ultimo.darAnterior();
		ultimo.cambiarSiguiente(null);
		tamano--;
		return ultimo;
	}

	@Override
	public Nodo deleteElement(int posicion) {
		// TODO Auto-generated method stub
		Nodo respuesta=null;
		if(posicion==1)
		{
			respuesta=removeFist();
		}
		else if(posicion==tamano)
		{
			respuesta=removeLast();
		}
		else {

			
			Nodo borrar = element(posicion);
			respuesta=borrar;
			borrar.darSiguiente().cambiarAnterior(null);
			borrar.darAnterior().cambiarSiguiente(null);

			
			tamano--;
		}
		
		return respuesta;

	}



	@Override
	public Nodo firstElement() {
		// TODO Auto-generated method stub
		return primero;
	}

	@Override
	public Nodo lastElement() {
		// TODO Auto-generated method stub
		return ultimo;
	}

	@Override
	public Nodo element(int posicion) {
		// TODO Auto-generated method stub
		int i=0;
		Nodo respuesta=null;
		Nodo actual=primero;
		while(actual!=null)
		{
			if(actual.darPosicion()==posicion)
			{
				respuesta=actual;
			}
			actual=actual.darSiguiente();
		}
		return respuesta;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tamano;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean respuesta = false;
		if (tamano==0)
		{
			respuesta=true;
		}
		return respuesta;

	}

	@Override
	public int isPresent(Nodo element) {
		// TODO Auto-generated method stub
		int respuesta =0;
		int i =0;
		while(i<=tamano)
		{
			Nodo actual= element(i);
			if(actual.compareTo(element)==0)
			{
				respuesta=actual.darPosicion();
			}
			i++;
		}
		return respuesta;

	}

	@Override
	public void exchange(int posicion1, int posicion2) {
		Nodo nodo1 = element(posicion1);
		Nodo nodo2 = element(posicion2);


		if(posicion1<posicion2)
		{

			nodo1.darAnterior().cambiarSiguiente(nodo2);
			nodo2.darAnterior().cambiarSiguiente(nodo1);
			nodo2.cambiarSiguiente(element(posicion1+1));
			nodo1.cambiarSiguiente(element(posicion2+1));
			nodo2.cambiarAnterior(element(posicion1-1));
			nodo1.cambiarAnterior(element(posicion2-1));
			element(posicion1+1).cambiarAnterior(nodo2);
			element(posicion2+1).cambiarAnterior(nodo1);


		}

	}
	@Override
	public void changeInfo(Nodo info, int posicion) {
		// TODO Auto-generated method stub

		element(posicion).changeInfo(info);
	}
	/**
	 * metodo para comprobar que no hay posiciones repetidas
	 * @return true si hay al menos dos nodos con numeros iguales en el atributo de posicion
	 */
	public boolean checkPosiciones()
	{	
		boolean respuesta = false;

		Nodo nodo1 = primero;
		Nodo nodo2 = primero.darSiguiente();
		while(nodo1!=null&&!respuesta)
		{
			while(nodo2!=null)
			{
				if(nodo1.darPosicion()==nodo2.darPosicion())
				{
					respuesta=true;
				}
				nodo2=nodo2.darSiguiente();
			}
			nodo1=nodo1.darSiguiente();
		}
		
		return respuesta;
	}

	public String posiciones()
	{
		String respuesta ="";
		Nodo actual=primero;
		while(actual!=null)
		{
			respuesta+=actual.darPosicion()+"\n";
			actual=actual.darSiguiente();

		}
		return respuesta;
	}
	
	public String toString()
	{
		String respuesta="";
		Nodo actual=primero;
		while(actual!=null)
		{
			respuesta+=actual.toString()+"\n";
			actual=actual.darSiguiente();
		}
		
		return respuesta;
	}
	
	public int existe(T algo)
	{
		int respuesta=0;
		Nodo actual=primero;
		while(actual != null)
		{
			if(actual.darDatos().equals(algo))
			{
				respuesta=actual.darPosicion();
			}
			actual=actual.darSiguiente();
		}
		
		return respuesta;
	}
	
	public String repetidos()
	{
		String respuesta = "";
		
		Nodo nodo1 = primero;
		Nodo nodo2 = primero.darSiguiente();
		while(nodo1!=null)
		{
			while(nodo2!=null)
			{
				if(nodo1.darPosicion()==nodo2.darPosicion())
				{
					respuesta += "\n";
				}
				nodo2=nodo2.darSiguiente();
			}
			nodo1=nodo1.darSiguiente();
		}
		return respuesta;
		
		
	}
}
