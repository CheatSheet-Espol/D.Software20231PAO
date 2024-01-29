package interfaz;
import java.util.Scanner;

import main.Main;
import main.Usuario;

public class Android implements Discord{

	@Override
	public boolean login(Scanner sc){

		System.out.println("\nIngrese su email:");
		String email = sc.nextLine();
		System.out.println("\nIngrese su contraseña:");
		String contra = sc.nextLine();
		
		for(Usuario u: Main.usuarios) {
			if(u.getEmail().equals(email) && u.getContraseña().equals(contra)){
				u.setLoggin(true);
				System.out.println("Loggueado correctamente en dispositivo Android\n");
				return true;
			}
		}
		System.out.println("No se pudo logguear en Android\n");
		return false;
		
	}
	@Override
	public void enviarMensaje(String msg, Usuario user) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba el mensaje:");
        msg = scanner.nextLine();
		System.out.println("El mensaje es: "+msg + " \n Estado de mensaje: mensaje enviado correctamente a: \n " + user.getNombre() + " por Android");
		
	}

	@Override
	public void llamar(Usuario user1, Usuario user2) {
		System.out.println(user1 + " realizó una llamada correctamente a " + user2 + " por Android");
		
	}

	@Override
	public void crearUsuario(String name, String email, String contraseña, boolean prem) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario:");
        name = scanner.nextLine();

        System.out.println("Ingrese el correo electrónico del usuario:");
        email = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario:");
        contraseña = scanner.nextLine();

        System.out.println("¿Es un usuario premium? (true/false):");
        prem = scanner.nextBoolean();
		Usuario u1 = new Usuario(name, email, contraseña, prem);
		
		System.out.println("\nUsuario creado correctamente por Android");
		Main.usuarios.add(u1);
	}

}
