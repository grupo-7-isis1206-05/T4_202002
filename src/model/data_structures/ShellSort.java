package model.data_structures;

public class ShellSort {
	

	    
	    private ShellSort() { }

	 
	    public static void sort(Comparable[] a) {
	        int tamano = a.length;

	        
	        int compare = 1;
	        while (compare < tamano/3) compare = 3*compare + 1; 

	        while (compare >= 1) {
	         
	            for (int i = compare; i < tamano; i++) {
	                for (int j = i; j >= compare && menor(a[j], a[j-compare]); j -= compare) {
	                    cambiar(a, j, j-compare);
	                
	            }
	            }
	        }
	    }
	          
	        private static void cambiar(Object[] a, int i, int j) {
	            Object cambio = a[i];
	            a[i] = a[j];
	            a[j] = cambio;
	        }
	        
	        private static boolean menor(Comparable v, Comparable w) {
	            return v.compareTo(w) < 0;
	        }
}
