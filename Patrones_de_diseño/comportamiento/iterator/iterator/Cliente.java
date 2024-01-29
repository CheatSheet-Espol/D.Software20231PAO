/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iterator;


import iterator.BodegaIterator;
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
        
        }
}
