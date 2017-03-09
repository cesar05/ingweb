package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public class DataSource {
	
	public static Connection con=null;
	
	public static Connection getConnection() throws MyException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcesar","root","root");						
		}
		catch(ClassNotFoundException e){			
			throw new MyException("Driver no encontrados");
		}
		catch(SQLException e){
			throw new MyException("No se puede establecer conexion");
		}
		catch (Exception e) {
			throw new MyException("Driver no encontrados");
		}
		return con;
	}
}
