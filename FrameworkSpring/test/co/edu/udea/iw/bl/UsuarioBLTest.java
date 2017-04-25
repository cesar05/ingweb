package co.edu.udea.iw.bl;
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
public class UsuarioBLTest {
	@Autowired
	UsuarioBL usuarioBL;
		
	@Test
	public void testLogin(){
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
 		try{
			assertTrue(usuarioBL.login("elver","1g0/KkFdhrmg1DYJWFdd2A=="));
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}
	}
}
