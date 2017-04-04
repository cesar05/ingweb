package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void obtener() {
		ClienteDAO clienteDAO;
		List<Cliente> clientes=new ArrayList<Cliente>();
		try{
			clienteDAO=new ClienteDAOImpl();
			clientes=clienteDAO.obtener();
			assertTrue(clientes.size()>0);
			//assertTrue(true);
		}
		catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	/*
	@Test
	public void guardar(){
		ClienteDAO clienteDAO=null;
		Cliente cliente=new Cliente();
		try{
			clienteDAO=new ClienteDAOImpl();
			cliente.setCedula("1046");
			cliente.setApellidos("Muñoz Roldan");
			cliente.setNombres("César");
			cliente.setFechaCreacion(new Date());
			cliente.setFechaEliminacion(new Date());
			cliente.setFechaModificacion(new Date());
			cliente.setEmail("cesar@gmail.com");
			cliente.setUsuarioCrea(new UsuarioDAOImp().obtener("juan"));
			
			clienteDAO.insertar(cliente);
			assertTrue(true);
		}
		catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());			
		}
		
	}*/

}
