package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.Chain_of_responsability.Ejemplo_DevolucionProducto;

public class GerenteTienda implements Staff {

    public GerenteTienda(){
    }
    public void procesar(Producto p){
        System.out.println("Gerente: Listo, tiene la aprobación este producto para su devolucion, acerquese a caja por favor y tenga un buen día");
    }
}
