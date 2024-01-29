package main;

public class DetallesApp{
	
	private String nombreDesarrollo;
	private String version;
	private static DetallesApp details;
	
	
	private DetallesApp(){
		this.nombreDesarrollo = "Discord_App.091.2Beta";
		this.version = "3.019.1 Global"; 
	}
	
	
	//Getter
	public static DetallesApp getInstance(){
		if(details != null) {
			return details;
		}
		else {
			details = new DetallesApp();
			return details;
		}
	}
	
	public String toString() {
		return "Development Name: " + details.nombreDesarrollo + "\nVersion: " + details.version + "\n"; 
	}
}
