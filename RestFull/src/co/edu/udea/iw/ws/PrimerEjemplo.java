package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("saludo")
public class PrimerEjemplo {
	
	
	@GET//Para decirle porque verbo http va a responder este metodo
	@Produces(MediaType.TEXT_HTML)//Especifica el tipo de data que devuelve
	public String saludar(){
		return "Buenas tardes";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2(){
		return "Hola";
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("3")
	public String saludar3(@QueryParam("a")String nombre){
		return "Buenas tardes "+nombre;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("4/{a}")
	public String saludar4(@PathParam("a")String nombre){
		return "Variable de parametro "+nombre;
	}
	*/
	
}
