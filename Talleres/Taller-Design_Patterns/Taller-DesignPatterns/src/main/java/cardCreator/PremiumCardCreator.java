/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardCreator;

import cardsType.Card;
import cardsType.PremiumCard;

/**
 *
 * @author lancervs
 */
public class PremiumCardCreator implements CardCreator {

    @Override
    public Card createCard() {
        Card tarjeta = new PremiumCard(5000, 300);
        return tarjeta;
    }
}
