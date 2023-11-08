
package national.of.legends;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
/**
 * clase player
 * @author Julieth
 */
public class Player {
    private String playerName;
    private int coins;
    private List<Cards> deck;
/**
 * constructor para Player
 * @param playerName 
 */
    public Player(String playerName) {
        this.playerName = playerName;
        this.coins = 500; // Monedas iniciales
        this.deck = new ArrayList<>();

        // Agregar 5 cartas iniciales al mazo del jugador
        deck.add(new Cards("Marcos", 20, 5, "Habilidad1"));
        deck.add(new Cards("William Walker", 15, 8, "Habilidad2"));
        deck.add(new Cards("Juan SantaGod", 10, 10, "Habilidad3"));
        deck.add(new Cards("Messi", 25, 3, "Habilidad4"));
        deck.add(new Cards("Star Lord", 30, 7, "Habilidad5"));
    }
/**
 * metodos getters y setters
 * @return 
 */
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Cards> getDeck() {
        return deck;
    }

    public void setDeck(List<Cards> deck) {
        this.deck = deck;
    }

    // Agrega otros getters y setters según sea necesario

    void receiveCard(Cards card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void receiveDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    

