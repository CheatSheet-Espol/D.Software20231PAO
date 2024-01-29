/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cardsType;

/**
 *
 * @author lancervs
 */
public class Card {
    
    private double limiteCrediticio;
    private double costoAnual;
    
    //Atributo agregado para lograr que sea más funcional 
    private double valorTarjeta;
    
    public Card(double limiteCrediticio, double costoAnual){
        this.costoAnual = costoAnual;
        this.limiteCrediticio = limiteCrediticio;
        this.valorTarjeta = 0;
    }
    
    public void pagar(){
        System.out.println("Pagado correctamente con una tarjeta genérica\n");
    }
    
    public void acreditar(double valor){
        this.valorTarjeta += valor;
        System.out.println("Acreditado correctamente a tarjeta genérica, el total ahora es: " + this.valorTarjeta +"\n");
    }

    public double getLimiteCrediticio() {
        return limiteCrediticio;
    }

    public double getCostoAnual() {
        return costoAnual;
    }

    public double getValorTarjeta() {
        return valorTarjeta;
    }
    
    protected void setValorTarjeta(double v){
        this.valorTarjeta = v;
    }
}
