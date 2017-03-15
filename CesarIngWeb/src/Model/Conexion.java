package Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * @author = César Muñoz Roldan
 */

import java.sql.SQLException;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImp;
import co.edu.udea.iw.dto.Ciudad;
/*
 * Esta clase realiza la conexion a la base de datos y permite realizar consultas e imprimir el resultado
 */
public class Conexion {
	//Variable que controla la conexion
	public Connection conexion=null;
	//Variable que prepara la conexion
	public PreparedStatement ps=null;
	//Variable que contiene el resultado de la utlima consulta realizada 
	public ResultSet rs=null;
	
	//Establece la conexion con la base de datos
	public Conexion(){		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcesar","root","");						
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException = "+e.getMessage());
		}
		catch(SQLException e){
			System.out.println("SQLException = "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Exception = "+e.getMessage());
		}
	}
	//Ejecuta el query que se envia por parametro 
	public void consultar(String sql){
		try{
			if(this.conexion==null)
				throw new Exception("Error en la conexion");
			
			this.ps=this.conexion.prepareStatement(sql);
			this.rs=ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("Exception = "+e.getMessage());
		}
	}
	//Imprime el resultado del ultimo query ejecutado
	public void imprimir(){
		try{
			if(this.rs==null)
				throw new Exception("Error de Result Set");
				
			while(this.rs.next()){
				System.out.println(rs.getString("codigo")+"\t:\t"+rs.getString("Nombre"));
			}
		}
		catch(Exception e){
			System.out.println("Exception = "+e.getMessage());
		}
	}
	
	public static void main(String[] args){
		Conexion co=new Conexion();
		co.consultar("select * from ciudades");
		co.imprimir();
		co=null;		
	}
	
}
