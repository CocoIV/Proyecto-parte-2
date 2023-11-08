
package national.of.legends;

/**
 *
 * @author Diego
 */
import java.io.Serializable;
/**
 * clase Item
 * @author Julieth
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int price;
/**
 * constructor para Item
 * @param name
 * @param price 
 */
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
