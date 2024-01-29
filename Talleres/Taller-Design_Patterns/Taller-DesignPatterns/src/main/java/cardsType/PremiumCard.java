/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardsType;

/**
 *
 * @author lancervs
 */
public class PremiumCard extends Card {

    public PremiumCard(double limiteCrediticio, double costoAnual) {
        super(limiteCrediticio, costoAnual);
        System.out.println("Tarjeta Premium creada con éxito\n");
    }

    @Override
    public void acreditar(double valor) {
        this.setValorTarjeta(this.getValorTarjeta() + valor);
        System.out.println("Acreditado correctamente a tarjeta Premium, el total ahora es: " + this.getValorTarjeta() + "\n");
    }

    @Override
    public void pagar() {
        System.out.println("Pagado correctamente con una tarjeta Premium\n");
    }

}
