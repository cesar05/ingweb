package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import exception.MyException;

public class ClienteDAOImp implements ClienteDAO {
	
	//Variable que maneja la session a la base de datos
	private SessionFactory sessionFactory;
	
	//Metodo get de la variable session
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//Metodo set de la variable session
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//Metodo que devulve una lista de los clientes registrados en la base de datos
	@Override
	public List<Cliente> obtener() throws MyException {
		//Lista que contendra los clientes
		List <Cliente> lista=new ArrayList<Cliente>();
		Session session=null;
		try{
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Cliente.class);
			lista=criteria.list();
		}
		catch (HibernateException e){
			throw new MyException("Error consultando clientes",e);
		}
		return lista;
	}

	@Override
	public boolean insertar(Cliente cliente) throws MyException {
		//Abrir transaccion en la BD		
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Cliente.class);			
			session.save(cliente);
			return true;
		}
		catch (HibernateException e) {
			throw new MyException("Error insertando cliente",e);
		}
		
	}
	
}
