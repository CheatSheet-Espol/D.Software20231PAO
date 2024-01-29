[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Builder
Se basa en construir objetos, objetos de una clase en especifico "producto". No es crear objetos de una familia de objetos, ni objetos de distintas clases, son objetos de una unica clase, los cuales pueden tener valores predeterminados.



### Partes   
- Director: instancia del builder
Se encarga de gestionar la creacion del producto Da una secuencia de operaciones que se siguen para crear un objeto (orden de metodos para crearlo?)
metodo que recibe el objeto builder abstract como parametro, metodo que construye el objeto usando los metodos definidos en el productoBuilder. Crea una instancia del builder y de ahi construye.
- producto: Tiene sus getters y setters

- abstract builder: Se caracteriza por tener una instancia del producto, 
metodos : 
- getProducto: retorna el producto, 
- crearProducto : crea una nueva instancia del producto, 
y metodos relacionados con las partes que conforman el producto
builder concreto
💡Es comun que sea una interfaz.

- builderConcreto: Instancia del producto
sobreescribe los metodos de abstract para usar su propia logica, setea los valores que va creando al producto directamente, devuelve el producto terminado.

- cliente: Ejecuta los metodos de director.

### Pasos:
1. crear el producto y sus metodos basicos
2. crear abstract builder con su get y construir producto más los metodos relacionados a las partes
3. crear builders cocretos que creen un producto especifico
4. crear un director y sus metodos correspondientes, set, get y construir producto usando el builder
5. clase cliente que crea al director y le pasa un builder concreto.

### Ejemplo conceptual
"El vehiculo, compuesto de muchas partes, pero siempre los mismos pasos {añadir carroceria, colocar motor, puertas, llantas...} crear builders concretos para distintos carros que siguen los mismos pasos.