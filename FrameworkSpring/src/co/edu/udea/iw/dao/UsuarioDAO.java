package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import exception.MyException;

public interface UsuarioDAO {
	public List<Usuario> obtener() throws MyException;
	public Usuario obtener(String login) throws MyException;
}
