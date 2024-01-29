[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Factory
Los objetos no se instancian directamente, sino que se emplea la fabrica concreta de ese objeto y ella devolverá el objeto creado
Basicamente es para crear un objeto. Encapsula el new

### Partes:
-objeto: Puede ser parte de una familia de jerarquia con una interfaz y hacerlo más flexible
-factory: Crea el objeto y lo devuelve