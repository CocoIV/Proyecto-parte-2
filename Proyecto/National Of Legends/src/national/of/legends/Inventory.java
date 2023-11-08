/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package national.of.legends;

/**
 *
 * @author Julieth
 */
import java.util.ArrayList;
import java.util.List;
/**
 * clase Inventory
 * @author Julieth
 */
public class Inventory {
    private List<Cards> cardsInInventory;
/**
 * metodos para inventario de las cartas
 */
    public Inventory() {
        this.cardsInInventory = new ArrayList<>();
    }

    public void addCardToInventory(Cards card) {
        cardsInInventory.add(card);
    }

    public void removeCardFromInventory(Cards card) {
        cardsInInventory.remove(card);
    }

    public List<Cards> getCardsInInventory() {
        return cardsInInventory;
    }

    public void addCardToBattleDeck(Cards card, BattleDeck battleDeck) {
        if (cardsInInventory.contains(card)) {
            battleDeck.addCardToDeck(card);
            removeCardFromInventory(card);
        }
    }

    private static class BattleDeck {

        public BattleDeck() {
        }

        private void addCardToDeck(Cards card) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}