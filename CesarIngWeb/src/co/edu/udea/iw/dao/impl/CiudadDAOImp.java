package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public class CiudadDAOImp implements CiudadDAO{
	
	//Metodo para obtener las ciudades	
	@Override
	public List<Ciudad> obtener() throws MyException {
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		List<Ciudad> lista=new ArrayList<Ciudad>();
		try{
			con=DataSource.getConnection();
			ps=con.prepareStatement("select * from ciudades");
			rs=ps.executeQuery();
			while(rs.next()){
				Ciudad ciudad=new Ciudad(
						Integer.parseInt((rs.getString("codigo"))),
						rs.getString("nombre"),
						rs.getString("codigoArea"));
				/*
				ciudad.setCodigo(Integer.parseInt((rs.getString("codigo"))));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				*/
				lista.add(ciudad);
			}
		}
		catch (SQLException e) {
			throw new MyException("Error consultando",e);
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e){
				throw new MyException("Error cerrando",e);
			}			
		}
		return lista;
	}
	
	// Implementacion del metodo que me obtiene la ciudad con el codigo especificado en los parametros
	@Override
	public Ciudad obtener(Long codigo) throws MyException{
		Connection con = null;
	 	PreparedStatement ps = null;
	 	ResultSet rs = null;
	 	Ciudad ciudad=null;
 		try{
 			
 			con=DataSource.getConnection();
 			//El signo de interrogacion que hay al final de la consulta sera reemplazado por un parametro
 			//que sera escapeado antes de concatenarlo a la consulta para evitar inyeccion de codigo
 			ps = con.prepareStatement("select * from ciudades where codigo = ?;");
 			//pasamos variable a la consulta
 			ps.setLong(1,codigo);
 			//ejecutamos la consulta
 			rs=ps.executeQuery();
 			if(rs.next()){
 				//creamos el objeto ciudad con los datos obtenidos
 				ciudad=new Ciudad(
						Integer.parseInt((rs.getString("codigo"))),
						rs.getString("nombre"),
						rs.getString("codigoArea"));			
 			} 			
 		}
 		catch (SQLException e)
 		{
 			throw new MyException("Error consultando", e);
 		}
 		//cerramos todas la conexiones abiertas
 		finally
 		{
 			try
 			{ 				
 				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
 			} 			
 			catch (SQLException e)
 			{
 				throw new MyException("Error cerrando", e);
 			}
 		}
 		
		return ciudad;
	}
	

}
