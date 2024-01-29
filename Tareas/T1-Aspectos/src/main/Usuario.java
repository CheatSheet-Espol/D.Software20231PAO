package main;

public class Usuario {
	
	private String nombre;
	private String email;
	private String contraseña;
	private boolean loggued = false;
	private boolean premium = false;
	
	public Usuario(String n, String e, String c, boolean p) {
		this.nombre = n;
		this.email = e;
		this.contraseña = c;
		this.premium = p;
	}
	
	public void setLoggin(boolean t){
		this.loggued = t;
	}
	
	//Getters
	public String getNombre(){
		return this.nombre;
	}
	
	public String getEmail(){
		return this.email;
	}

	public String getContraseña() {
		return this.contraseña;
	}
	
	public boolean isLogin() {
		return this.loggued;
	}
	
	@Override 
	public String toString() {
		return this.nombre;
	}
	
	
}
