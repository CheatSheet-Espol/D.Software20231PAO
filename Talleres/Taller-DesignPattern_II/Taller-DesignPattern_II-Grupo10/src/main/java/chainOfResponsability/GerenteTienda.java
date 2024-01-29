package chainOfResponsability;

import taller.designpattern.Producto;

public class GerenteTienda implements Staff {

    public GerenteTienda(){
    }
    public void procesar(Producto p){
        System.out.println("Gerente: Listo, tiene la aprobación este producto para su devolucion, acerquese a caja por favor y tenga un buen día");
    }
}
