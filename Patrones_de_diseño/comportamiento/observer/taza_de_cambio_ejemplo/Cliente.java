package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.observer.taza_de_cambio_ejemplo;
public class Cliente {
    public static void main(String[] args) {
        System.out.println("DEMO OBSERVER");
        Subject sujeto1= new Subject();
        new PesoArg(sujeto1);
        new PesoMX(sujeto1);

        System.out.println("Cambio a 10$:");
        sujeto1.setEstado(10);
        System.out.println("Cambio a 100$:");
        sujeto1.setEstado(100);

    }
}
