package mediosDeAlertas;
import Alertas.INotificacion;
public abstract class NotificacionesDecorator implements INotificacion {
	public INotificacion notificacion;
	
	public NotificacionesDecorator(INotificacion notificacion) {
		this.notificacion = notificacion;
		
	}
	
	@Override
	public void enviarNotificacion() {
		notificacion.enviarNotificacion();
		
	}


}
