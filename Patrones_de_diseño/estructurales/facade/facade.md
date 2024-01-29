[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)
# Facade
Oculta la complejidad del sistema
El patrón de diseño Facade se utiliza para proporcionar una interfaz simplificada y unificada para un conjunto complejo de clases o subsistemas. Se utiliza cuando tenemos un sistema con múltiples clases o módulos que interactúan entre sí de manera compleja, y queremos ocultar esa complejidad detrás de una fachada o interfaz única y fácil de usar.
💡"Fachada que se conecta con las demás partes, el usuario solo conoce 'fachada' "

### Variaciones de fachada
-🔺opaco: los subsistemas solo pueden ser accedidos desde fachada
-🔺transparente: Los subsistemas pueden utilizarse directamente o desde la fachada
-🔺estatica: La fachada es estatica por lo que no hay que instanciarla

### Partes:
-Subsistemas: Son parte de un sistema complejo , pueden ser muchos, tienen sus propias funcionalidades
-fachada: Usa a los subsistemas. Invoca sus metodos para realizar sus acciones
-cliente: Instancia la fachada y ejecuta el metodo de fachada para realizar acciones

💡La fachada puede venir de una clase abstracta, eso por si se quiere hacer varias fachadas para partes especificas de un sistema más grande y complejo, asi evitar alto acomplamiento.

### Pasos:
1.Se crea la fachada.
2.La fachada tiene instancias privadas de los subsistemas que va a utilizar.
3.Definde los metodos comunes donde va a implementar las operaciones de los subsistemas en comun, en la fachada se oculta toda la logica compleja que el cliente no ve para poder comunicarse con el sistema
4.El cliente crea la instancia de fachada y utiliza el metodo que conoce de la fachada.