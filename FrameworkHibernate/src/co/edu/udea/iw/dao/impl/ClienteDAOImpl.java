package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Cliente;
import exception.MyException;

public class ClienteDAOImpl implements ClienteDAO{

	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes=new ArrayList<Cliente>();
		Session session=null;
		Criteria criteria=null;
		try{
			session =DataSource.getConnection().getSession();
			criteria =session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes=criteria.list();
		}
		catch(HibernateException e){
			throw new MyException("Error consultando clientes",e);
		}
		
		return clientes;
	}

	@Override
	public void insertar(Cliente cliente) throws MyException {
		Session session=null;
		Criteria criteria=null;
		Transaction tx=null;
		try{
			session 	=DataSource.getConnection().getSession();
			criteria	=session.createCriteria(ClienteDAO.class);
			tx			=session.beginTransaction();
			session.save(cliente);
			tx.commit();			
		}
		catch(HibernateException e){
			throw new MyException("Error insertando cliente",e);			
		}
	}

}
