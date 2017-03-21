package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import exception.MyException;

public class CiudadDAOImp implements CiudadDAO{

	@Override
	public List<Ciudad> obtener() throws MyException {
		List <Ciudad> lista=new ArrayList<Ciudad>();
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			lista=criteria.list();
		}
		catch (HibernateException e){
			throw new MyException("Error consultando ciudades",e);
		}
		return lista;
	}

	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		Ciudad ciudad=null;
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
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

	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD
		Transaction tx =null;
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			//Iniciar transaccional
			tx=session.beginTransaction();			
			//Enviar objeto a insertar en la BD
			session.save(ciudad);
			//Confirmar la transaccional
			tx.commit();
		}
		catch (HibernateException e) {
			throw new MyException("Error insertando la ciudad",e);
		}		
	}

	@Override
	public void actualizar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD
		Transaction tx =null;
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			//Iniciar transaccional
			tx=session.beginTransaction();			
			//Enviar objeto a actualizar en la BD
			session.update(ciudad);
			//Confirmar la transaccional
			tx.commit();
		}
		catch (HibernateException e) {
			throw new MyException("Error actualizando la ciudad",e);
		}		
	}

	@Override
	public void delete(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD
		Transaction tx =null;
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			//Iniciar transaccional
			tx=session.beginTransaction();			
			//Enviar objeto a actualizar en la BD
			session.delete(ciudad);
			//Confirmar la transaccional
			tx.commit();
		}
		catch (HibernateException e) {
			throw new MyException("Error eliminando la ciudad",e);
		}
		
	}

	@Override
	public void insertaroactualizar(Ciudad ciudad) throws MyException {
		//Abrir transaccion en la BD
		Transaction tx =null;
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			//Iniciar transaccional
			tx=session.beginTransaction();			
			//Enviar objeto a actualizar en la BD
			session.saveOrUpdate(ciudad);
			//Confirmar la transaccional
			tx.commit();
		}
		catch (HibernateException e) {
			throw new MyException("Error insertando o actualizando la ciudad",e);
		}		
	}	

}
