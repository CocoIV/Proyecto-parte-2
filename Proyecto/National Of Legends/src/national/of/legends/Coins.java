
package national.of.legends;

/**
 *
 * @author Diego
 */

/**
 * Clase coins
 * @author Julieth
 */
public class Coins {
    private int balance;
    //inicia el balance de las coins
    public Coins(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }
/**
 * metodo para agregar monedas
 * @param amount 
 */
    public void addCoins(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Has ganado " + amount + " monedas.");
            //detecta quien gano y cuantas coins gana
        }
    }
/**
 * monedas para la tienda
 * @param amount
 * @return 
 */
    public boolean spendCoins(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Has gastado " + amount + " monedas.");
            //le dice al player cuantas monedas gasto en la store 
            return true;
        } else {
            System.out.println("No tienes suficientes monedas.");
            return false;
        }
    }
}
