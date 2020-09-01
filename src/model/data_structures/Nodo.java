package model.data_structures;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {
	
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

	@Override
	public int compareTo(Nodo<T> o) {
		// TODO Auto-generated method stub
		return this.datos.compareTo(o.datos);
	}
	
	
	

}
