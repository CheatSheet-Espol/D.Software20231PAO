[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Chain of responsability
Pasar solicitudes a lo largo de una cadena de controladores

manejador: interfaz clase abstracta
manejador concreto: implementa o extiende la clase manejador
cliente: inicia la peticion.


### Pasos para codigo:
1. crear la interfaz/abstracta que va a definir el metodo "procesar/handler". El sucesor recibe como parametro un objeto de la interfaz general.
2. Implementar/extender  la interfaz en modulos concretos que sobreescriben el metodo "handler". Su override define la condicion para que ellos mismos procesen el objeto o envien a su sucesor
3. Crear la cadena, puede ser en una clase aparte, crear instancias de todos los manejadores concretos desde el ultimo hacia el primero. El primero usará su metodo handler.
4. el cliente envia el objeto a ser procesado.