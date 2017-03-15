package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public class DataSource {
	//variable que permite la conexion a la BD
	public static Connection con=null;
	
	private DataSource() throws MyException{
		
		try{
			//Se indica el driver a utilizar
			Class.forName("com.mysql.jdbc.Driver");
			//se indica datos para login a la base de datos
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcesar","root",""); 
		}			
		catch(ClassNotFoundException e){
			throw new MyException("No fue posible la conexion",e);
		}
		catch(SQLException e){
			throw new MyException("No fue posible la conexion",e);
		}	
		
	}
	
	public static Connection getConnection() throws MyException{
		try{
			//se valida que no haya una instancia ya creada para la conexion
			if(con==null || con.isClosed()){
				//se crear instancia
				new DataSource();
			}
									
		}		
		catch(SQLException e){
			throw new MyException("No se puede establecer conexion");
		}
		catch (Exception e) {
			throw new MyException("Driver no encontrados");
		}
		//retornamos la conexion
		return con;
	}
}
