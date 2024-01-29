package basesNoti;

import Alertas.INotificacion;

public class BaseNotificaciones implements INotificacion {


	@Override
	public void enviarNotificacion() {
		System.out.println("Notificacion enviada por Correo Electrónico y SMS");
		
	}

}
