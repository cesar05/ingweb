package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public interface ClienteDAO {
	/*
	 * Obtiene la lista de clientes ordenados por su fecha de creacion
	 */
	public List<Cliente> obtener() throws MyException;
	public boolean insertar(Cliente cliente) throws MyException;
}
