package chainOfResponsability;

import taller.designpattern.Producto;
import taller.designpattern.Bodega;
public class AtencionUsuario implements Staff {

    public Staff sucesor;

    public AtencionUsuario(Staff sucesor){
        this.sucesor=sucesor;
    }

    public void procesar(Producto p){
        if(p.periodoGarantia){
            System.out.println("El producto"+ p.nombre+"se encuentra en periodo de garantia, se enviará al tecnico para revision");
            sucesor.procesar(p);
        }else{
            System.out.println("Error,"+ p.nombre+" no se encuentra en periodo de garantia garantía.");
        }
        
    }
}