package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public class DataSource {
	//Permite la conexion a la BD
	public static DataSource instancia=null;
	
	//Permite establecer conexiones a la BD
	private SessionFactory factory=null;
	
	//Permite cargar el archivo de configuracion para Hibernate
	private Configuration conf=new Configuration();
	
	private DataSource(){
				
	}
	
	//Obtener la instancia de clase DataSource
	public static DataSource getConnection(){		
		//se valida que no haya una instancia ya creada para la conexion
		if(instancia==null){
			//se crear instancia
			instancia = new DataSource();
		
		}
		return instancia;
	}
	
	//Retorna una session(conexion) abierta a la base de datos
	public Session getSession()throws MyException{
		try{
			if(factory==null){
				conf.configure("hibernate.cfg.xml");
				factory=conf.buildSessionFactory();
			}
			return factory.openSession();
		}
		catch(HibernateException e){
			throw new MyException("Error configurando la session",e);		
		}
	}
}
