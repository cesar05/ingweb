package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;

public class UsuarioDAOImpTest {

	@Test
	public void testObtener() {
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		UsuarioDAO usuarioDAO = null;
 		List<Usuario> lista = null;
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			usuarioDAO = new UsuarioDAOImp();
 			lista = usuarioDAO.obtener();
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(lista.size() > 0); 			
 		}
 		catch(Exception e){
 			fail(e.getMessage());
 		}
	}
	
	@Test
	public void testObtenerUsuario() {
		//metodo para para probar que si devuelva registros cuando hay datos en la base de datos				
		UsuarioDAO usuarioDAO=null;
		Usuario usuario=null; 		
 		try{
 			//instanciamos la clase que implementa el metodo para obtener los registros
 			usuarioDAO = new UsuarioDAOImp();
 			usuario = usuarioDAO.obtener("juan");
 			if(usuario!=null){
 				System.out.println("Nombre Usuario="+usuario.getNombre());
 				System.out.println("Nombre Rol="+usuario.getRol().getNombre()+" Codigo ="+usuario.getRol().getCodigo());
 			}
 			//en caso de que haya mas de un registro confirmamos la prueba
			assertTrue(usuario!=null); 			
 		}
 		catch(Exception e){
 			e.printStackTrace();
 			fail(e.getMessage());
 		}
	}

}
