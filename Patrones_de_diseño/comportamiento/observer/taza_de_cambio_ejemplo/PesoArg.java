package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.observer.taza_de_cambio_ejemplo;

public class PesoArg extends Observador{
    private double valorCambio= 19.07;
    public PesoArg(Subject sujeto){
        this.sujeto=sujeto;
        this.sujeto.agregar(this);
    }
    @Override
    public void actualizar(){
        System.out.println("Arg: "+(sujeto.getEstado()*valorCambio));
    }
}
