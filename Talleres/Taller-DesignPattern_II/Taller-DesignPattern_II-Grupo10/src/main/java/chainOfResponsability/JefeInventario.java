package chainOfResponsability;

import taller.designpattern.Producto;

public class JefeInventario implements Staff {
    public Staff sucesor;

    public JefeInventario(Staff sucesor){
        this.sucesor=sucesor;
    }
    public void procesar(Producto p){
        if(p.precio>1000 && p.enBodega){
            System.out.println("El producto supera el limite pero sí está en bodega, se enviará a ser verificado por el Gerente de la tienda...");
            sucesor.procesar(p);
        }else if(p.precio<1000 && p.enBodega){
            System.out.println("Disculpe los inconvenientes, aquí está el re cambio de su producto... :D");

        }else{
            System.out.println("Lo sentimos no se encuentra el producto en bodega para su devolucion...");
        }
        
    }
}
