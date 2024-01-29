[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Adapter
Adaptar una clase de la cual no tenemos acceso al codigo fuente 
Util para usar codigo legacy(antiguo), libreria, toolkits

adaptador de dos vias:  cuando 2 sistemas necesitan usar las caracteristicas del otros
    Una sola clase adaptador se usa para proveer la adaptacion a ambos

### Partes del patron:
🔺cliente: conoce la interfaz general, trabaja con clases que la implementan.
🔺interfaz Target: define metodos comunes que conoce el cliente
🔺adaptado: la clase legacy que no tiene metodos comunes que el usuario conoce, o su implementacion es diferente a lo usual.

🔺adaptador: implementa la interfaz y crea una instancia de adaptado, traduce el codigo en terminos del metodo conocido por cliente
    2da forma: El adaptador implementa la interfaz conocida del usuario, crea un atributo de la clase que no es familiar el cual le llega por medio de su constructor y una vez sobreescribiendo los metodos de la interfaz hace la traduccion de los metodos que no sean comunes.