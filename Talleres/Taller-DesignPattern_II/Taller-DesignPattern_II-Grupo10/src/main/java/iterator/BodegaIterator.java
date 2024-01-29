/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

import java.util.List;
import taller.designpattern.Bodega;
import taller.designpattern.Producto;

/**
 *
 * @author lancervs
 */
public class BodegaIterator implements ProductoIterator {

    private Bodega bodega;
    private Producto actualProducto;
    private int indiceActual;
    
    public BodegaIterator(Bodega b){
        this.bodega = b;
        this.actualProducto = bodega.getProductos().get(0);
        this.indiceActual = 0; 
    }
    
    @Override 
    public Producto getNext() {
        List<Producto> lista = bodega.getProductos();
        
        if(hasNext()){
            this.actualProducto = lista.get(indiceActual);
            indiceActual++;
            System.out.println("El siguiente producto es: " + actualProducto);
        }else{
            System.out.println("No hay más productos para mostrar");
        }
        return actualProducto;
    }

    @Override
    public boolean hasNext() {
        if(indiceActual == bodega.getProductos().size()){
            return false;
        }else{
            return true;
        }
    }
    
    
}
