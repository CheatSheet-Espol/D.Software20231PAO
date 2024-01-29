# Tecnicas Refactoring

1. [Composing_Methods](#composing-methods);
2. [Simplifying conditional expressions](#Simplifying-conditional-expressions)
3. [Dealing with generalisation](#Dealing-with-generalisation)
4. [Moving Features between objects](#Moving-Features-between-objects)
5. [Organizing Data](#Organizing-Data)
6. [Simplifying method calls](#Simplifying-method-calls)


## Composing Methods

Esta categoría se enfoca en mejorar la estructura interna de los métodos, dividiéndolos en fragmentos más pequeños y más legibles


1. Extract Method (Extraer Método):
   - Consiste en identificar fragmentos de código que realizan una tarea específica y crear un nuevo método para encapsular esa funcionalidad.
   - Esta técnica ayuda a reducir la duplicación de código y a mejorar la legibilidad del método principal.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public void printCustomerDetails(Customer customer) {
         System.out.println("Name: " + customer.getName());
         System.out.println("Address: " + customer.getAddress());
         System.out.println("Phone: " + customer.getPhone());
         // Otras líneas de código para imprimir detalles adicionales del cliente...
     }
     
     // Código después de la refactorización (con Extract Method)
     public void printCustomerDetails(Customer customer) {
         printName(customer);
         printAddress(customer);
         printPhone(customer);
         // Otros métodos extraídos para imprimir detalles adicionales del cliente...
     }
     
     private void printName(Customer customer) {
         System.out.println("Name: " + customer.getName());
     }
     
     private void printAddress(Customer customer) {
         System.out.println("Address: " + customer.getAddress());
     }
     
     private void printPhone(Customer customer) {
         System.out.println("Phone: " + customer.getPhone());
     }
     ```

2. Inline Method (Incorporar Método):
   - Esta técnica consiste en eliminar un método que es muy corto o que simplemente delega la llamada a otro método.
   - Es útil cuando un método es demasiado simple y su existencia no aporta claridad al código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public int getDiscountedPrice() {
         return applyDiscount(price);
     }
     
     // Código después de la refactorización (con Inline Method)
     public int getDiscountedPrice() {
         return price * 0.9; // Aplicando descuento del 10%
     }
     ```

3. Extract Variable (Extraer Variable):
   - Consiste en identificar expresiones complejas o repetitivas y asignarlas a una variable con un nombre significativo.
   - Esta técnica mejora la legibilidad y facilita la comprensión del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public void calculateTotalPrice(List<Item> items) {
         double totalPrice = 0.0;
         for (Item item : items) {
             totalPrice += item.getQuantity() * item.getPrice() * (1 - item.getDiscount());
         }
         // Otras operaciones con totalPrice...
     }
     
     // Código después de la refactorización (con Extract Variable)
     public void calculateTotalPrice(List<Item> items) {
         double totalPrice = 0.0;
         for (Item item : items) {
             double itemTotal = item.getQuantity() * item.getPrice() * (1 - item.getDiscount());
             totalPrice += itemTotal;
         }
         // Otras operaciones con totalPrice...
     }
     ```


4. Inline Temp (Incorporar Temporal):
   - Consiste en reemplazar el uso de una variable temporal (temp) por la expresión directamente dentro del código.
   - Es útil cuando una variable temporal solo se utiliza una vez y no aporta claridad adicional al código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     double basePrice = calculateBasePrice();
     double tax = basePrice * 0.1;
     double total = basePrice + tax;
     
     // Código después de la refactorización (con Inline Temp)
     double total = calculateBasePrice() + calculateBasePrice() * 0.1;
     ```

5. Substitute Algorithm (Sustituir Algoritmo):
   - Consiste en reemplazar un algoritmo con otro más eficiente, manteniendo la misma funcionalidad.
   - Es útil cuando se encuentra un algoritmo más simple o más rápido para resolver un problema específico.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public int findMax(int[] array) {
         int max = array[0];
         for (int i = 1; i < array.length; i++) {
             if (array[i] > max) {
                 max = array[i];
             }
         }
         return max;
     }
     
     // Código después de la refactorización (con Substitute Algorithm)
     public int findMax(int[] array) {
         return Arrays.stream(array).max().orElse(0);
     }
     ```

6. Replace Method with Method Object (Redefinir Métodos como una Nueva Clase):
   - Consiste en convertir un método complejo en una nueva clase con sus propios atributos y métodos para manejar el cálculo.
   - Es útil cuando un método tiene una lógica complicada que puede dividirse en partes más pequeñas y separadas.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Order {
         public double calculateTotalPrice() {
             // Lógica complicada para calcular el precio total...
         }
     }
     
     // Código después de la refactorización (con Replace Method with Method Object)
     class Order {
         public double calculateTotalPrice() {
             PriceCalculator calculator = new PriceCalculator(this);
             return calculator.calculate();
         }
     }
     
     class PriceCalculator {
         private Order order;
         // Atributos y métodos para calcular el precio total...
         
         public PriceCalculator(Order order) {
             this.order = order;
         }
         
         public double calculate() {
             // Lógica simplificada para calcular el precio total...
         }
     }
     ```

Cada una de estas técnicas de refactorización busca mejorar diferentes aspectos del código relacionados con la composición de métodos. Es importante aplicar estas técnicas de manera consciente y considerando el contexto específico del código para obtener los mejores resultados y lograr un código más claro, estructurado y fácil de mantener.

[Volver_Indice](#Tecnicas-Refactoring)


## Simplifying conditional expressions
Esta categoría se centra en simplificar las expresiones condicionales y lógicas dentro del código.
Explicación: Al simplificar las condiciones y reducir la complejidad de las expresiones, se mejora la legibilidad y mantenibilidad del código


1. Decompose Conditional (Descomponer Condicional):
   - Consiste en dividir una expresión condicional compleja en partes más pequeñas y significativas utilizando variables booleanas para cada parte.
   - Esta técnica mejora la legibilidad del código y facilita la comprensión de las diferentes condiciones.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     if (isWeekend() && (temperature > 30 && temperature < 40) && !isRaining()) {
         // Realizar acciones para un día caluroso de fin de semana...
     }
     
     // Código después de la refactorización (con Decompose Conditional)
     boolean isHotWeekendDay = isWeekend() && (temperature > 30 && temperature < 40) && !isRaining();
     if (isHotWeekendDay) {
         // Realizar acciones para un día caluroso de fin de semana...
     }
     ```

2. Consolidate Conditional Expression (Consolidar Expresión Condicional):
   - Consiste en combinar múltiples expresiones condicionales que realizan la misma acción o tienen el mismo resultado.
   - Esta técnica reduce la repetición y simplifica el código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     if (isSeniorCitizen(age) || (isStudent(age) && hasStudentID()) || (isEmployee(age) && isManager(age))) {
         // Realizar acciones para ciertos grupos de personas...
     }
     
     // Código después de la refactorización (con Consolidate Conditional Expression)
     if (isEligibleForDiscount(age)) {
         // Realizar acciones para ciertos grupos de personas...
     }
     ```

3. Remove Control Flag (Eliminar Indicador de Control):
   - Consiste en reemplazar una variable booleana utilizada como un indicador de control en bucles o condiciones con una declaración "break" o "return".
   - Esta técnica elimina la necesidad de un indicador de control y simplifica el código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     boolean found = false;
     for (int i = 0; i < array.length; i++) {
         if (array[i] == target) {
             found = true;
             break;
         }
     }
     
     // Código después de la refactorización (con Remove Control Flag)
     for (int i = 0; i < array.length; i++) {
         if (array[i] == target) {
             return i;
         }
     }
     return -1;
     ```

4. Replace Conditional with Polymorphism (Reemplazar Condición con Polimorfismo):
   - Consiste en reemplazar una serie de condiciones con una jerarquía de clases utilizando el polimorfismo.
   - Esta técnica mejora la extensibilidad y la flexibilidad del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public double calculatePayment(Employee employee) {
         if (employee.getType() == EmployeeType.FULL_TIME) {
             return employee.getSalary();
         } else if (employee.getType() == EmployeeType.CONTRACT) {
             return employee.getHoursWorked() * employee.getHourlyRate();
         } else {
             // Lógica para otros tipos de empleados...
         }
     }
     
     // Código después de la refactorización (con Replace Conditional with Polymorphism)
     public double calculatePayment(Employee employee) {
         return employee.calculatePayment();
     }
     
     // Clase EmployeeType se convierte en una jerarquía de clases con polimorfismo
     abstract class Employee {
         public abstract double calculatePayment();
     }
     
     class FullTimeEmployee extends Employee {
         public double calculatePayment() {
             return getSalary();
         }
     }
     
     class ContractEmployee extends Employee {
         public double calculatePayment() {
             return getHoursWorked() * getHourlyRate();
         }
     }
     ```



5. Replace Nested Conditional with Guard Clauses (Reemplazar Condicionales Anidados con Banderas):
   - Consiste en reemplazar condicionales anidados por condicionales separados, conocidos como "guard clauses", para manejar casos especiales antes de las condiciones principales.
   - Esta técnica mejora la legibilidad y evita el anidamiento excesivo de condicionales.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public double calculateTotalPrice(Order order) {
         double totalPrice = 0.0;
         if (order != null) {
             if (order.getItems() != null) {
                 for (Item item : order.getItems()) {
                     totalPrice += item.getPrice();
                 }
             }
         }
         return totalPrice;
     }
     
     // Código después de la refactorización (con Replace Nested Conditional with Guard Clauses)
     public double calculateTotalPrice(Order order) {
         if (order == null || order.getItems() == null) {
             return 0.0;
         }
         double totalPrice = 0.0;
         for (Item item : order.getItems()) {
             totalPrice += item.getPrice();
         }
         return totalPrice;
     }
     ```

6. Introduce Null Object (Agregar Objeto Nulo):
   - Consiste en crear un objeto especial que representa la ausencia de un objeto nulo, evitando comprobaciones constantes de null.
   - Esta técnica mejora la legibilidad y reduce la necesidad de comprobaciones de null en el código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     public String getCustomerName(Customer customer) {
         if (customer != null) {
             return customer.getName();
         } else {
             return "Customer not available";
         }
     }
     
     // Código después de la refactorización (con Introduce Null Object)
     public String getCustomerName(Customer customer) {
         if (customer != null) {
             return customer.getName();
         } else {
             return NullCustomer.getInstance().getName();
         }
     }
     ```

7. Introduce Assertion (Agregar Aserciones):
   - Consiste en agregar aserciones o validaciones en el código para asegurar que las suposiciones sean verdaderas durante la ejecución.
   - Esta técnica ayuda a detectar errores temprano en el desarrollo y a garantizar la integridad de los datos.
   - Ejemplo en Java:
     ```java
     public int divide(int dividend, int divisor) {
         assert divisor != 0 : "Divisor should not be zero";
         return dividend / divisor;
     }
     ```

8. Consolidate Duplicate Fragments (Consolidar Fragmentos Duplicados):
   - Consiste en combinar fragmentos de código similares o idénticos para eliminar duplicación y mantener un único punto de mantenimiento.
   - Esta técnica mejora la mantenibilidad y evita errores al actualizar código duplicado.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     if (condition1) {
         // Lógica específica para condition1...
     } else {
         // Lógica compartida por todos los demás casos...
     }
     
     if (condition2) {
         // Lógica específica para condition2...
     } else {
         // Lógica compartida por todos los demás casos...
     }
     
     // Código después de la refactorización (con Consolidate Duplicate Fragments)
     if (condition1) {
         // Lógica específica para condition1...
     } else if (condition2) {
         // Lógica específica para condition2...
     } else {
         // Lógica compartida por todos los demás casos...
     }
     ```

Es importante aplicar estas técnicas de refactorización con cuidado y considerando el contexto del código para obtener los mejores resultados. Cada una de estas técnicas aborda diferentes aspectos relacionados con la simplificación de expresiones condicionales y la mejora del código en general.

[Volver_Indice](#Tecnicas-Refactoring)

## Dealing with generalisation

Esta categoría se centra en mejorar la estructura de la herencia y las jerarquías de clases.
Explicación: Al eliminar duplicaciones y refinar la jerarquía de clases, se mejora la cohesión y la reutilización del código.


1. Pull Up Field (Subir Atributo):
   - Consiste en mover un atributo desde una subclase a una superclase para promover la reutilización y evitar duplicación de código.
   - Esta técnica mejora la cohesión de la jerarquía de clases.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Animal {
         // Atributos y métodos comunes para todas las subclases de Animal...
     }
     
     class Dog extends Animal {
         private String breed;
         // Otros atributos y métodos específicos para Dog...
     }
     
     // Código después de la refactorización (con Pull Up Field)
     class Animal {
         // Atributos y métodos comunes para todas las subclases de Animal...
         private String breed;
     }
     
     class Dog extends Animal {
         // Métodos específicos para Dog...
     }
     ```

2. Pull Up Method (Subir Método):
   - Consiste en mover un método desde una subclase a una superclase para promover la reutilización y evitar duplicación de código.
   - Esta técnica mejora la cohesión y la reutilización del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Shape {
         // Atributos y métodos comunes para todas las formas...
     }
     
     class Circle extends Shape {
         public double calculateArea() {
             // Lógica para calcular el área del círculo...
         }
     }
     
     // Código después de la refactorización (con Pull Up Method)
     class Shape {
         // Atributos y métodos comunes para todas las formas...
     
         public double calculateArea() {
             // Implementación predeterminada o lanzar una excepción en caso de que no tenga sentido para la forma base...
         }
     }
     
     class Circle extends Shape {
         // Lógica específica para Circle...
     }
     ```

3. Push Down Field (Bajar Atributo):
   - Consiste en mover un atributo desde una superclase a una subclase si es específico de la subclase y no se utiliza en la superclase.
   - Esta técnica mejora la cohesión de la jerarquía de clases.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Vehicle {
         // Atributos y métodos comunes para todos los vehículos...
         private int maxSpeed;
     }
     
     class Car extends Vehicle {
         // Métodos específicos para Car...
     }
     
     // Código después de la refactorización (con Push Down Field)
     class Vehicle {
         // Atributos y métodos comunes para todos los vehículos...
     }
     
     class Car extends Vehicle {
         private int maxSpeed; // Ahora el atributo está específico para Car...
         // Métodos específicos para Car...
     }
     ```

4. Push Down Method (Bajar Método):
   - Consiste en mover un método desde una superclase a una subclase si es específico de la subclase y no se utiliza en la superclase.
   - Esta técnica mejora la cohesión y la reutilización del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Vehicle {
         // Atributos y métodos comunes para todos los vehículos...
         public void start() {
             // Lógica para arrancar el vehículo...
         }
     }
     
     class Car extends Vehicle {
         // Métodos específicos para Car...
     }
     
     // Código después de la refactorización (con Push Down Method)
     class Vehicle {
         // Atributos y métodos comunes para todos los vehículos...
     }
     
     class Car extends Vehicle {
         // Métodos específicos para Car...
         public void start() {
             // Lógica para arrancar el coche...
         }
     }
     ```

5. Extract Subclass (Extraer Subclase):
   - Consiste en crear una nueva subclase a partir de una parte de la funcionalidad de la superclase, cuando algunas instancias de la clase tienen comportamientos diferentes.
   - Esta técnica mejora la cohesión y evita condicionales complejos en la superclase.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Employee {
         private String type;
         // Otros atributos y métodos...
     }
     
     // Código después de la refactorización (con Extract Subclass)
     abstract class Employee {
         // Atributos y métodos comunes para todos los empleados...
     }
     
     class FullTimeEmployee extends Employee {
         // Métodos específicos para FullTimeEmployee...
     }
     
     class ContractEmployee extends Employee {
         // Métodos específicos para ContractEmployee...
     }
     ```

6. Extract Superclass (Extraer Superclase):
   - Consiste en crear una nueva superclase para agrupar características comunes de dos o más subclases.
   - Esta técnica mejora la cohesión y la reutilización del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Car {
         // Atributos y métodos específicos para Car...
     }
     
     class Motorcycle {
         //
Tienes razón, faltaron algunas técnicas dentro de la clasificación "Dealing with Generalisation". A continuación, te explico las técnicas restantes:

1. Collapse Hierarchy (Colapsar Jerarquía):
   - Consiste en eliminar una superclase o subclase cuando la jerarquía de clases se vuelve innecesariamente compleja o redundante.
   - Esta técnica simplifica la jerarquía y mejora la estructura del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Animal {
         // Atributos y métodos comunes para todos los animales...
     }
     
     class Dog extends Animal {
         // Métodos y atributos específicos para perros...
     }
     
     class Cat extends Animal {
         // Métodos y atributos específicos para gatos...
     }
     
     // Código después de la refactorización (con Collapse Hierarchy)
     class Dog {
         // Atributos y métodos específicos para perros...
     }
     
     class Cat {
         // Atributos y métodos específicos para gatos...
     }
     ```

2. Form Template Method (Formar Método Plantilla):
   - Consiste en definir un esqueleto de algoritmo en una superclase y permitir que las subclases implementen pasos específicos del algoritmo.
   - Esta técnica mejora la reutilización y flexibilidad del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     abstract class Game {
         public void play() {
             initialize();
             start();
             // Lógica común para todos los juegos...
             end();
         }
         
         public abstract void initialize();
         public abstract void start();
         public abstract void end();
     }
     
     // Código después de la refactorización (con Form Template Method)
     abstract class Game {
         public void play() {
             initialize();
             start();
             // Lógica común para todos los juegos...
             end();
         }
         
         public abstract void initialize();
         public abstract void start();
         public abstract void end();
     }
     
     class FootballGame extends Game {
         public void initialize() {
             // Inicialización específica para el juego de fútbol...
         }
         
         public void start() {
             // Inicio específico para el juego de fútbol...
         }
         
         public void end() {
             // Término específico para el juego de fútbol...
         }
     }
     ```

3. Replace Inheritance with Delegation (Reemplazar Herencia con Delegación):
   - Consiste en reemplazar la herencia con objetos delegados para reutilizar el código de una clase sin extender su jerarquía.
   - Esta técnica evita problemas de acoplamiento y mejora la flexibilidad.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Logger {
         // Métodos de registro comunes para todas las clases que heredan Logger...
     }
     
     class EmailLogger extends Logger {
         // Métodos específicos para EmailLogger...
     }
     
     // Código después de la refactorización (con Replace Inheritance with Delegation)
     class Logger {
         // Métodos de registro comunes para todas las clases...
     }
     
     class EmailLogger {
         private Logger logger;
         
         // Métodos específicos para EmailLogger...
     }
     ```

4.  Replace Delegation with Inheritance (Reemplazar Delegación con Herencia):
    - Consiste en reemplazar objetos delegados con herencia cuando la delegación se vuelve innecesariamente compleja.
    - Esta técnica simplifica el código y mejora la estructura de la jerarquía.
    - Ejemplo en Java:
      ```java
      // Código antes de la refactorización
      class Logger {
          // Métodos de registro comunes para todas las clases...
      }
      
      class EmailLogger {
          private Logger logger;
          
          // Métodos específicos para EmailLogger...
      }
      
      // Código después de la refactorización (con Replace Delegation with Inheritance)
      class Logger {
          // Métodos de registro comunes para todas las clases que heredan Logger...
      }
      
      class EmailLogger extends Logger {
          // Métodos específicos para EmailLogger...
      }
      ```

Estas técnicas de refactorización dentro de la clasificación "Dealing with Generalisation" nos ayudan a mejorar la jerarquía de clases y la gestión de la herencia, lo que conduce a un código más claro, flexible y mantenible. Es importante aplicar estas técnicas con cuidado y considerando el contexto del código para obtener los mejores resultados y lograr una estructura de clases coherente y efectiva.

[Volver_Indice](#Tecnicas-Refactoring)


## Moving Features between objects

Esta categoría se centra en reorganizar y redistribuir las responsabilidades entre las clases para mejorar la cohesión y reducir el acoplamiento.
Explicación: Al mover métodos o atributos entre clases, se busca colocarlos en la clase más adecuada para que cada clase tenga una responsabilidad clara y específica.


1. Move Method (Mover Método):
   - Consiste en trasladar un método de una clase a otra si ese método se utiliza más en la segunda clase o si su lógica está más relacionada con la segunda clase.
   - Esta técnica mejora la cohesión y reduce el acoplamiento innecesario.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Customer {
         // Atributos y métodos específicos para Customer...
         public void calculateDiscount() {
             // Lógica para calcular el descuento del cliente...
         }
     }
     
     class Order {
         // Atributos y métodos específicos para Order...
     }
     
     // Código después de la refactorización (con Move Method)
     class Customer {
         // Atributos y métodos específicos para Customer...
     }
     
     class Order {
         // Atributos y métodos específicos para Order...
         
         public void calculateDiscount(Customer customer) {
             // Lógica para calcular el descuento del cliente...
         }
     }
     ```

2. Move Field (Mover Atributo):
   - Consiste en trasladar un atributo de una clase a otra si ese atributo está más relacionado con la segunda clase o si se utiliza más en la segunda clase.
   - Esta técnica mejora la cohesión y reduce el acoplamiento innecesario.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Customer {
         private String address;
         // Otros atributos y métodos específicos para Customer...
     }
     
     class Order {
         // Atributos y métodos específicos para Order...
     }
     
     // Código después de la refactorización (con Move Field)
     class Customer {
         // Otros atributos y métodos específicos para Customer...
     }
     
     class Order {
         private String customerAddress;
         // Atributos y métodos específicos para Order...
     }
     ```

3. Extract Class (Extraer Clase):
   - Consiste en crear una nueva clase para agrupar atributos y métodos que están fuertemente relacionados en una clase existente.
   - Esta técnica mejora la cohesión y evita la acumulación de responsabilidades en una sola clase.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Employee {
         private String name;
         private String address;
         private double salary;
         // Otros atributos y métodos específicos para Employee...
     }
     
     // Código después de la refactorización (con Extract Class)
     class Employee {
         private String name;
         private Address address;
         // Otros atributos y métodos específicos para Employee...
     }
     
     class Address {
         // Atributos y métodos específicos para Address...
     }
     ```

4. Inline Class (Incorporar Clase):
   - Consiste en eliminar una clase que proporciona poca funcionalidad o que no agrega valor distintivo y mover sus atributos y métodos directamente a la clase que la utiliza.
   - Esta técnica mejora la simplicidad y reduce la complejidad del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Address {
         private String street;
         private String city;
         // Otros atributos y métodos específicos para Address...
     }
     
     class Customer {
         private String name;
         private Address address;
         // Otros atributos y métodos específicos para Customer...
     }
     
     // Código después de la refactorización (con Inline Class)
     class Customer {
         private String name;
         private String street;
         private String city;
         // Otros atributos y métodos específicos para Customer...
     }
     ```

5. Hide Delegate (Ocultar Delegado):
   - Consiste en ocultar los métodos de un objeto delegado detrás de los métodos de su clase contenedora, reduciendo así la dependencia entre las clases.
   - Esta técnica mejora la encapsulación y la flexibilidad del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Department {
         private Employee manager;
         
         public Employee getManager() {
             return manager;
         }
     }
     
     class Employee {
         private String name;
         // Otros atributos y métodos específicos para Employee...
     }
     
     // Código después de la refactorización (con Hide Delegate)
     class Department {
         private Employee manager;
         
         public String getManagerName() {
             return manager.getName();
         }
     }
     
     class Employee {
         private String name;
         // Otros atributos y métodos específicos para Employee...
     }
     ```

6. Remove Middle Man (Eliminar Hombre Intermedio):
   - Consiste en eliminar una clase que actúa como intermediario entre dos clases y hacer que las clases que la utilizan interactúen directamente entre sí.
   - Esta técnica reduce la complejidad y mejora la eficiencia del código.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Department {
         private


7. Introduce Local Extension (Introducir Extensión Local):
   - Consiste en agregar métodos o atributos a una clase existente utilizando una subclase para evitar modificar la clase original (cuando no es posible o deseable hacerlo).
   - Esta técnica permite extender la funcionalidad de una clase sin alterar su código fuente.
   - Ejemplo en Java:
     ```java
     // Código antes de la refactorización
     class Date {
         private LocalDate date;
         
         public Date(LocalDate date) {
             this.date = date;
         }
         
         public LocalDate getDate() {
             return date;
         }
     }
     
     // Código después de la refactorización (con Introduce Local Extension)
     class ExtendedDate extends Date {
         public ExtendedDate(LocalDate date) {
             super(date);
         }
         
         public String getFormattedDate() {
             // Lógica para formatear la fecha en un formato específico...
         }
     }
     ```

En este ejemplo, la clase `Date` se extiende mediante la subclase `ExtendedDate`, que agrega un nuevo método `getFormattedDate()` para obtener la fecha en un formato específico. De esta manera, podemos extender la funcionalidad de la clase `Date` sin modificar su código fuente.

[Volver_Indice](#Tecnicas-Refactoring)

## Organizing Data


1. Encapsulate Field (Encapsular Campo): Consiste en ocultar el acceso directo a un campo de la clase mediante métodos getter y setter. Esto nos permite controlar y validar el acceso a los datos de la clase.

Ejemplo:

```java
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
}
```


2. Replace Data Value with Object (Reemplazar Valor de Datos(Primitivo) con Objeto): Cuando tenemos datos compuestos que tienen sentido como un todo, podemos encapsularlos en un objeto para mejorar la claridad y el mantenimiento del código.

Ejemplo:

```java
public class Address {
    private String street;
    private String city;
    private String zipCode;

    // Constructor, getters y setters
}

public class Person {
    private String name;
    private Address address;

    // Constructor, getters y setters
}
```


3. Replace Array with Object (Reemplazar Arreglo con Objeto): Cuando un arreglo contiene diferentes tipos de datos o lleva demasiada responsabilidad, podemos reemplazarlo con un objeto para tener una mejor representación y manejo de los datos.

Ejemplo:

```java
public class Product {
    private String name;
    private double price;

    // Constructor, getters y setters
}

public class Inventory {
    private List<Product> products;

    // Constructor, getters y setters
}
```

4. Duplicate Observed Data (Duplicar Datos Observados): Cuando tenemos datos que son observados y actualizados en diferentes lugares, podemos duplicar esos datos en lugar de compartirlos para reducir la complejidad.

Ejemplo:

```java
public class TemperatureSensor {
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        // Notificar a otros componentes sobre el cambio de temperatura
    }
}

public class Display {
    private double temperature;

    public void updateTemperature(double temperature) {
        this.temperature = temperature;
        // Actualizar la interfaz gráfica con la nueva temperatura
    }
}
```

5. Change Unidirectional Association to Bidirectional (Cambiar Asociación Unidireccional a Bidireccional): Cuando tenemos una asociación unidireccional entre dos clases, podemos agregar una asociación inversa para simplificar el acceso a los datos.

Ejemplo:

```java
public class Order {
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

public class Customer {
    private List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }
}
```

6. Change Bidirectional Association to Unidirectional (Cambiar Asociación Bidireccional a Unidireccional): En contraste con la técnica anterior, cuando una asociación bidireccional no es necesaria, podemos eliminar una de las direcciones para reducir la complejidad.

Ejemplo:

```java
public class Order {
    // Otros atributos de la orden

    public Customer getCustomer() {
        // Lógica para obtener el cliente relacionado con la orden
    }
```


7. Encapsulate Collection (Encapsular Colección): Cuando una clase expone una colección, en lugar de devolverla directamente, podemos proporcionar métodos para agregar o eliminar elementos y ocultar la colección detrás de métodos de acceso.

Ejemplo:

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}

public class Item {
    // Atributos y métodos de la clase Item
}
```

8. Replace Magic Number (Reemplazar "Número Mágico"): Cuando un número aparece varias veces en el código sin una explicación clara de su significado, podemos reemplazarlo por una constante con un nombre significativo.

Ejemplo:

```java
public class Circle {
    private static final double PI = 3.14159;
    private double radius;

    public double calculateArea() {
        return PI * radius * radius;
    }
}
```

9. Replace Type Code with Classes/Interfaces (Reemplazar "Código de Tipo" con Clases/Interfaces): Cuando utilizamos un código numérico para representar diferentes tipos o estados de un objeto, podemos reemplazar esos códigos con clases o interfaces para tener una estructura más clara y segura.

Ejemplo:

```java
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    @Override
    public double calculateArea() {
        return width * height;
    }
}
```

10. Replace Subclasses with Fields (Reemplazar Subclases con Campos): Cuando varias subclases tienen solo un campo diferente entre ellas, podemos reemplazar esas subclases con un campo en la clase principal.

Ejemplo:

```java
abstract class Vehicle {
    // Otros atributos y métodos comunes
}

class Car extends Vehicle {
    private boolean isConvertible;

    // Otros atributos y métodos específicos para Car
}

class Motorcycle extends Vehicle {
    private int numWheels;

    // Otros atributos y métodos específicos para Motorcycle
}

// Reemplazar subclases con campos

class Vehicle {
    private boolean isConvertible;
    private int numWheels;

    // Otros atributos y métodos comunes
}
```

[Volver_Indice](#Tecnicas-Refactoring)

## Simplifying method calls 
Dentro de la clasificación "Simplifying Method Calls" en el contexto de refactorización, existen diversas técnicas que nos ayudan a simplificar las llamadas a métodos y hacer el código más limpio y fácil de entender. A continuación, te explico cada una de ellas y te proporciono un ejemplo en Java para ilustrar su uso:

1. Rename Method (Renombrar Método): Consiste en renombrar un método para que su nombre refleje mejor su funcionalidad y propósito.

Ejemplo:

```java
public class StringUtils {
    public static String reverseString(String str) {
        // Código para revertir la cadena
    }
}

// Uso del método renombrado
String reversed = StringUtils.reverseString("Hello");
```


2. Remove Parameter (Eliminar Parámetro): Consiste en eliminar un parámetro de un método cuando ya no es necesario.

Ejemplo:

```java
public class StringUtils {
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }
}

// Uso del método sin el parámetro eliminado
String result = StringUtils.concatenateStrings("Hello, ", "World!");
```

3. Separate Query from Modifier (Separar Consulta del Modificador): Consiste en dividir un método que realiza una acción y también devuelve un resultado en dos métodos separados, uno para la acción y otro para la consulta.

Ejemplo:

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    // Método original que realiza la acción y devuelve un resultado
    public boolean addItem(Item item) {
        boolean added = items.add(item);
        // Lógica adicional para procesar el resultado
        return added;
    }

    // Método separado para la consulta
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
```

4. Parameterize Method (Parametrizar Método): Consiste en generalizar un método para que pueda manejar diferentes casos al agregar parámetros que controlen su comportamiento.

Ejemplo:

```java
public class MathUtils {
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Método parametrizado para realizar diferentes operaciones
    public static int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return multiply(a, b);
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }
}

// Uso del método parametrizado
int result1 = MathUtils.calculate(2, 3, "+"); // 5
int result2 = MathUtils.calculate(2, 3, "*"); // 6
```


5. Preserve Whole Object (Preservar Objeto Completo): Consiste en pasar un objeto completo como parámetro en lugar de pasar varios atributos individuales para mejorar la claridad y la eficiencia.

Ejemplo:

```java
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    // Método que utiliza un objeto completo como parámetro
    public boolean contains(Point point) {
        return point.x >= topLeft.x && point.x <= bottomRight.x &&
               point.y >= topLeft.y && point.y <= bottomRight.y;
    }
}

// Uso del método con un objeto completo como parámetro
Point point = new Point(3, 4);
Rectangle rectangle = new Rectangle(new Point(2, 3), new Point(6, 8));
boolean containsPoint = rectangle.contains(point);
```


6. Parameterize Method (Parametrizar Método): Consiste en generalizar un método para que pueda manejar diferentes casos al agregar parámetros que controlen su comportamiento.

Ejemplo:

```java
public class MathUtils {
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Método parametrizado para realizar diferentes operaciones
    public static int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return multiply(a, b);
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }
}

// Uso del método parametrizado
int result1 = MathUtils.calculate(2, 3, "+"); // 5
int result2 = MathUtils.calculate(2, 3, "*"); // 6
```

7. Replace Parameter with Explicit Methods (Reemplazar Parámetro con Métodos Explícitos): Consiste en reemplazar un parámetro con varios métodos explícitos que reflejen los diferentes casos posibles.

Ejemplo:

```java
public class ShapeCalculator {
    public static int calculateRectangleArea(int width, int height) {
        return width * height;
    }

    public static int calculateCircleArea(int radius) {
        return (int) (Math.PI * radius * radius);
    }
}

// Uso de los métodos explícitos en lugar de un parámetro
int rectangleArea = ShapeCalculator.calculateRectangleArea(4, 5);
int circleArea = ShapeCalculator.calculateCircleArea(3);
```

8. Replace Parameter with Method Call (Reemplazar Parámetro con Llamada a Método): Consiste en reemplazar un valor de parámetro con una llamada a un método que devuelve ese valor.

Ejemplo:

```java
public class MathUtils {
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Método que utiliza una llamada a otro método para obtener un parámetro
    public static int calculateWithMultiplier(int a, int bMultiplier) {
        return a * multiply(bMultiplier, 2);
    }
}

// Uso del método con llamada a otro método para obtener un parámetro
int result = MathUtils.calculateWithMultiplier(3, 5); // 3 * (5 * 2) = 30
```

9. Hide Method (Ocultar Método): Consiste en hacer que un método sea privado si ya no es utilizado o necesario desde fuera de la clase.

Ejemplo:

```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }

    // Método oculto que ya no se utiliza desde fuera de la clase
    private static int subtract(int a, int b) {
        return a - b;
    }
}
```

10. Replace Error Code with Exception (Reemplazar Código de Error con Excepción): Consiste en reemplazar valores de código de error devueltos por un método con el lanzamiento de excepciones para indicar que ha ocurrido un error.

Ejemplo:

```java
public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("División por cero no permitida");
        }
        return a / b;
    }
}

// Uso del método con manejo de excepciones
try {
    int result = MathUtils.divide(10, 0);
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
```

11. Replace Exception with Test (Reemplazar Excepción con Prueba): Consiste en evitar el uso de excepciones para controlar flujos normales de programa y, en su lugar, realizar pruebas para validar condiciones especiales.

Ejemplo:

```java
public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("División por cero no permitida");
        }
        return a / b;
    }
}

// Validación con pruebas en lugar de manejo de excepciones
int result = MathUtils.divide(10, 5);
assert result == 2 : "Resultado incorrecto";
```


[Volver_Indice](#Tecnicas-Refactoring)