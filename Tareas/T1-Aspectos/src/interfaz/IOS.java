package interfaz;
import java.util.Scanner;

public class IOS {

	String idIOS;
	Integer contraseñaIos;
	String email;
	String contraseña;
	static Scanner s = new Scanner(System.in);
	
	public IOS(String id, int psw, String email){
		this.idIOS = id;
		this.contraseñaIos = psw;
		this.email = email;
		crearContraseña();
	}
	
	public void crearContraseña() {
		//SUPONGAMOS QUE LA CONTRASEÑA SE CREA DE FORMA ALEATORIA
		this.contraseña = "contraseñaAleatoria";
	}
	
	public boolean conectarToID(Scanner sc) {
		System.out.println("Ingrese su IOS ID: \n");
		String id = sc.nextLine();
		System.out.println("Ingrese su contraseña: \n");
		int psw = sc.nextInt();
		
		if(id.equals("default") && psw == 999) {
			System.out.println("Se conectó correctamente a la cuenta IOS ID");
			return true;
		}
		System.out.println("Falló en sesion IOS ID");
		return false;
	}
	
	public boolean llamarIOS() {
		
		if(conectarToID(s)) {
			System.out.println("Permiso para llamar de IOS concedida");
			return true;
		}
		System.out.println("Permiso para llamar de IOS denegada");
		return false;
		
	}
	
	public IOS crearUsuarioIOS(String idC, int pswC, String emailC, boolean premC) {
		IOS u = new IOS(idC, pswC, emailC);
		System.out.println("Usuario IOs creado");
		return u;
		
	}
}
