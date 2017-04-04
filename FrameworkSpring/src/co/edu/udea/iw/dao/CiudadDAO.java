package co.edu.udea.iw.dao;


import java.util.List;
import co.edu.udea.iw.dto.Ciudad;
import exception.MyException;
/*
 * author: César Muñoz Roldan
 */
public interface CiudadDAO {
	//Entrega la lista de las ciudades
	public List<Ciudad> obtener() throws MyException;
	public Ciudad obtener(Long codigo) throws MyException;
	public void guardar(Ciudad ciudad) throws MyException;
	public void actualizar(Ciudad ciudad) throws MyException;
	public void delete(Ciudad ciudad) throws MyException;
	public void insertaroactualizar(Ciudad ciudad) throws MyException;
}