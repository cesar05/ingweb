package co.edu.udea.iw.dto;

/*
 * author: César Muñoz Roldan
 */
public class Ciudad {
	
	private long codigo;
	private String nombre;
	private String codigoArea;
	
	public Ciudad(long codigo,String Nombre,String codigoArea){
		this.codigo=codigo;
		this.nombre=Nombre;
		this.codigoArea=codigoArea;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
		
}