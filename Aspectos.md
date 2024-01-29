# AOP - POA notacion para AspectJ.

Dividir la aplicacion en modulos llamados aspectos , se usa junto a la programacion orientada a objetos

aspectos: Para funcionalidades transversales de una aplicacion (CROOSCUTTING-CONCERNS)
ej: Login, seguridad, autentificacion, trazabilidad, transaccionalidad, control de errores

Esto para que su implementacion esté en un solo lugar y no en multiples partes, para no repetir el codigo varias veces en distintos lugares.

- Aspect: es una funcionalidad genérica aplicable a múltiples objetos. Cada aspecto trata una sola funcionalidad (CONCERN).

- Join point: es el punto de ejecución donde se puede aplicar un aspecto como la llamada a un método, su retorno o el acceso a una propiedad.
    Puede ser cualquier cosa, es como un "evento"
    como la ejecución de un metodo
    instancia de una clase
    la llamada a un metodo
    lectura o escritura de un campo.
    ~~~java
    - execution(<modificador> <tipo-de-retorno> <nombre-de-la-clase>.<nombre-del-método>(<argumentos>))
    - call(<modificador> <tipo-de-retorno> <nombre-de-la-clase>.<nombre-del-método>(<argumentos>))
    - get(<tipo-de-dato> <nombre-de-la-clase>.<nombre-del-campo>)
    - set(<tipo-de-dato> <nombre-de-la-clase>.<nombre-del-campo>)
    ~~~


- Pointcut: es una expresión que busca joint points, tiene un advice asociado que se ejecuta en todos los joint points que concuerdan con la expresión. Vendrian a ser una especie de nombre del metodo que envuelve al joinpoint
    ~~~java
    - pointcut <nombre-del-pointcut>(): <expresión-de-punto-de-corte>
    pointcut publicMethods(): execution(public * com.example.MyClass.*(..))
    ~~~


    En la notación de anotaciones, los pointcuts se definen mediante la creación de métodos anotados con la anotación @Pointcut. Estos métodos encapsulan las expresiones de punto de corte y se pueden reutilizar en varios consejos dentro del aspecto.
    ~~~java
    - @Pointcut("execution(public void package.Class.method(..))")
    public void publicMethod() {}
    ~~~


- Advice: es la acción que se realiza en un pointcut. Los metodos que va a realizar el pointcut. Sería el cuerpo del metodo en un determinado momento.
    before: Se ejecuta antes de la accion seleccionada en el pointcut
    after: se ejecuta despues de la accion seleccionada en el pointcut
    around: Se ejecuta antes y despues del pointcut (opcional)
~~~java    
    - pointcut executionMyMethod(): execution(void com.example.MyClass.myMethod());

    before(): executionMyMethod() {
        System.out.println("Antes de ejecutar myMethod");
    }
    
    - pointcut callOtherMethod(): call(void com.example.OtherClass.otherMethod());

    after(): callOtherMethod() {
        System.out.println("Después de llamar a otherMethod");
    }

    notacion en anotaciones:
    @AfterReturning(pointcut = "get(int package.Class.field)", returning = "value")
    public void afterFieldGet(int value) {
        // Código del consejo
        // ...
    }   
~~~

- weaving: proceso que aplica los aspectos a las clases, puede ser en tiempo de compilación o en tiempo de ejecución.Los aspectos se aplicacion a los joinpoints seleccionados. permite agregar funcionalidades sin modificar el codigo base


