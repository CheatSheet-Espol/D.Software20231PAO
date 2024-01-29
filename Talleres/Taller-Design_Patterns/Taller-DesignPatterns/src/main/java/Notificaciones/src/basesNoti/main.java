package basesNoti;
import Alertas.INotificacion;
import mediosDeAlertas.*;
public class main {

	public static void main(String[] args) {
		
		//notificación solo por correo y sms
		INotificacion notificacion = new BaseNotificaciones();
		//notificacion.enviarNotificacion();
		
		//Notificación por correo, sms y WhatsApp
		notificacion = new WhatsAppDecorator(notificacion);
		//notificacion.enviarNotificacion();
		
		//Notificación por correo, sms, WhatsApp y Signal
		notificacion = new SignalDecorator(notificacion);
		//notificacion.enviarNotificacion();
		
		//Notificación por correo, sms, WhatsApp, Signal y Wire
		notificacion = new WireDecorator(notificacion);
		//notificacion.enviarNotificacion();
		
		//Notificación por correo, sms, WhatsApp, Signal, Wire y Telegram
		notificacion = new TelegramDecorator(notificacion);
		
		notificacion.enviarNotificacion();
		
		
        };

}
