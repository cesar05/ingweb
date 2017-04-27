package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.ClienteJersey;
import exception.MyException;

@Path("cliente")
@Component
public class ClienteWS {
	@Autowired
	ClienteBL clienteBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String guardar(
			@QueryParam("cedula")String cedula,
			@QueryParam("nombre")String nombre,
			@QueryParam("apellidos")String apellidos,
			@QueryParam("email")String email,
			@QueryParam("usuarioCrea")String usuarioCrea) throws RemoteException{
		
		String response="";
		try{
			if(clienteBL.guardar(cedula, nombre, apellidos, email, usuarioCrea))
				response="usuario creado correctamente";
			else
				response="no fue posible crear el usuario";
		}
		catch(MyException e){
			throw new RemoteException("error guardando el usuario",e);
		}
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)
	public List<ClienteJersey> obtener()throws RemoteException{
		List<ClienteJersey> respuesta=new ArrayList<ClienteJersey>();
		
		try{
			for(Cliente cliente:clienteBL.obtener()){
				ClienteJersey clienteJersey=new ClienteJersey(
						cliente.getCedula(), 
						cliente.getNombres(), 
						cliente.getApellidos(), 
						cliente.getEmail());
				respuesta.add(clienteJersey);
			}
		}
		catch (MyException e) {
			throw new RemoteException("No fue posibles obetner los usuarios");
		}
		return respuesta;
	}
}
