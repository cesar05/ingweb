package exception;

import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;

/*
* author: César Muñoz Roldan
*/
public class MyException extends Exception {

	
	private Logger log=Logger.getLogger(this.getClass());
	//SE CONFIGURA EL LOG	
	public static void fileConfig(){
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public MyException() {
		super();
		this.fileConfig();
		// TODO Auto-generated constructor stub
	}	

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		log.error(message,cause);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
		log.error(message);
	}

	public MyException(String message) {
		super(message);
		log.error(message);
	}

	public MyException(Throwable cause) {
		super(cause);
		log.error(cause);
	}
}
