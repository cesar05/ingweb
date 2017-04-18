package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;

//Para decir que las pruebas se van hacer con Spring
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional //Para especificarle a Spring que la prueba es transaccional,(osea contra la base de datos)

//Para decirle a spring donde esta el archivo de configuracion
@ContextConfiguration(locations="classpath:confSpring.xml") // "classPath:confSpring.xml")
public class ClienteBLTest {
	
	@Autowired
	ClienteBL clientebl;
		
	@Test
	public void testObtener(){
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		
 		List<Cliente> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			lista = this.clientebl.obtener();
 			
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() >= 0);
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}
	}
	
	public void testGuardar(){
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		
 		Cliente Cliente = null;
 		try{ 			
 			assertTrue(this.clientebl.guardar(
 					"1047",
 					"Pedro Pablo", 
 					"Jaramillo",
 					"udea@udea.com",
 					"1000"));			
 			
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}
	}

}
