package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBL;
import exception.MyException;

@Path("usuarios")
@Component
public class UsuarioWS {
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login")String login,@QueryParam("password")String password){
		String retorno="";//login+"-"+password;
		//System.out.println(login);
		try{
			if(usuarioBL.login(login,password))
				retorno="ok";
			else
				retorno="false";				
			//retorno=usuarioBL.login(login,password)?"ok":"false";
			//retorno="ok";
		}
		catch(Exception e){
			return e.getMessage();
		}
		return retorno;
	}
	
}
