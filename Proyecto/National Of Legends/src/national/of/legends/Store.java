package national.of.legends;

/**
 *
 * @author Julieth
 */

   import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * clase Store
 * @author Julieth
 */
/**
 * Clase Store 
 * @author Julieth
 */
public class Store {
    private List<Cards> availableCards;
    private List<Cards> normalCards;
    private List<Cards> rareCards;
    private List<Cards> epicCards;
    private List<Cards> legendaryCards;
    private List<Cards> mythicalCards;
/**
 * constructor de Store
 */
    public Store() {
        // Inicializa las listas de cartas disponibles en la tienda
        availableCards = new ArrayList<>();
        normalCards = new ArrayList<>();
        rareCards = new ArrayList<>();
        epicCards = new ArrayList<>();
        legendaryCards = new ArrayList<>();
        mythicalCards = new ArrayList<>();

        // Agrega cartas a cada lista según su rareza
        initializeCards();

        // Agrega las cartas disponibles a la lista de cartas
        availableCards.addAll(normalCards);
        availableCards.addAll(rareCards);
        availableCards.addAll(epicCards);
        availableCards.addAll(legendaryCards);
        availableCards.addAll(mythicalCards);
    }
/**
 * Metodos para inicializar las cartas
 */
    private void initializeCards() {
        // Agrega cartas a las listas de cada rareza (puedes personalizar las cartas)
        normalCards.add(new Cards("Julio jaramillo", 20, 10, "Cantos perversos", 5));
        normalCards.add(new Cards("Isaac", 15, 8, "Busca hamburguesas ", 4));

        rareCards.add(new Cards("Messi", 30, 15, "EL G.O.A.T", 10));
        rareCards.add(new Cards("Mario ayiyiyi", 25, 12, "Te invitan a tomar", 8));

        epicCards.add(new Cards("Cancerbero", 40, 20, "El corazon tucun tucun", 15));
        epicCards.add(new Cards("Ala", 35, 18, "Coram ", 13));

        legendaryCards.add(new Cards("Machete del abuelo", 50, 25, "Filo -19857", 20));
        legendaryCards.add(new Cards("Profe Noguera", 45, 22, "Master en programacion", 18));

        mythicalCards.add(new Cards("Luis Barquero Villalobos", 60, 30, "Tira vergazos", 25));
        mythicalCards.add(new Cards("Juan Santamaria", 55, 28, "antorcharzo", 23));
    }
/**
 * metodo para mostrar los items
 */
    public void displayItems() {
        System.out.println("Cartas disponibles en la tienda:");
        int index = 1;
        for (Cards card : availableCards) {
            System.out.println(index + ". " + card.getName() + " - Vida: " + card.getHealth() +
                    ", Daño: " + card.getDamage() + ", Habilidad: " + card.getAbilities() +
                    ", Costo de Mana: " + card.getManaCost());
            index++;
        }
    }
/**
 * metodo para verificar si el item es valido
 * @param selectedItem
 * @return 
 */
    public boolean isValidItem(int selectedItem) {
        return selectedItem >= 1 && selectedItem <= availableCards.size();
    }

    public Cards getItem(int selectedItem) {
        if (isValidItem(selectedItem)) {
            return availableCards.get(selectedItem - 1);
        }
        return null;
    }
/**
 * metodo para comprar la cartas
 * @param selectedItem
 * @return 
 */
    public Cards buyCard(int selectedItem) {
        if (isValidItem(selectedItem)) {
            Cards selectedCard = availableCards.get(selectedItem - 1);
            availableCards.remove(selectedCard);
            return selectedCard;
        }
        return null;
    }
/**
 * metodo que las agrega
 * @param card
 * @param playerDeck 
 */
    public void addCardToPlayerDeck(Cards card, List<Cards> playerDeck) {
        // Agrega la carta al mazo del jugador
        playerDeck.add(card);
    }
/**
 * genera una coleccion random de cartas para el mazo del player 
 * @param playerDeck 
 */
    public void addRandomCardToPlayerDeck(List<Cards> playerDeck) {
        // Agrega una carta aleatoria al mazo del jugador
        if (!availableCards.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availableCards.size());
            Cards randomCard = availableCards.get(randomIndex);
            playerDeck.add(randomCard);
            availableCards.remove(randomCard);
        }
    }


}
    

