package test.data_structures;

import model.data_structures.ArregloDinamico;
import uniandes.cupi2.centralPacientes.mundo.Paciente;
import uniandes.cupi2.contactos.mundo.Contacto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;

	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	@Test
	public void testArregloDinamico() 
	{
		setUp1();
		assertNull( arreglo.darCapacidad() );

		// TODO
	}

	@Test
	public void testDarElemento() {


		setUp2();
		arreglo.darElemento(0);

		assertNotNull( "No se encontró el Elemento" );

		// TODO
	}
	public void testBuscar(String dato) {
		// TODO implementar
		String c = arreglo.buscar(dato);
		assertNotNull( c );
	
	}
	public void testEliminar(String dato) {
		// TODO implementar
		 arreglo.eliminar(dato);
			assertNotNull( "Se elimino el elemento con parametro " );

	}
}  
