
package national.of.legends;

/**
 *
 * @author Diego
 */
import java.util.List;

import java.util.List;
/**
 * Clase combat
 * @author Julieth
 */
public class Combat {
    //se declaran payer 1 y 2 
    private Player player1;
    private Player player2;
 /**
  * constructor de la clase combat
  * @param player1
  * @param player2 
  */
    public Combat(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
/**
 * metodo para iniciar combate
 */
    public void startCombat() {
        while (true) {
            // Realizar un turno de combate
            performTurn(player1, player2);
            if (isGameOver(player1, player2)) {
                break;
            }

            // Realizar un turno de la IA 
            performTurn(player2, player1);
            if (isGameOver(player1, player2)) {
                break;
            }
        }

        // Determinar el ganador entre los players 
        Player winner = determineWinner(player1, player2);
        System.out.println("El ganador es: " + winner.getName());
    }
    /**
     * metodos que declara el turno
     * @param attacker
     * @param defender 
     */
    //se declara el ataque y defensa del player 
    private void performTurn(Player attacker, Player defender) {
        List<Cards> attackerDeck = attacker.getDeck();
        List<Cards> defenderDeck = defender.getDeck();

        if (attackerDeck.isEmpty()) {
            System.out.println(attacker.getName() + " no tiene más cartas para"
                    + " jugar.");
            return;
        }
           //determina el turno del player 
        Cards cardToPlay = attackerDeck.get(0);
        System.out.println(attacker.getName() + " juega " 
                + cardToPlay.getName());
        //indica que jugador recibe el daño
        int damage = cardToPlay.getDamage();
        defender.receiveDamage(damage);
        System.out.println(defender.getName() + " recibe " + damage + 
                " puntos de daño.");

        attackerDeck.remove(0);
    }
/**
 * metodo para confirmar si finaliza el juego
 * @param player1
 * @param player2
 * @return 
 */
    private boolean isGameOver(Player player1, Player player2) {
        return player1.getDeck().isEmpty() || player2.getDeck().isEmpty();
    }
    //detecta cual fue el resultado de la partida 
    private Player determineWinner(Player player1, Player player2) {
        if (player1.getDeck().isEmpty() && player2.getDeck().isEmpty()) {
            System.out.println("¡Es un empate!");
            return null;
        } else if (player1.getDeck().isEmpty()) {
            return player2;
        } else {
            return player1;
        }
    }
}

