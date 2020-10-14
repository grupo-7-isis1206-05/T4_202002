package model.data_structures;

import sun.misc.Queue;

public class BST <Key extends Comparable<Key>, Value>{

	private Nodo primerElemento;      

	private class  Nodo   { 

		private Key key;          
		private Value valor;         
		private Nodo nIzquierda, nDerecha;    
		private int numeroElementos;               
		public Nodo(Key key, Value pValor, int numeroElementos)     
		{ 
			this.key = key; this.valor = pValor; this.numeroElementos = numeroElementos; 
		} 

	} 

	public int size()  {

		return size(primerElemento); 
	}  

	private int size(Nodo pNodo) {    

		if (pNodo == null)
		{
			return 0; 
		}	  
		else 
		{
			return pNodo.numeroElementos; 
		}

	}

	public  Value get(Key key) {  

		return get(primerElemento, key); 

	}

	private Value get(Nodo pNodo, Key key) {  

		if (pNodo == null) 
		{
			return null;  
		}

		int rComparacion = key.compareTo(pNodo.key);  

		if (rComparacion < 0) 
		{
			return get(pNodo.nIzquierda, key);  
		}
		else if (rComparacion > 0) 
		{
			return get(pNodo.nDerecha, key);  
		}
		else
		{
			return pNodo.valor; 
		}

	} 

	public void put(Key key, Value pValor){  

		primerElemento = put(primerElemento, key, pValor); 

	} 

	private Nodo put(Nodo pNodo, Key key, Value pValor) {  

		if (pNodo == null) 
		{
			return new Nodo(key, pValor, 1); 
		}

		int cmp = key.compareTo(pNodo.key); 

		if (cmp < 0) 
		{
			pNodo.nIzquierda  = put(pNodo.nIzquierda,  key, pValor);  
		}
		else if(cmp > 0) 
		{
			pNodo.nDerecha = put(pNodo.nDerecha, key, pValor); 
		}
		else
		{
			pNodo.valor = pValor;  
		}

		pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1; 
		return pNodo;

	}

	public Key min() {    

		return min(primerElemento).key; 

	} 

	private Nodo min(Nodo x) {  

		if (x.nIzquierda == null) 
		{
			return x;  
		}
		return min(x.nIzquierda);

	} 

	public Key floor(Key key) {     

		Nodo x = floor(primerElemento, key);  
		if (x == null) 
		{
			return null;   
		}
		return x.key; 

	} 

	private Nodo floor(Nodo pNodo, Key key){  

		if (pNodo == null) 
		{
			return null;  
		}

		int rComparacion = key.compareTo(pNodo.key);   
		if (rComparacion == 0) 
		{
			return pNodo;   
		}
		if (rComparacion < 0) 
		{
			return floor(pNodo.nIzquierda, key);   
		}

		Nodo nTemporal = floor(pNodo.nDerecha, key);  
		if (nTemporal != null) 
		{
			return nTemporal;  
		}
		else  
		{
			return pNodo; 
		}

	}

	public Key select(int posKey) {     

		return select(primerElemento, posKey).key; 

	} 

	private Nodo select(Nodo pNodo, int posKey) {  

		if (pNodo == null)
		{
			return null;    
		}

		int posTemporal = size(pNodo.nIzquierda);   
		if(posTemporal > posKey) 
		{
			return select(pNodo.nIzquierda,  posKey);  
		}
		else if (posTemporal < posKey) 
		{
			return select(pNodo.nDerecha, posKey-posTemporal-1);  
		}
		else 
		{
			return pNodo; 
		}

	} 

	public int rank(Key key){  

		return rank(key, primerElemento); 

	}

	private int rank(Key key, Nodo pNodo) {  

		if (pNodo == null) 
		{
			return 0;   
		}
		
		int cmp = key.compareTo(pNodo.key);   
		if (cmp < 0) 
		{
			return rank(key, pNodo.nIzquierda); 
		}
		else if (cmp > 0) 
		{
			return 1 + size(pNodo.nIzquierda) + rank(key, pNodo.nDerecha);  
		}
		else 
		{
			return size(pNodo.nIzquierda); 
		}

	}

	public void deleteMin(){    

		primerElemento = deleteMin(primerElemento); 

	} 

	private Nodo deleteMin(Nodo pNodo) {  

		if (pNodo.nIzquierda == null) 
		{
			return pNodo.nDerecha; 
		}
		
		pNodo.nIzquierda = deleteMin(pNodo.nIzquierda);  
		pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1; 
		return pNodo; 

	} 

	public void delete(Key key) { 

		primerElemento = delete(primerElemento, key); 

	} 

	private Nodo delete(Nodo pNodo, Key key){   

		if (pNodo == null) 
		{
			return null;   
		}
		
		int rComparacion = key.compareTo(pNodo.key);  
		if(rComparacion < 0) 
		{
			pNodo.nIzquierda  = delete(pNodo.nIzquierda,  key);  
		}
		else if (rComparacion > 0) 
		{
			pNodo.nDerecha = delete(pNodo.nDerecha, key); 
		}
		else    
		{   
			if (pNodo.nDerecha == null) 
			{
				return pNodo.nIzquierda;  
			}
			if (pNodo.nIzquierda == null)
			{
				return pNodo.nDerecha;     
			}
			Nodo nTemporal = pNodo;  
			pNodo = min(nTemporal.nDerecha); 
			pNodo.nDerecha = deleteMin(nTemporal.nDerecha);   
			pNodo.nIzquierda = nTemporal.nIzquierda;   
		} 
		
		pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1;
		return pNodo; 
	}

	public Iterable<Key> keys(){ 

		return keys(min(), max());  

	} 

	public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
	
	private Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Key> keys(Key lo, Key hi){    

		Queue<Key> queue = new Queue<Key>();  
		keys(primerElemento, queue, lo, hi);  
		return (Iterable<Key>) queue; 

	} 

	private void keys(Nodo pNodo, Queue<Key> queue, Key lo, Key hi){  

		if (pNodo == null) 
		{
			return; 
		}
		
		int cmplo = lo.compareTo(pNodo.key); 
		int cmphi = hi.compareTo(pNodo.key);  
		if (cmplo < 0) 
		{
			keys(pNodo.nIzquierda, queue, lo, hi);  
		}
		if (cmplo <= 0 && cmphi >= 0)
{
			queue.enqueue(pNodo.key);  
		}
		if (cmphi > 0) 
		{
			keys(pNodo.nDerecha, queue, lo, hi);
		}

	}

}