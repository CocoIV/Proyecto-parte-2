
package national.of.legends;

/**
 *
 * @author Diego
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * clase deck
 * @author Julieth
 */
public class Deck {
    private List<Cards> cards;
/**
 * constructor para las cartas iniciales
 * @param initialCards 
 */
    public Deck(List<Cards> initialCards) {
        this.cards = new ArrayList<>(initialCards);
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
/**
 * metodo de la clase
 * @return 
 */
    public Cards drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0); // Remueve y devuelve la primera carta del mazo
        } else {
            return null; // El mazo está vacío
        }
    }
/**
 * constructor para player y numero de carta
 * @param players
 * @param numCardsPerPlayer 
 */
    public void dealCards(List<Player> players, int numCardsPerPlayer) {
        Random random = new Random();
        for (int i = 0; i < numCardsPerPlayer; i++) {
            for (Player player : players) {
                Cards card = drawCard();
                if (card != null) {
                    player.receiveCard(card);
                }
            }
        }
    }
}
