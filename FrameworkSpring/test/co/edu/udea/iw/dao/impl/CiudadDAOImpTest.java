package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.imp.CiudadDAOImp;
import co.edu.udea.iw.dto.Ciudad;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//para decirle a spring donde esta el archivo de configuracion
@ContextConfiguration(locations="classpath:confSpring.xml") // "classPath:confSpring.xml")
public class CiudadDAOImpTest {	
	
	//Inyecta el bean del archivo de confiracion en la variable
	@Autowired
	CiudadDAO ciudadDAO;
	
	@Test
	public void testObtener() {
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		
 		List<Ciudad> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			//this.ciudadDAO = new CiudadDAOImp();
 			lista = this.ciudadDAO.obtener();
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() > 0);
 			//assertTrue(true);
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}			
	}
	/*
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
	*/
}
