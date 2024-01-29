package mediosDeAlertas;
import Alertas.INotificacion;

public class TelegramDecorator extends NotificacionesDecorator {
	
	public TelegramDecorator(INotificacion notificacion) {
		super(notificacion);
	}

	@Override
	public void enviarNotificacion() {
		super.enviarNotificacion();
		System.out.println("Notificacion enviada por Telegram");
	}
}
