/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardCreator;

import cardsType.BasicCard;
import cardsType.Card;

/**
 *
 * @author lancervs
 */
public class BasicCardCreator implements CardCreator{

    @Override
    public Card createCard() {
        Card tarjeta = new BasicCard(500, 50);
        return tarjeta;
    }
    
    
}
