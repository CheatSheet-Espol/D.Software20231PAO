/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardsType;

/**
 *
 * @author lancervs
 */
public class VIPCard extends Card {

    public VIPCard(double limiteCrediticio, double costoAnual) {
        super(limiteCrediticio, costoAnual);
        System.out.println("Tarjeta VIP creada con éxito\n");
    }

    @Override
    public void acreditar(double valor) {
        this.setValorTarjeta(this.getValorTarjeta() + valor);
        System.out.println("Acreditado correctamente a tarjeta VIP, el total ahora es: " + this.getValorTarjeta() + "\n");
    }

    @Override
    public void pagar() {
        System.out.println("Pagado correctamente con una tarjeta VIP\n");
    }

}
