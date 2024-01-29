/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package taller.designpattern;

import PatronStrategy.ContextoDistribucion;
import PatronStrategy.TransAutomotrizEstrategia;
import PatronStrategy.TransCiclistaEstrategia;
import iterator.BodegaIterator;
import chainOfResponsability.SistemaDevolucion;
/**
 *
 * @author lancervs
 */
public class Cliente {

    public static void main(String[] args) {
        System.out.println("DEMO: iterator");
        Bodega bodega = new Bodega("PRODUCTO DISPONIBLES");
        bodega.addProducto(new Producto(1, "laptop", 500));
        bodega.addProducto(new Producto(2, "telefono nokia", 1000000));
        bodega.addProducto(new Producto(3, "impresora epson", 460));
        
        //EL USUARIO QUIERE IR REVISANDO UNO POR UNO ESOS PRODUCTOS
        //PARA ELLO ES NECESARIO UN ITERATOR DE LA BODEGA ACTUAL
        BodegaIterator iteratorBodega = new BodegaIterator(bodega);
        System.out.println("\n El usuario posee un iterador que le permitirá obtener los elementos cada vez que lo requiera");
        System.out.println("Primer Elemento: ");
        iteratorBodega.getNext();
        System.out.println("Segundo Elemento: ");
        iteratorBodega.getNext();
        System.out.println("Tercer Elemento: ");
        iteratorBodega.getNext();
        
        //Recordemos que ya si pide una vez más, no podrá ya que hay solo tres elementos
        //Se podría preguntar al cliente si desea repetir la iteración o pasar a iterar en otra bodega
        iteratorBodega.getNext();

        
                
        //--Aplicando el patrón de diseño Strategy para el segundo parrafo--
        
        System.out.println("DEMO: Strategy");
        //Se elije el medio de transporte
        ContextoDistribucion distribucion = new ContextoDistribucion(new TransCiclistaEstrategia());
           //Si se desea 
		  //se pueden cambiar las vías de transporte al momento de ejecución del programa 
		distribucion.setEstrategia(new TransAutomotrizEstrategia());

		distribucion.ejecutarDistribucion();
        System.out.println("");


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
