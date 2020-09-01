package model.data_structures;

public interface IListaEncadenada <T> {
	
	public void addFirst(T element);
	
	public void addLast(T element);
	
	public void insert (T element, int posicion);
	
	public T removeFist();
	
	public T removeLast();
	
	public T deleteElement(int posicion);
	
	public T firstElement();
	
	public T lastElement();
	
	public T element(int posicion);
	
	int size ();
	
	public boolean isEmpty();
	
	int isPresent(T element);
	
	public void exchange (int posicion1, int posicion2);
	
	public void changeInfo (T info, int posicion);
	
}
