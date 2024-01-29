# SINGLE RESPONSABILITY
Concepto: Una clase debe tener una única razón para cambiar, es decir, debe tener una única responsabilidad.
Caso de Uso: Aplicar el SRP garantiza que una clase no esté sobrecargada con múltiples responsabilidades y hace que sea más fácil de mantener y extender.

Los metodos que se encuentren dentro de una clase deben estar todos relacionados a la misma responsabilidad

~~~java
ANTES:
class ReportGenerator {
    public void generatePDFReport() {
        // Generar un informe en formato PDF
    }
    
    public void generateCSVReport() {
        // Generar un informe en formato CSV
    }
}

DESPUES:
class PDFReportGenerator {
    public void generatePDFReport() {
        // Generar un informe en formato PDF
    }
}

class CSVReportGenerator {
    public void generateCSVReport() {
        // Generar un informe en formato CSV
    }
}
~~~
# OPEN-CLOSED [⬆️](#single-responsability)
Concepto: Las clases deben estar abiertas para la extensión pero cerradas para la modificación. Debes poder agregar nuevas funcionalidades sin modificar el código existente.
Se usa por lo general interfaces para agregar comportamiento, se prioriza el polimorfismo.

~~~java
ANTES:
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}


DESPUES:
interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}

~~~


# LISKOV SUBSTITUTION [⬆️](#single-responsability)
Concepto: Las instancias de una clase derivada deben poder sustituirse por instancias de la clase base sin afectar la corrección del programa.
Los metodos no deben tener comportamientos extraños respecto de la clase base, se usan interfaces para agregar solo el comportamiento necesario.

~~~java
ANTES:
class Bird {
    void fly() {
        // Algunas aves pueden volar
    }
}

class Ostrich extends Bird {
    void fly() {
        // Las avestruces no pueden volar, pero necesitamos implementar el método
    }
}


DESPUES:
abstract class Bird {
    abstract void move();
}

class Sparrow extends Bird {
    void move() {
        // Sparrows pueden volar
    }
}

class Ostrich extends Bird {
    void move() {
        // Las avestruces no pueden volar, pero implementamos move() de manera apropiada
    }
}

~~~

# INTERFACE SEGREGATION [⬆️](#single-responsability)

Concepto: Los clientes no deben verse obligados a depender de interfaces que no utilizan. Divide interfaces grandes en interfaces más pequeñas y específicas.
Caso de Uso: Evita que las clases implementen métodos que no necesitan, lo que hace que el código sea más claro y mantenible.
~~~java
ANTES:
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        // Realizar trabajo
    }

    public void eat() {
        // No tiene sentido para un robot comer
    }
}


DESPUES:
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() {
        // Realizar trabajo
    }
}

~~~

# DEPENDENCY INVERSION [⬆️](#single-responsability)

Concepto: Las clases de alto nivel no deben depender de las clases de bajo nivel. Ambas deben depender de abstracciones. Abstracciones no deben depender de detalles, los detalles deben depender de abstracciones.
Las instancias de otras clases siempre tienen que intentar ser de una interfaz o una clase abstracta.

~~~java
ANTES:
class LightSwitch {
    private LightBulb bulb;

    public LightSwitch() {
        this.bulb = new LightBulb();
    }

    public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}


DESPUES:
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        // Encender la bombilla
    }

    public void turnOff() {
        // Apagar la bombilla
    }
}

class LightSwitch {
    private Switchable device;

    public LightSwitch(Switchable device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}

~~~