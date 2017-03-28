package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import exception.MyException;

public class UsuarioDAOImp implements UsuarioDAO {

	@Override
	public List<Usuario> obtener() throws MyException{
		List <Usuario> lista=new ArrayList<Usuario>();
		Session session=null;
		try{
			session=DataSource.getConnection().getSession();
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
			session=DataSource.getConnection().getSession();
			//Criteria criteria=session.createCriteria(Usuario.class);
			usuario=(Usuario)session.get(Usuario.class,login);			
		}
		catch (HibernateException e){
			throw new MyException("Error consultando usuarios",e);
		}
		finally{
			if(session!=null)session.close();
		}
		return usuario;
	}

	

}
