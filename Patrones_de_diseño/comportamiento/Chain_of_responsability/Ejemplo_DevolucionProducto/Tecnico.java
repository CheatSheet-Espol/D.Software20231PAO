package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.Chain_of_responsability.Ejemplo_DevolucionProducto;

import java.util.ArrayList;

public class Tecnico implements Staff {
    public Staff sucesor;
    public Tecnico(Staff sucesor){
        this.sucesor=sucesor;
    }
    public void procesar(Producto p){
        String [] fallos={"CableRoto", "BotonesDañados", "CircuitoQuemado"};
        ArrayList failures= new ArrayList<>();
        failures.add("CableRoto");
        failures.add("BotonesDañados");
        failures.add("CircuitoQuemado");
        

        if(failures.contains(p.fallo)){
            System.out.println("El fallo está dentro de la garantía, enviando a jefe de inventario");
            sucesor.procesar(p);
        }else{
            System.out.println("Su daño no lo cubre la garantía. Lo sentimos...");
        }

    }
}
