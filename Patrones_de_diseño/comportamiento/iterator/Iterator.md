[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Iterator
Un patron que permite recorrer cualquier estructura de datos sin complicaciones.
El patron se encarga de proveer un mecanismo para poder recorrer los elementos de una coleccion de manera secuencial si que necesitemos saber que tipo de coleccion es.
💡tambien puede usarse para filtar algun tipo de elemento en particular

- numerador: responsable de dar el siguiente elemento de la secuencial. Se encarga de sacar el siguiente elemento
Partes:
- Interfaz iterator: La van a implementar cada iterator para cada coleccion especifica.
    metodo moveNext: Retorna una booleano para verificar si hay o no un siguiente elemento el cual deba ser entregado.
    current() "getNext" : devuelve el elemento actual de la coleccion.
    reset():   regresa al inicio de la coleccion.
- Interfaz iterable: crea el iterador, la implementan las colecciones

1. INTERFAZ que van a implementar las colecciones, que todas las colecciones la implementen (iterable)
2. cada clase va a tener un iterator, que implementa la interfaz iterator.