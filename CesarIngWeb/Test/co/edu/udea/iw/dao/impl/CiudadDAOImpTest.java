package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;

public class CiudadDAOImpTest {

	//metodo para para probar que si devuelva registros cuando hay datos en la base de datos
	@Test
	public void testObtener() {		
		CiudadDAO ciudadDAO = null;
 		List<Ciudad> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			ciudadDAO = new CiudadDAOImp();
 			lista = ciudadDAO.obtener();
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() > 0);			
 		}
 		catch(Exception e){
 			fail(e.getMessage());
 		}
		
	}
	//metodo para para probar que si devuelva la ciudad con el codigo enviado por parametro
	@Test
	public void testObtenerCiudad(){
		CiudadDAO ciudadDAO = null;
 		List<Ciudad> lista = null;
 		Ciudad ciudad=null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			ciudadDAO = new CiudadDAOImp();
 			ciudad = ciudadDAO.obtener(new Long(1));
 			//en caso de que la ciudad sea diferente de null confirmamos la prueba
			assertTrue(ciudad!=null);			
 		}
 		catch(Exception e){
 			fail(e.getMessage());
 		}
	}

}
