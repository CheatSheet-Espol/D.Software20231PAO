# CODE SMELLS
Sintomas en el codigo que pueden indicar que las cosas no se están haciendo de la manera más optima y que pueden haber problemas a futuro

- No son Bugs, el programa puede que sí esté funcionando
- Indican que el diseño tiene deficiencias

1. [Bloaters](#bloaters);
2. [OOAbusers](#oo-abusers)
3. [Change-Preventers](#change-preventers)
4. [Dispensables](#dispensables)
5. [Couplers](#couplers)
6. [Resumen](#resumen)
## Tipos de malos olores: Sintomas

- Código duplicado (el mismo código repetido)
- Métodos largos (>10 LOC)
- Sentencias de condicionales complejas (dificultan el
entendimiento)
- Clases vagas (casi no hacen nada, es mejor poner ese código en
otra clase)
- Clases largas (clases con muchas responsabilidades)
- Explosión combinatorial (se usan muchos métodos en lugar de
uno que puede hacer varias cosas)
- Oddball solution (solucionar un problema de varias maneras  se
debe escoger la mejor solución para no duplicar código)

### Bloaters
Metodos y clases que han alcanzado grandes proporciones (Existen más aparte de los mencionados)
Claro, a continuación te explico los 8 bloaters con sus respectivas explicaciones y algunas pistas para identificarlos:

1. Clases o funciones demasiado grandes (Large Class/Method):
   - Son clases o métodos que han crecido hasta ser extensos y complejos, dificultando su comprensión y mantenimiento.
   - Pistas para identificarlos: Busca clases con muchos métodos y atributos o funciones con muchas líneas de código.
   - Metodos: No más  de 10 lineas, max 10
   - Clases : Apartir de 200 lineas se considera grande, depende de la convención.



2. Métodos con muchos parámetros (Long Parameter List):
   - Se refiere a métodos que tienen una gran cantidad de parámetros como argumentos, dificultando su uso y lectura.
   - Pistas para identificarlo: Busca métodos con muchos parámetros, especialmente si los parámetros son del mismo tipo o si la lista es larga.
  ```Java
  public void processOrder(String customerName, String address, String email, String phone,
                         List<Item> items, double discount, boolean isUrgent) {
    // Lógica para procesar el pedido...
    }
  ```

3. Data Clumps :
   Son grupos de variables o datos que aparecen repetidamente juntos en diferentes partes del código.
   ```Java
   class Person {
        String name;
        String address;
        String phone;
    }
    ```
4. Primitive Obsession (Obsesión con Primitivos):

Sucede cuando se utilizan primitivos en lugar de crear clases adecuadas para representar conceptos más complejos.
```Java
   class Order {
    int orderId;
    String customerName;
    int quantity;
    double price;
    }
```

### OO Abusers


1. Switch Statements (Sentencias Switch):
   - Sucede cuando hay una serie de declaraciones "switch" (o "case") que eligen diferentes acciones basadas en el valor de una variable o expresión.
   - Explicación: Las sentencias "switch" pueden volverse difíciles de mantener y extender, especialmente si se agregan nuevos casos o se modifican los existentes.
   - Ejemplo en Java:
     ```java
     public double calculateDiscount(Order order) {
         double discount = 0;
         switch (order.getType()) {
             case REGULAR:
                 discount = order.getAmount() * 0.1;
                 break;
             case PREMIUM:
                 discount = order.getAmount() * 0.2;
                 break;
             case VIP:
                 discount = order.getAmount() * 0.3;
                 break;
             default:
                 // Lógica para otros casos...
         }
         return discount;
     }
     ```

2. Temporary Fields (Campos Temporales):
   - Son atributos que se utilizan solo en ciertos escenarios o momentos específicos de una clase.
   - Explicación: Estos campos pueden hacer que la clase sea más compleja y difícil de entender, ya que su existencia solo tiene sentido en contextos particulares.
   - Ejemplo en Java:
     ```java
     public class Order {
         private double amount;
         
         // Otros atributos permanentes...
         
         // Atributos temporales que solo se utilizan para cálculos internos
         private double tempDiscount;
         private double tempTax;
         
         // Métodos que utilizan los atributos temporales...
     }
     ```

3. Refused Bequest (Herencia Rechazada):
   - Sucede cuando una clase hereda de otra, pero la subclase rechaza o ignora gran parte del comportamiento o funcionalidad proporcionada por la clase padre.
   - Explicación: Esto puede indicar que la jerarquía de herencia no se ha diseñado adecuadamente o que la subclase no debería heredar de la clase padre.
   - Ejemplo en Java:
     ```java
     class Animal {
         void eat() { /* Lógica para comer */ }
         void sleep() { /* Lógica para dormir */ }
     }
     
     class Dog extends Animal {
         void bark() { /* Lógica para ladrar */ }
     }
     
     // En este caso, la subclase Dog no utiliza los métodos eat() y sleep() de la clase padre Animal, lo que puede indicar un mal diseño de la jerarquía de herencia.
     ```

4. Alternative Classes with Different Interfaces (Clases Alternativas con Interfaces Diferentes):
   - Ocurre cuando hay varias clases que tienen funciones o comportamientos similares, pero implementan diferentes interfaces, lo que dificulta su uso conjunto.
   - Explicación: Esto puede llevar a una mayor complejidad y dificultades de mantenimiento.
   - Ejemplo en Java:
     ```java
     interface Shape {
         void draw();
     }
     
     class Circle implements Shape {
         void draw() { /* Lógica para dibujar un círculo */ }
         void calculateArea() { /* Lógica para calcular el área de un círculo */ }
     }
     
     class Square implements Shape {
         void draw() { /* Lógica para dibujar un cuadrado */ }
         void calculateSideLength() { /* Lógica para calcular el lado de un cuadrado */ }
     }
     
     // En este caso, Circle y Square son clases alternativas que implementan la misma interfaz Shape, pero tienen métodos adicionales específicos que hacen que su uso conjunto sea complicado.
     ```

### Change Preventers



1. Divergent Change (Cambio Divergente):
   - Sucede cuando un cambio en una clase o módulo requiere modificar varias partes diferentes del código.
   - Explicación: Esto indica que la responsabilidad de la clase está diseminada en múltiples áreas, lo que hace difícil realizar cambios sin afectar a otras partes del sistema.
   - Ejemplo en Java:
     ```java
     class Customer {
         private String name;
         private String address;
         // Otros atributos...
         
         // Métodos relacionados con el cliente...
     }
     ```

   - Pistas para identificarlo: Si al modificar la clase Customer, se requiere hacer cambios en diversas partes del sistema que no tienen una relación clara con la lógica del cliente, es posible que haya un cambio divergente presente.

2. Shotgun Surgery (Cirugía a Distancia):
   - Sucede cuando un solo cambio en el código requiere realizar múltiples modificaciones en diferentes clases o módulos.
   - Explicación: Esto indica que la lógica relacionada está dispersa en múltiples clases, lo que hace difícil realizar cambios sin afectar a muchas áreas del sistema.
   - Ejemplo en Java:
     ```java
     class Order {
         // Atributos relacionados con el pedido...
         
         void calculateTotalPrice() {
             // Lógica para calcular el precio total...
         }
     }
     
     class ShoppingCart {
         // Atributos relacionados con el carrito de compras...
         
         void calculateTotalPrice() {
             // Lógica para calcular el precio total...
         }
     }
     ```

   - Pistas para identificarlo: Si al modificar la lógica de calcular el precio total, es necesario modificar múltiples clases diferentes, es probable que haya un shotgun surgery presente.

3. Parallel Inheritance Hierarchies (Jerarquías de Herencia Paralelas):
   - Sucede cuando existen dos o más jerarquías de clases que deben evolucionar juntas y en paralelo.
   - Explicación: Esto ocurre cuando se crean jerarquías de clases adicionales para extender la funcionalidad de otras jerarquías existentes, lo que aumenta la complejidad y el acoplamiento.
   - Ejemplo en Java:
    Claro, a continuación te explico cada uno de los malos olores de código que mencionas, junto con ejemplos en Java y algunas pistas para identificarlos:

4. Divergent Change (Cambio Divergente):
   - Sucede cuando un cambio en una clase o módulo requiere modificar varias partes diferentes del código.
   - Explicación: Esto indica que la responsabilidad de la clase está diseminada en múltiples áreas, lo que hace difícil realizar cambios sin afectar a otras partes del sistema.
   - Ejemplo en Java:
     ```java
     class Customer {
         private String name;
         private String address;
         // Otros atributos...
         
         // Métodos relacionados con el cliente...
     }
     ```

   - Pistas para identificarlo: Si al modificar la clase Customer, se requiere hacer cambios en diversas partes del sistema que no tienen una relación clara con la lógica del cliente, es posible que haya un cambio divergente presente.

5. Shotgun Surgery (Cirugía a Distancia):
   - Sucede cuando un solo cambio en el código requiere realizar múltiples modificaciones en diferentes clases o módulos.
   - Explicación: Esto indica que la lógica relacionada está dispersa en múltiples clases, lo que hace difícil realizar cambios sin afectar a muchas áreas del sistema.
   - Ejemplo en Java:
     ```java
     class Order {
         // Atributos relacionados con el pedido...
         
         void calculateTotalPrice() {
             // Lógica para calcular el precio total...
         }
     }
     
     class ShoppingCart {
         // Atributos relacionados con el carrito de compras...
         
         void calculateTotalPrice() {
             // Lógica para calcular el precio total...
         }
     }
     ```

   - Pistas para identificarlo: Si al modificar la lógica de calcular el precio total, es necesario modificar múltiples clases diferentes, es probable que haya un shotgun surgery presente.

6. Parallel Inheritance Hierarchies (Jerarquías de Herencia Paralelas):
   - Sucede cuando existen dos o más jerarquías de clases que deben evolucionar juntas y en paralelo.
   - Explicación: Esto ocurre cuando se crean jerarquías de clases adicionales para extender la funcionalidad de otras jerarquías existentes, lo que aumenta la complejidad y el acoplamiento.
   - Ejemplo en Java:
     ```java
     class Employee {
         // Atributos y métodos para un empleado genérico...
     }
     
     class FullTimeEmployee extends Employee {
         // Atributos y métodos específicos para un empleado a tiempo completo...
     }
     
     class ContractEmployee extends Employee {
         // Atributos y métodos específicos para un empleado contratado...
     }
     
     // Ahora se necesita una nueva jerarquía de clases para representar empleados en diferentes departamentos:
     
     class HRDepartmentEmployee extends Employee {
         // Atributos y métodos específicos para un empleado del departamento de recursos humanos...
     }
     ```

   - Pistas para identificarlo: Si al agregar una nueva jerarquía de clases, es necesario extenderla para todas las demás jerarquías, es probable que haya una jerarquía de herencia paralela presente.
   - Cambios en una jerarquía afectan a otra: Si realizar cambios en una jerarquía de clases requiere realizar cambios similares en otra jerarquía, es posible que haya una herencia paralela.
   - Complejidad creciente: Si la cantidad de clases en cada jerarquía aumenta rápidamente a medida que se agregan más funcionalidades o departamentos, es probable que haya una herencia paralela


   - Pistas para identificarlo: Si al agregar una nueva jerarquía de clases, es necesario extenderla para todas las demás jerarquías, es probable que haya una jerarquía de herencia paralela presente.


### Dispensables


1. Comments (Comentarios):
   - Sucede cuando el código contiene comentarios excesivos o redundantes para explicar su funcionamiento.
   - Explicación: Un código limpio y bien estructurado debe ser autoexplicativo en la mayoría de los casos, y los comentarios solo deben usarse cuando es absolutamente necesario para aclarar aspectos complejos.
   - Ejemplo en Java:
     ```java
     // Método para calcular el total del pedido
     public double calculateTotal(Order order) {
         // Lógica para calcular el total del pedido...
     }
     ```

   - Pistas para identificarlo: Busca comentarios que simplemente repitan lo que el código ya está diciendo claramente, o que no añadan información útil.

2. Duplicate Code (Código Duplicado):
   - Es la presencia de bloques de código repetidos en varias partes del programa.
   - Explicación: El código duplicado aumenta la complejidad y el riesgo de errores, ya que cualquier cambio debe realizarse en varios lugares.
   - Ejemplo en Java:
     ```java
     public void methodA() {
         // Bloque de código A...
     }
     
     public void methodB() {
         // Bloque de código A...
     }
     ```

   - Pistas para identificarlo: Busca bloques de código idénticos o similares que aparezcan en varias partes del programa.

3. Lazy Class (Clase Perezosa):
   - Sucede cuando una clase no aporta funcionalidad significativa y no tiene muchas responsabilidades.
   - Explicación: Las clases perezosas no hacen lo suficiente y pueden ser eliminadas o fusionadas con otras para simplificar el diseño.
   - Ejemplo en Java:
     ```java
     class LazyClass {
         // Pocos métodos o atributos con funcionalidad limitada...
     }
     ```

   - Pistas para identificarlo: Busca clases con muy pocos métodos o atributos que no se utilizan ampliamente en el programa.

4. Data Class (Clase de Datos):
   - Son clases que solo contienen atributos y métodos de acceso (getters y setters) sin lógica adicional.
   - Explicación: Estas clases actúan solo como contenedores de datos sin una funcionalidad relevante y pueden reemplazarse por estructuras de datos más simples.
   - Ejemplo en Java:
     ```java
     class DataClass {
         private int value1;
         private String value2;
         // Solo getters y setters...
     }
     ```

   - Pistas para identificarlo: Busca clases que solo contengan atributos con métodos de acceso y que no realicen ninguna operación o lógica significativa.

5. Dead Code (Código Muerto):
   - Es código que ya no se utiliza en el programa y no tiene ningún impacto en la ejecución.
   - Explicación: El código muerto puede acumularse a medida que el programa evoluciona y puede ser eliminado para mantener el código limpio y fácil de mantener.
   - Ejemplo en Java:
     ```java
     public void methodA() {
         // Código utilizado anteriormente, pero ahora no se utiliza...
     }
     ```

   - Pistas para identificarlo: Busca métodos, bloques de código o variables que no se usan en ninguna parte del programa.

6. Speculative Generality (Generacidad Especulativa):
   - Sucede cuando el código contiene funcionalidades o clases que han sido creadas de manera prematura, anticipándose a futuros requisitos que nunca se materializan.
   - Explicación: La generacidad especulativa aumenta la complejidad innecesariamente y puede hacer que el código sea más difícil de entender.
   - Ejemplo en Java:
     ```java
     // Clase que proporciona una funcionalidad adicional que nunca se utiliza
     class SpeculativeClass {
         // Métodos y atributos innecesarios...
     }
     ```

   - Pistas para identificarlo: Busca clases, métodos o funcionalidades que parecen haber sido creados anticipándose a requisitos futuros, pero que nunca se utilizan en el programa actual.

### Couplers


1. Feature Envy (Envidia de Funcionalidad):
   - Sucede cuando un método de una clase accede excesivamente a los miembros (atributos o métodos) de otra clase en lugar de los suyos propios.
   - Explicación: Este olor de código puede indicar que la funcionalidad debería estar en la clase que utiliza esa información en lugar de depender tanto de otra clase.
   - Ejemplo en Java:
     ```java
     class Customer {
         private String name;
         private Address address;
         // Otros atributos...
     
         public String getCustomerDetails() {
             return "Name: " + name + ", Address: " + address.getFullAddress();
         }
     }
     
     class Address {
         private String street;
         private String city;
         // Otros atributos...
     
         public String getFullAddress() {
             return street + ", " + city;
         }
     }
     ```

   - Pistas para identificarlo: Busca métodos que acceden a más miembros de otra clase que a los propios y considera si esa funcionalidad debería estar en la clase que llama a esos métodos.

2. Inappropriate Intimacy (Intimidad Inapropiada):
   - Sucede cuando dos clases están excesivamente acopladas, accediendo libremente a los miembros internos de la otra.
   - Explicación: El acoplamiento excesivo entre clases puede dificultar el mantenimiento y la comprensión del código.
   - Ejemplo en Java:
     ```java
     class Engine {
         // Atributos y métodos específicos para el motor...
     }
     
     class Car {
         private Engine engine;
         // Otros atributos...
     
         public void start() {
             engine.turnOn();
             // Lógica para arrancar el coche...
         }
     }
     ```

   - Pistas para identificarlo: Busca clases que acceden directamente a miembros privados de otras clases y considera si este nivel de acoplamiento es apropiado.

3. Message Chains (Cadenas de Mensajes):
   - Sucede cuando se encadenan varias llamadas de métodos para acceder a un miembro de una clase.
   - Explicación: Las cadenas de mensajes pueden dificultar la comprensión del código y hacerlo más frágil, ya que cualquier cambio en la estructura de la cadena podría requerir cambios en múltiples lugares.
   - Ejemplo en Java:
     ```java
     class Person {
         private Address address;
         // Otros atributos...
     }
     
     class Address {
         private City city;
         // Otros atributos...
     }
     
     class City {
         private String name;
         // Otros atributos...
     }
     
     // Uso de la cadena de mensajes
     String cityName = person.getAddress().getCity().getName();
     ```

   - Pistas para identificarlo: Busca cadenas de mensajes largas para acceder a miembros de una clase y considera si se pueden simplificar o encapsular mejor.

4. Middle Man (Hombre del Medio):
   - Sucede cuando una clase simplemente delega todas sus llamadas de métodos a otra clase, sin agregar valor adicional.
   - Explicación: La presencia de un "hombre del medio" puede complicar el diseño y no aportar funcionalidad significativa.
   - Ejemplo en Java:
     ```java
     class Car {
         private Engine engine;
         // Otros atributos...
     
         public void start() {
             engine.start();
         }
     }
     
     class Engine {
         public void start() {
             // Lógica para arrancar el motor...
         }
     }
     ```

   - Pistas para identificarlo: Busca clases que solo contienen llamadas de métodos directas a otra clase sin realizar ninguna otra funcionalidad y considera si esas clases son realmente necesarias.

### Deuda tecnica:
La deuda que se acepta porque luego se va a tener que invertir mayor cantidad de tiempo para solucionar errores etc, porque se eligió un diseño sencillo o se hizo mal

## Resumen

1. Bloaters (Hinchazón): Incluye malos olores relacionados con el tamaño y complejidad del código, como clases o métodos demasiado grandes y código duplicado.

2. OO Abusers (Abusadores de la POO): Engloba malos olores relacionados con un uso inadecuado o excesivo de conceptos de la programación orientada a objetos, como herencia profunda y clases de datos.

3. Change Preventers (Preventores de Cambio): Son malos olores que dificultan la modificación y mantenimiento del código, como clases altamente acopladas y clases que violan el principio de responsabilidad única.

4. Dispensables (Despilfarros): Agrupa malos olores que no aportan valor al código y que pueden eliminarse, como código muerto y comentarios obsoletos.

5. Couplers (Acopladores): Incluye malos olores relacionados con el nivel de dependencia entre clases y componentes, como acoplamiento excesivo y utilización de patrones antipatronales.

Otras clasificaciones pueden incluir categorías adicionales o diferentes agrupaciones de malos olores. Cada clasificación puede ser útil para identificar y abordar problemas específicos en el código y mejorar su calidad.

Es importante destacar que estas clasificaciones son herramientas útiles para el análisis y mejora del código, pero siempre se debe tener en cuenta el contexto específico del proyecto y las necesidades del equipo de desarrollo. La revisión de código en equipo, la utilización de herramientas de análisis estático y la aplicación de técnicas de refactorización pueden ayudar a abordar estos malos olores y mantener un código limpio y eficiente.