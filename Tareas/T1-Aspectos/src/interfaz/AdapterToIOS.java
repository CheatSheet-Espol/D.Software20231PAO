package interfaz;
import java.util.Scanner;
import main.*;

public class AdapterToIOS implements Discord{


	@Override
	public boolean login(Scanner sc){
		
		return true;
	}

	@Override
	public void enviarMensaje(String msg, Usuario user) {
		
	}

	@Override
	public void llamar(Usuario user1, Usuario user2) {
		
		
		
	}

	@Override
	public void crearUsuario(String name, String email, String contraseña, boolean prem) {

	}

}
