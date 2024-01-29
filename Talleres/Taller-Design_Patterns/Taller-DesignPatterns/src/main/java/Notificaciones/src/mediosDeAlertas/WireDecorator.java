package mediosDeAlertas;
import Alertas.INotificacion;

public class WireDecorator extends NotificacionesDecorator {
	
	public WireDecorator (INotificacion notificacion) {
		super (notificacion);
	}
	
	@Override
	public void enviarNotificacion() {
		super.enviarNotificacion();
		System.out.println("Notificacion enviada por Wire");
		
	}

}



