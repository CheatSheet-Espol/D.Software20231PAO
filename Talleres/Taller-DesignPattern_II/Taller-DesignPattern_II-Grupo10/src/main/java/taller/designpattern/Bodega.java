/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.designpattern;

import iterator.BodegaIterator;
import iterator.ProductoIterator;
import iterator.TiendaIterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lancervs
 */
public class Bodega implements TiendaIterator{
    
    private List<Producto> productos;
    private String tipoBodega;
    
    public Bodega(String tipoBodega){
        this.tipoBodega = tipoBodega;
        this.productos = new ArrayList<>();
    }
    
    public void addProducto(Producto p){
        this.productos.add(p);
        System.out.println( p +" añadido correctamente a la bodega de " + tipoBodega);
    }
    
    public void removeProducto(Producto p){
        this.productos.remove(p);
        System.out.println(p + " eliminado del catálogo");
    }

    @Override
    public ProductoIterator createProductoIterator() {
        return new BodegaIterator(this);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getTipoBodega() {
        return tipoBodega;
    }
    
    
    
}
