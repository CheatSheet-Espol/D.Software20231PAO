package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.observer.taza_de_cambio_ejemplo;

public class PesoMX extends Observador{
    private double valorCambio= 3.25;
    public PesoMX(Subject sujeto){
        this.sujeto=sujeto;
        this.sujeto.agregar(this);
    }
    @Override
    public void actualizar(){
        System.out.println("MX: "+(sujeto.getEstado()*valorCambio));
    }
}
