package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Ciudad;
/*
 * author: César Muñoz Roldan
 */
public interface CiudadDAO {
	//Entrega la lista de las ciudades
	public List<Ciudad> obtener() throws MyException;
	public Ciudad obtener(Long codigo) throws MyException;
}
