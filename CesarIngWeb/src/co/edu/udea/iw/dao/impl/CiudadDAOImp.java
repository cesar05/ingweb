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
				Ciudad ciudad=new Ciudad();
				ciudad.setCodigo(Integer.parseInt((rs.getString("codigo"))));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
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

}
