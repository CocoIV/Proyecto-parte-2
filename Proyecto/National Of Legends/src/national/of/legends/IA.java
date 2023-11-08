/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package national.of.legends;

/**
 *
 * @author Poker
 */
import java.util.List;
import java.util.Random;
/**
 * clase IA
 * @author Julieth
 */
public class IA {
    private String name;
    private List<Cards> deck;
/**
 * constrctor para clase IA
 * @param name
 * @param deck 
 */
    public IA(String name, List<Cards> deck) {
        this.name = name;
        this.deck = deck;
    }
/**
 * getters
 * @return 
 */
    public String getName() {
        return name;
    }

    public List<Cards> getDeck() {
        return deck;
    }

    public Cards playCard() {
        if (deck.isEmpty()) {
            System.out.println(name + " no tiene más cartas para jugar.");
            return null;
        }

        Random random = new Random();
        
       
int randomIndex = random.nextInt(deck.size());
        return deck.remove(randomIndex);
    }
}

