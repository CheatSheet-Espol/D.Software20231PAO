/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardCreator;

import cardsType.Card;
import cardsType.VIPCard;

/**
 *
 * @author lancervs
 */
public class VIPCardCreator implements CardCreator {

    @Override
    public Card createCard() {
        Card tarjeta = new VIPCard(10000, 500);
        return tarjeta;
    }
    
}
