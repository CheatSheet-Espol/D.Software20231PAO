package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.Chain_of_responsability.Ejemplo_DevolucionProducto;


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