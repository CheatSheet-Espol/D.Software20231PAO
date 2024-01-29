package FacadePattern;

import java.util.ArrayList;

public class PlataformaBase {
    protected ArrayList<Product> catalogo = new ArrayList<Product>();
    protected ArrayList<Pedidos> historialPedidos = new ArrayList<Pedidos>();


    protected void consultarCatalogo(){
        System.out.println("Mostrando la lista de productos disponibles...");
    }
    

}
