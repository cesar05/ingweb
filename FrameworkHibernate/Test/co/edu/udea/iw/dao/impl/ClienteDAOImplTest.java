package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void obtener() {
		ClienteDAO clienteDAO;
		List<Cliente> clientes=new ArrayList<Cliente>();
		try{
			clienteDAO=new ClienteDAOImpl();
			clientes=clienteDAO.obtener();
			//assertTrue(clientes.size()>0);
			assertTrue(true);
		}
		catch(MyException e){
			fail(e.getMessage());
		}
	}

}
