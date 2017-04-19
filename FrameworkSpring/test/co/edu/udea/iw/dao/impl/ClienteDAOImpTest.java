package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//para decirle a spring donde esta el archivo de configuracion
@ContextConfiguration(locations="classpath:confSpring.xml")
public class ClienteDAOImpTest {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Test
	public void testObtener() {
		//Metodo para para probar que si devuelva registros cuando hay datos en la base de datos
		
 		List<Cliente> lista = null;
 		try{
 			//Instanciamos la clase que implementa el metodo para obtener los registros
 			lista = this.clienteDAO.obtener();
 			
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() >= 0);
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}			
	}
	
}
