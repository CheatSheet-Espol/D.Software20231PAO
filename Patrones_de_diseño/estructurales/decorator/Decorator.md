[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Decorador
Ofrece agregar funcionalidades  a un objeto existente sin modificar el codigo de la clase base
Agregar atributos o funcionalidades
"Añadir capas a un objeto"
 

### Partes

-Componente: Clase/interfaz base de la cuales van a heredar/implementar los objetos normales, los no modificados pero tambien los decoradores

-ComponenteConcreto: Viene de componente usa sus metodos a su manera y es un objeto comun y corriente

-Decorador: Recursivo, hereda y tiene un atributo de componente (su clase base)
A su vez este decorador puede ser superClase de otros decoradores, así que puede ir pasando mensajes hacia sus subclases
🔺Constructor : recibe al componenteConcreto
🔺Protected atributo componente

-DecoradoresConcretos: Pueden heredar del decorador que ya heredó de componente y a partir de ahí crear varias ramas de decoradores especificos, aún así pueden enviar el mensaje hacia el siguiente atras de ellos,Añade su comportamiento al metodo sobreescrito de componente

💡El orden de los decoradores puede influir en el sistema
💡El ultimo decorador en la pila seria el objeto con el que realmente trabaja el cliente.

### Ejemplo
"VideoJuego, los enemigos o personajes pueden usar vestimentas, cosas que los hagan tener ciertas caracteristicas extras, no pensar en herencia"