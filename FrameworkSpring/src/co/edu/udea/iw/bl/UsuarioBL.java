package co.edu.udea.iw.bl;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import exception.MyException;

/*
 * author: César Muñoz Roldan
 */
public class UsuarioBL {
	
	//Variable que nos permite consultar el usuario dado el login en la base de datos
	private UsuarioDAO usuarioDAO;
	//Variable que nos permite manipular los objetos tipo Usuario
	private Usuario usuario;
	
	/*Método que nos permite validar el login y el password del usuario dado, en caso de que la validacion sea 
	 *correcta el metodo retorna true en caso contrario false*/
	
	public boolean login(String login,String pass)throws MyException{
		//Obtener el usuario segun el login
		usuario=usuarioDAO.obtener(login);
		//Valido que el usuario exista efectivamente
		if(usuario!=null){
			/*En caso de que el pass enviado como parametro sea igual al password del usuario 
			 * que retorno la base de datos la comaparacion devuelve true en caso contrario false*/			 
			return usuario.getContrasena().equals(pass);				
		}
		//Retorno null en caso de que el usuario no exista
		return false;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
