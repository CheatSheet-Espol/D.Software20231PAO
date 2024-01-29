[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Composite
Nos permite crear estructuras jerarquicas , de tipo arbol

leaf:Componente que no guarda otros componentes, solo algo en particular

compuesto: Alguien que puede contener a otros componentes

2 elementos: El componente y el compuesto

### Partes

interfazComponente: Comportamientos comunes a todos los objetos

operacion:Metodo que lleva a cabo la operacion que esperamos en un elemento de la composicion

Componente:Representa un objeto sencillo que no se puede descomponer más e implementa las operaciones.No tiene otros elementos.

Compuesto:Implementa las operaciones trabajando con una coleccion de componentes