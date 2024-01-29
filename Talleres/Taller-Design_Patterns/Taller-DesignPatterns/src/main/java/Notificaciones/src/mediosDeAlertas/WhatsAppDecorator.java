package mediosDeAlertas;

import Alertas.INotificacion;

public class WhatsAppDecorator extends NotificacionesDecorator {
	
	public WhatsAppDecorator (INotificacion notificacion) {
		super(notificacion);
	}
	

	@Override
	public void enviarNotificacion() {
		super.enviarNotificacion();
		System.out.println("Notificacion enviada por WhatsApp");
		
	}

}
