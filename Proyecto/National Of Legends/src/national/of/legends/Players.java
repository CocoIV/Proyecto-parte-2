
package national.of.legends;

/**
 *
 * @author Poker
 */
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.SourceVersion;
/**
 * clase Players
 * @author Julieth
 */
public class Players {
    private String name;
    private List<Cards> deck;
    private int healthPoints;
/**
 * constructor de Players
 * @param name
 * @param deck 
 */
    public Players(String name, List<Cards> deck) {
        this.name = name;
        this.deck = new ArrayList<>(deck);
        this.healthPoints = 30; // Puedes establecer otro valor inicial si lo deseas
    }
/**
 * metodos getters y setters
 * @return 
 */
    public String getName() {
        return name;
    }

    public List<Cards> getDeck() {
        return deck;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void reduceHealth(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }

    public void receiveCard(Cards card) {
        deck.add(card);
    }

    

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    public static void main(String[] args) {
        // Ejemplo de cómo usar la clase Players
        List<Cards> initialDeck = new ArrayList<>();
        // Agrega cartas iniciales al mazo del jugador
        initialDeck.add(new Cards("Veguetta", 10, 5, "Ability1", 2));
        initialDeck.add(new Cards("Albion Online", 8, 4, "Ability2", 3));
        initialDeck.add(new Cards("Mariito ayiyiyi", 12, 6, "Ability3", 4));

        Players player = new Players("Jugador1", initialDeck);

        System.out.println(player.getName() + "'s deck:");
        for (Cards card : player.getDeck()) {
            System.out.println("Name: " + card.getName() + ", Health: " + card.getHealth() + ", Damage: " + card.getDamage());
        }

        player.reduceHealth(5); // Simula perder salud
        System.out.println(player.getName() + "'s health after taking damage: " + player.getHealthPoints());

        Cards newCard = new Cards("Card4", 15, 7, "Ability4", 5);
        player.receiveCard(newCard); // Recibe una nueva carta

        System.out.println(player.getName() + "'s deck after receiving a new card:");
        for (Cards card : player.getDeck()) {
            System.out.println("Name: " + card.getName() + ", Health: " + card.getHealth() + ", Damage: " + card.getDamage());
        }
    }
}
