package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import exception.MyException;

public class CiudadDAOImp implements CiudadDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//metodo que devuelve todas las ciudades registradas en el base de datos 
	@Override
	public List<Ciudad> obtener() throws MyException {
		List <Ciudad> lista=new ArrayList<Ciudad>();
		Session session=null;
		try{
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);
			lista=criteria.list();
		}
		catch (HibernateException e){
			throw new MyException("Error consultando ciudades",e);
		}
		return lista;
	}
	//metodo que obtiene los datos de una ciudad 
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		Ciudad ciudad=null;
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);
			
			//Opcion 1: Utilizando la condicion requerida
			//criteria.add(Restrictions.eq("codigo",codigo));
			//ciudad=(Ciudad)(criteria.uniqueResult());
			
			//Opcion 2: Compara 
			ciudad=(Ciudad)session.get(Ciudad.class,codigo);
		}
		catch (HibernateException e) {
			throw new MyException("Error consultando la ciudad",e);
		}
		return ciudad;
	}
	//Metodo que guarda una ciudad en la base de datos
	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD		
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);			
			session.save(ciudad);			
		}
		catch (HibernateException e) {
			throw new MyException("Error insertando la ciudad",e);
		}		
	}
	//Metodo que actualiza una ciudad
	@Override
	public void actualizar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD		
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);			
			session.update(ciudad);			
		}
		catch (HibernateException e) {
			throw new MyException("Error actualizando la ciudad",e);
		}		
	}

	//Metodo que elimina una ciudad
	@Override
	public void delete(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD		
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);			
			session.delete(ciudad);			
		}
		catch (HibernateException e) {
			throw new MyException("Error eliminando la ciudad",e);
		}
		
	}

	@Override
	public void insertaroactualizar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD		
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Ciudad.class);			
			session.saveOrUpdate(ciudad);		
		}
		catch (HibernateException e) {
			throw new MyException("Error insertando o actualizando la ciudad",e);
		}		
	}	

}
