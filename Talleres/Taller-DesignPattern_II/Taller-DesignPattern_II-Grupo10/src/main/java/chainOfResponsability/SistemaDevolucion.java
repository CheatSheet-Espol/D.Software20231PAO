package chainOfResponsability;

import taller.designpattern.Producto;
//Esta clase solo existe para abstraer aun más la cadena de responsabilidades del cliente, por eso no se representó en el diagrama.
public class SistemaDevolucion {
    public SistemaDevolucion(Producto p){
        GerenteTienda g1= new GerenteTienda();
        JefeInventario j1= new JefeInventario(g1);
        Tecnico t1= new Tecnico(j1);
        AtencionUsuario a1= new AtencionUsuario(t1);

        a1.procesar(p);
    }
}
