package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import exception.MyException;

public class UsuarioDAOImp implements UsuarioDAO {
private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Usuario> obtener() throws MyException {
		List <Usuario> lista=new ArrayList<Usuario>();
		Session session=null;
		try{
			//session=DataSource.getConnection().getSession();
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Usuario.class);
			lista=criteria.list();
		}
		catch (HibernateException e){
			throw new MyException("Error consultando usuarios",e);
		}
		return lista;
	}

	@Override
	public Usuario obtener(String login) throws MyException {
		
		Usuario usuario=null;
		Session session=null;
		try{			
			session=sessionFactory.getCurrentSession(); 
			Criteria criteria=session.createCriteria(Cliente.class);			
			usuario=(Usuario)session.get(Usuario.class,login);
		}
		catch (HibernateException e) {
			e.printStackTrace();
			throw new MyException("Error consultando el usuario",e);
		}
		return usuario;
	}
	
}
