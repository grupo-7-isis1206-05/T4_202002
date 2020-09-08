package test.data_structures;

import model.data_structures.ArregloDinamico;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=20;

	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
		for(int i =0; i< TAMANO; i++){
			arreglo.agregar(i);
		}
	}


	@Test
	public void testArregloDinamico() 
	{
		setUp1();
		assertNotNull("se deberia haber creado un arreglo de tamaño"+TAMANO, arreglo);


		// TODO
	}

	@Test
	public void testDarElemento() {


		setUp1();

		assertEquals("el numero esperado, no fue devuelto", 1, arreglo.darElemento(1));


		// TODO
	}
	@Test
	public void testBuscar() {
		// TODO implementar
		setUp1();
		int aBuscar = 15;
		assertEquals("el numero esperado, no fue devuelto", 15, arreglo.buscar(aBuscar));


	}
	@Test
	public void testEliminar() {
		// TODO implementar
		setUp1();
		assertEquals("no se eliminó el numero esperado",8, arreglo.eliminar(8));
		assertFalse("el numero no fue eliminado", arreglo.contiene(8));

	}
	
	
}  
