package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import exception.MyException;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;

public class ClienteBL {
	
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	
	public List<Cliente> obtener()throws MyException{
		return clienteDAO.obtener(); 
	}
	
	public boolean guardar(String cedula,String nombre,String apellidos,
			String email,String usuarioCrea)throws MyException{

		//Validando los datos para garantizar que no sean nulos o vacios 
		if(cedula==null || "".equals(cedula)){
			throw new MyException("La cédula no puede estar vacia");
		}
		else if(nombre==null || "".equals(nombre)){
			throw new MyException("El nombre no puede estar vacia");
		}
		else if(apellidos==null || "".equals(apellidos)){
			throw new MyException("El apellido no puede estar vacia");
		}
		else if(email==null || "".equals(email)){
			throw new MyException("El email no puede estar vacia");
		}
		else if(usuarioCrea==null || "".equals(usuarioCrea)){
			throw new MyException("El usuario que creo el nuevo usuario no puede estar vacio");
		}
		
		Usuario usuario=usuarioDAO.obtener(usuarioCrea);
		if(usuario==null){
			throw new MyException("El usuario que crea no existe");
		}
		
		Cliente cliente=new Cliente();
		cliente.setNombres(nombre);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		clienteDAO.insertar(cliente);
		
		return clienteDAO.insertar(cliente); 
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}	
		
}
