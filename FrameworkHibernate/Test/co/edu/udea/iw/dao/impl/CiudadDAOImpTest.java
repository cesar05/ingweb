package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;

public class CiudadDAOImpTest {

	@Test
	public void testObtener() {
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		CiudadDAO ciudadDAO = null;
 		List<Ciudad> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			ciudadDAO = new CiudadDAOImp();
 			lista = ciudadDAO.obtener();
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() > 0);
 			//assertTrue(true);
 		}
 		catch(Exception e){
 			fail(e.getMessage());
 		}			
	}
	
	@Test
	public void testObtenerLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertaroactualizar() {
		fail("Not yet implemented");
	}
	
}
