package model.data_structures;
import java.lang.Comparable;

public class Nodo<T> implements Comparable<T>{
	
	private T datos;
	private Nodo siguiente;
	private int posicion;
	private Nodo anterior;
	
	public Nodo (T Pdatos, Nodo Psiguiente, Nodo Panterior, int Pposicion){
		datos=Pdatos;
		this.siguiente=Psiguiente;
		this.anterior=Panterior;
		posicion = Pposicion;
		
	}
	
	public void cambiarPosicion(int Pposicion)
	{
		posicion=Pposicion;
	}
	public T darFeatures()
	{
		return datos;
	}
	
	public Nodo darSiguiente()
	{
		return siguiente;
	}
	public void cambiarSiguiente(Nodo Siguiente)
	{
		siguiente= Siguiente;
	}
	public Nodo darAnterior()
	{
		return anterior;
	}
	
	public void cambiarAnterior(Nodo Anterior)
	{
		anterior=Anterior;
	}
	public int darPosicion ()
	{
		return posicion;
	}
	public void changeInfo(T info)
	{
		datos=info;
	}
	
	public String toString()
	{
		return ""+datos;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}

	
	
	

}
