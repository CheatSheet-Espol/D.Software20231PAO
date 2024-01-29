/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller.designpatterns;

import cardCreator.BasicCardCreator;
import cardCreator.CardCreator;
import cardCreator.PremiumCardCreator;
import cardsType.Card;
import FacadePattern.*;

/**
 *
 * @author lancervs
 */
public class Client {

    public static void main(String[] args) {
        
        System.out.println("------TARJETA BÁSICA-----");
        System.out.println("EL CLIENTE QUIERE CREAR UNA TARJETA BÁSICA: \n");
        CardCreator creadorTarjeta0 = new BasicCardCreator();
        Card tarjetaBasica = creadorTarjeta0.createCard();
        
        System.out.println("EL CLIENTE QUIERE ACREDITAR $50 Y PAGAR CON SU TARJETA BÁSICA: \n");
        tarjetaBasica.acreditar(50);
        tarjetaBasica.pagar();
        
        System.out.println("------TARJETA PREMIUM-----");
        System.out.println("EL CLIENTE QUIERE CREAR UNA TARJETA Premium: \n");
        CardCreator creadorTarjeta2 = new PremiumCardCreator();
        Card tarjetaPremium = creadorTarjeta2.createCard();
        
        System.out.println("EL CLIENTE QUIERE ACREDITAR $200 Y PAGAR CON SU TARJETA PREMIUM: \n");
        tarjetaPremium.acreditar(200);
        tarjetaPremium.pagar();
        
        System.out.println("------TARJETA VIP-----");
        System.out.println("EL CLIENTE QUIERE CREAR UNA TARJETA VIP: \n");
        CardCreator creadorTarjeta = new PremiumCardCreator();
        Card tarjetaVIP = creadorTarjeta.createCard();
        
        System.out.println("EL CLIENTE QUIERE ACREDITAR $1000 Y PAGAR CON SU TARJETA VIP: \n");
        tarjetaVIP.acreditar(1000);
        tarjetaVIP.pagar();
        

        System.out.println("-------FACADE DEMO---------");
        FachadaTiendaMinorista tiendaMinorista= new FachadaTiendaMinorista();
        tiendaMinorista.usarElSistema("web");
        tiendaMinorista.usarElSistema("telefonica");
        tiendaMinorista.usarElSistema("movil");
        tiendaMinorista.usarElSistema("cloud");

    }
}
