/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.comportamiento.Chain_of_responsability.Ejemplo_DevolucionProducto;
/**
 *
 * @author lancervs
 */
public class Cliente {

    public static void main(String[] args) {
        

        System.out.println("DEMO: CHAIN OF RESPONSABILITY");
        //Producto que cumple con todos los requerimientos. LLega hasta el final de la cadena.
        Producto p1= new Producto(" Mac ", true
        , "BotonesDañados", 1200, true);
        System.out.println("");
        //Producto que cumple con todos los requerimientos. LLega hasta el Jefe de inventario y le hace la devolucion
        Producto p2= new Producto(" Licuadora ", true
        , "BotonesDañados", 600, true);
        //Producto que llega hasta el Jefe pero no existe en bodega.
        Producto p3 = new Producto(" olla arrocera ", true, "CircuitoQuemado", 400, false);
        //Producto llega hasta el tecnico pero no cubre el daño la garantia
        Producto p4 = new Producto(" Microondas ", true, "PuertaDañada", 350, false);

        //Producto llega hasta Atencion usuario pero no se encuentra en garantia
        Producto p5= new Producto(" cocina electrica ", false, null, 0, false);

        SistemaDevolucion s1= new SistemaDevolucion(p1);
        System.out.println("");
        SistemaDevolucion s2= new SistemaDevolucion(p2);
        System.out.println("");
        SistemaDevolucion s3= new SistemaDevolucion(p3);
        System.out.println("");
        SistemaDevolucion s4= new SistemaDevolucion(p4);
        System.out.println("");
        SistemaDevolucion s5= new SistemaDevolucion(p5);
        System.out.println("");



    }
}
