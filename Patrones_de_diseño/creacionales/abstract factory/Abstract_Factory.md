[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Abstract Factory
Una fabrica de fabricas
Primero indicar que fabrica se desea, para luego tener la instancia de ese objeto
Se puede tener más de una familia de objetos asociados o dependientes entre sí a una fabrica en particular
Evita que se creen objetos de manera indiscriminada

### Partes:

-abstractFactory: Define los metodos para crear objetos de la misma familia.
-FabricasConcretas:Implementa la interfaz fabrica abstracta y sobreescribe sus metodos
crea instancias de los objetos con retorno del tipo de objeto que crea.Los objetos que vaya a crear deben estar relacionados de alguna forma.

-interfaces:Interfaces para crear una familias de objetos.
-ObjetosA: Pueden ser objetos varios que implementen el mismo tipo de interfaz, parte de una familia.
-ObjetosB: Pueden ser objetos varios que implementen el mismo tipo de interfaz, parte de una familia.

opcional: Depende de que tanto encapsulamiento quiera hacerse
-factoryProductor: Una clase que maneja la logica para enviar una u otra fabrica concreta y a partir de ahi poder crear los objetos.

### Pasos:
1.Identificar los productos y sus diferentes variantes, ver cuales tienen algo en comun
2.Interfaces para esos productos  , luego que los productos implementen esas interfaces
3.Interfaz de la fabrica abstracta con metodos para que cree el producto y el retorno son las interfaces de cada producto
4.fabricas implementan la interfaz y crean cada familia de productos
5.Crear una clase donde se pueda intercambiar las fabricas seteando y pasando en el constructor.
### Ejemplo conceptual
Mario Maker con los distintos objetos y distintos temas que no pueden mezclarse unos con otros, una fabrica que genera objetos de un tema en particular y otra fabrica que genera los objetos del segunto tema en particular.   