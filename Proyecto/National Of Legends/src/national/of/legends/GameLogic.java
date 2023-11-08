package national.of.legends;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase GameLogic
 * @author Julieth
 */
public class GameLogic {
    private final Store store;
    private final Coins coins;
    private List<Cards> playerCards;
    private List<Cards> aiPlayerCards;
    private Scanner scanner;

    public GameLogic() {
        this.store = new Store();
        this.coins = new Coins(500);
        this.playerCards = createInitialPlayerCards();
        this.aiPlayerCards = createInitialAICards();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {
            System.out.println("Bienvenido al juego.");
            System.out.println("Tienes " + coins.getBalance() +
                    " monedas en tu billetera.");

            System.out.println("Tus cartas:");
            for (int i = 0; i < playerCards.size(); i++) {
                System.out.println((i + 1) +
                        ". " + playerCards.get(i).getNombre());
            }

            System.out.println("Opciones:");
            System.out.println("1. Visitar la tienda");
            System.out.println("2. Ver tu inventario");
            System.out.println("3. Combat");
            System.out.println("4. Terminar el juego");
            System.out.print("Elige una opción: ");

            int opcion = getValidOption();

            switch (opcion) {
                case 1:
                    visitStore();
                    break;
                case 2:
                    viewInventory();
                    break;
                case 3:
                    startCombat();
                    break;
                case 4:
                    endGame();
                    return;
                default:
                    System.out.println("Opción no válida."
                            + " Por favor, elige una opción válida.");
            }
        }
    }

    private void startCombat() {
        while (true) {
            System.out.println("Modo de combate:");
            System.out.println("1. Jugador vs. Jugador");
            System.out.println("2. Jugador vs. IA");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");

            int combatMode = getValidOption();

            switch (combatMode) {
                case 1:
                    playerVsPlayerCombat();
                    break;
                case 2:
                    playerVsIACombat();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, "
                            + "elige una opción válida.");
            }
        }
    }

    private void playerVsPlayerCombat() {
        System.out.println("Combate Jugador vs. Jugador");

        System.out.println("Jugador 1, selecciona una carta de tu mazo: ");
        int player1CardIndex = getValidOption();

        Cards player1Card = playerCards.remove(player1CardIndex - 1);

        System.out.println("Jugador 2, selecciona una carta de tu mazo: ");
        int player2CardIndex = getValidOption();

        Cards player2Card = playerCards.remove(player2CardIndex - 1);

        Cards winnerCard = combatCards(player1Card, player2Card);

        if (winnerCard == player1Card) {
            System.out.println("¡Felicidades, Jugador 1! Has ganado la ronda.");
        } else {
            System.out.println("¡Felicidades, Jugador 2! Has ganado la ronda.");
        }

        System.out.println("¿Quieres continuar el combate? (1. Sí, 2. No): ");
        int continueCombat = scanner.nextInt();

        if (continueCombat == 1) {
            playerVsPlayerCombat();
        } else {
            System.out.println("El combate ha terminado.");
        }
    }

    private void playerVsIACombat() {
        System.out.println("Combate Jugador vs. IA");

        System.out.println("Selecciona una carta de tu mazo, no mayor a 3: ");
        int playerCardIndex = getValidOption();

        Cards playerCard = playerCards.remove(playerCardIndex - 1);

        System.out.println("La IA elige una carta de su mazo.");

        Random random = new Random();
        int aiCardIndex = random.nextInt(aiPlayerCards.size());
        Cards aiCard = aiPlayerCards.remove(aiCardIndex);

        Cards winnerCard = combatCards(playerCard, aiCard);

        if (winnerCard == playerCard) {
            System.out.println("¡Felicidades, has ganado la ronda contra la IA!");
        } else {
            System.out.println("La IA ha ganado la ronda.");
        }

        System.out.println("¿Quieres continuar el combate? (1. Sí, 2. No): ");
        int continueCombat = scanner.nextInt();

        if (continueCombat == 1) {
            playerVsIACombat();
        } else {
            System.out.println("El combate ha terminado.");
        }
    }

    private Cards combatCards(Cards card1, Cards card2) {
        System.out.println("Combate: " + card1.getNombre() + " vs. " 
                + card2.getNombre());
        System.out.println("Ataque de " + card1.getNombre() + ": " 
                + card1.getDamage());
        System.out.println("Ataque de " + card2.getNombre() + ": " 
                + card2.getDamage());

        Cards winningCard = (card1.getDamage() >= card2.getDamage())
                ? card1 : card2;
        System.out.println("La carta ganadora es: " + winningCard.getNombre());

        return winningCard;
    }

    private List<Cards> createInitialPlayerCards() {
        List<Cards> initialCards = new ArrayList<>();
        initialCards.add(new Cards("Zlatan", 20, 15, "ZAPATAZO",
                5));
        initialCards.add(new Cards("Maximo meridio", 15, 9, "SPARTAAAA", 
                3));
        initialCards.add(new Cards("Figueres", 25, 17, "SE PERDIO LA PLATA",
                7));
        return initialCards;
    }

    private List<Cards> createInitialAICards() {
        List<Cards> aiInitialCards = new ArrayList<>();
        aiInitialCards.add(new Cards("Carta de la IA 1", 18, 9, 
                "Habilidad IA 1", 4));
        aiInitialCards.add(new Cards("Carta de la IA 2", 16, 7, 
                "Habilidad IA 2", 3));
        aiInitialCards.add(new Cards("Carta de la IA 3", 22, 11,
                "Habilidad IA 3", 6));
        return aiInitialCards;
    }

    private int getValidOption() {
        int option;
        while (true) {
            try {
                String input = scanner.nextLine();
                option = Integer.parseInt(input);
                if (option >= 1) {
                    return option;
                } else {
                    System.out.println("Ingresa un número válido "
                            + "(mayor o igual a 1).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
            }
        }
    }

    private void endGame() {
        System.out.println("Juego terminado. ¡Gracias por jugar!");
    }

    private void viewInventory() {
        System.out.println("Inventario de cartas:");
        for (int i = 0; i < playerCards.size(); i++) {
            System.out.println((i + 1) + ". " + playerCards.get(i).getNombre());
        }
        System.out.print("Elige una carta para cambiar en tu mazo"
                + " (1, 2, 3, ...): ");
        int selectedCard = getValidOption();
        if (selectedCard >= 1 && selectedCard <= playerCards.size()) {
            store.addCardToPlayerDeck(playerCards.remove(selectedCard - 1),
                    playerCards);
        } else {
            System.out.println("Opción no válida. Por favor, elige una "
                    + "carta válida.");
        }
    }

    private void visitStore() {
        System.out.println("¡Bienvenido a la tienda!");
        store.displayItems();

        System.out.print("Elige un artículo para comprar (1, 2, 3, ...): ");
        int selectedItem = getValidOption();

        if (store.isValidItem(selectedItem)) {
            Cards itemToBuy = store.buyCard(selectedItem);
            if (itemToBuy != null) {
                if (coins.spendCoins(itemToBuy.getCostoMana())) {
                    playerCards.add(itemToBuy);
                    System.out.println("Has comprado " + itemToBuy.getNombre() +
                            " por " + itemToBuy.getCostoMana() + " monedas.");
                } else {
                    System.out.println("No tienes suficientes monedas para "
                            + "comprar este artículo.");
                }
            } else {
                System.out.println("El artículo seleccionado no es válido.");
            }
        } else {
            System.out.println("Opción no válida. Por favor, elige un "
                    + "artículo válido.");
        }
    }

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.startGame();
    }
}
