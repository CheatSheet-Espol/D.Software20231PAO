package main;
import main.Usuario;
import java.util.Scanner;
import interfaz.IOS;

public aspect AspectAdapter{
	public IOS ios;
	static Scanner sc = new Scanner(System.in);
	
	//Aspecto para adaptar el inicio de sesión en IOS.
	pointcut iosLog(Scanner sc): execution (*boolean interfaz.AdapterToIOS.login(Scanner))&& args(sc);
	
	Object around(Scanner sc): iosLog(sc){
		ios = new IOS("default", 999, "example@example.com");		
		if(ios.conectarToID(sc)) {
			System.out.println("Loggueado correctamente en dispositivo IOS\n");
			return true;
		}else {
		
		System.out.println("No se pudo logguear en IOs\n");
		return false;
		}
	}
	
	before(): iosLog(Scanner){
		System.out.println("\n");
		
	}
	
	
	//Aspecto para adaptar el envío de mensajes IOS.
	pointcut message(String msg, Usuario user): call(*void interfaz.AdapterToIOS.enviarMensaje(String, Usuario)) && args(msg, user);

	Object around(String msg, Usuario user): message(msg, user) {
	    System.out.println(msg + "\nMensaje enviado correctamente a " + user + " por IOS");
	    return null;
	}

	
	
	//Aspecto para adaptar las llamadas por IOS.
	pointcut llamar(Usuario user1, Usuario user2): call(*void interfaz.AdapterToIOS.llamar(Usuario, Usuario)) && args(user1, user2);

	Object around(Usuario user1, Usuario user2): llamar(user1, user2) {
		IOS ios = new IOS("default", 999, "example@example.com");
	    if (ios.llamarIOS()) {
	        System.out.println(user1 + " realizó una llamada correctamente a " + user2 + " por IOS");
	        return null;
	    } else {
	        System.out.println("Llamada cancelada\n");
	        return null;
	    }
	}

	
	
	//Aspecto para adaptar la creación de usuarios en IOS.
	pointcut crearUsuario(): call (*void interfaz.Discord.crearUsuario(String, String, String, boolean ));
	
	Object around():crearUsuario(){
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario:");
        String name = scanner.nextLine();

        System.out.println("Ingrese el correo electrónico del usuario:");
        String email = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario:");
        String contraseña = scanner.nextLine();

        System.out.println("¿Es un usuario premium? (true/false):");
        Boolean prem = scanner.nextBoolean();
		Usuario u1 = new Usuario(name, email, contraseña, prem);
		Main.usuarios.add(u1);
		System.out.println("Usuario de discord por IOS creado correctamente");
		return null;
		
		}
	

	
}