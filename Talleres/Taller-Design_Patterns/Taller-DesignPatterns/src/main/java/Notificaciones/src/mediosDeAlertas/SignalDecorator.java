package mediosDeAlertas;
import Alertas.INotificacion;


public class SignalDecorator extends NotificacionesDecorator{
	
	public SignalDecorator (INotificacion notificacion) {
		super(notificacion);
	}
	

	@Override
	public void enviarNotificacion() {
		super.enviarNotificacion();
		System.out.println("Notificacion enviada por Signal");
		
	}

}
