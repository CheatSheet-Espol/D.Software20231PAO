package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.observer.taza_de_cambio_ejemplo;

public abstract class Observador {
    protected Subject sujeto;
    public abstract void actualizar();
}
