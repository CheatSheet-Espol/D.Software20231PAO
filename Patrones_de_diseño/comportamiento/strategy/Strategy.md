[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Strategy

Encapsular diferentes logicas, algoritmos, para asi poder cambiar de una a otra
Cambia la familia de algoritmo de acuerdo a la necesidad del cliente.

### Partes:
-context: la clase que utiliza las estrategias {setEstrategia, constructor(estrategia), ejecutarEstrategia{estrategia.ejecutar}}
-strategy interfaz: define el metodo en comun
-strategy concreta: implementa la interfaz y define su propia logica
-client: es el que llama a context creando una instancia de el y pasandole una estretegia segun se requiera

### pasos:
1.crear la interfaz estrategia con el metodo "ejecutar"
2.crear las estrategias especificas que implementen la interfaz. Medodo "ejecutar"
3.la clase context tiene un atributo del tipo de la interfaz estretegia.
En el constructor de context se le envia la estrategia, como objeto de la interfaz. 
El metodo setEstrategia es para cambiar estrategia cada vez,    
El metodo ejecutaEstrategia, llama al metodo ejecutar de la estrategia en particular.
4.cliente crea la instancia de context y decide que estretegia pasarle.