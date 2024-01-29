package interfaz;
import java.util.Scanner;
import main.Usuario;

public interface Discord{
	
	public boolean login(Scanner sc);
	
	public void enviarMensaje(String msg, Usuario user);
	
	public void llamar(Usuario user1, Usuario user2);
	
	public void crearUsuario(String name, String email, String contraseña, boolean prem);

	
}
