package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//Para decirle a spring donde esta el archivo de configuracion
@ContextConfiguration(locations="classpath:confSpring.xml") // "classPath:confSpring.xml")
public class UsuarioDAOImpTest {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Test
	public void testObtener() {
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		
 		List<Usuario> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			//this.ciudadDAO = new CiudadDAOImp();
 			lista = this.usuarioDAO.obtener();
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() > 0);
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}			
	}
}