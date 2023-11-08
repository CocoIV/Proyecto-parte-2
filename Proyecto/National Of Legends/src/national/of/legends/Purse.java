
package national.of.legends;

/**
 *
 * @author Diego
 */

    import java.util.ArrayList;
import java.util.List;
/**
 * clase Purse
 * @author Julieth
 */
public class Purse {
    private int coins;
    private final List<Item> items;
/**
 * constructor de Purse
 * @param initialCoins 
 */
    public Purse(int initialCoins) {
        this.coins = initialCoins;
        this.items = new ArrayList<>();
    }

    public void addCoins(int numberOfCoins) {
        this.coins += numberOfCoins;
    }

    public void spendCoins(int numberOfCoins) {
        if (this.coins >= numberOfCoins) {
            this.coins -= numberOfCoins;
        } else {
            System.out.println("No tienes suficientes monedas para gastar.");
        }
    }
/**
 * metodos getters y setters
 * @return 
 */
    public int getCoins() {
        return this.coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean canAfford(int price) {
        return this.coins >= price;
    }

    public void addItems(Item itemToBuy) {
        this.items.add(itemToBuy);
    }

    public List<Item> getItems() {
        return this.items;
    }
}
    
    
