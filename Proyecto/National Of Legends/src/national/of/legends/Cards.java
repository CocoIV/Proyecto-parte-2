
package national.of.legends;


import java.io.Serializable;

//se personaliza las cartas con nombre, vida, daño, habilidades y costo mana
/**
 * Clase Cards
 * @author Julieth
 */
public class Cards implements Serializable {
    private String name;
    private int health;
    private int damage;
    private String abilities;
    private int manaCost;
    private CardTypes.ElementType elementType; // Tipo o elemento de la carta

    /**
     * Constructor de la clase Cards
     * @param name
     * @param health
     * @param damage
     * @param abilities
     * @param manaCost
     * @param elementType 
     */
    public Cards(String name, int health, int damage, String abilities,
            int manaCost, CardTypes.ElementType elementType) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.abilities = abilities;
        this.manaCost = manaCost;
        this.elementType = elementType;
    }

    // Constructor para crear una carta sin elemento
    /**
     * Constructor sin elementos 
     * @param name
     * @param health
     * @param damage
     * @param abilities
     * @param manaCost 
     */
    public Cards(String name, int health, int damage, String abilities, 
            int manaCost) {
        this(name, health, damage, abilities, manaCost, null); // Elemento nulo
    }

    // Constructor con nombre, salud, daño y habilidad
    /**
     * Constructor de la clase card con nombre, salud y habilidad
     * @param name
     * @param health
     * @param damage
     * @param abilities 
     */
    public Cards(String name, int health, int damage, String abilities) {
        this(name, health, damage, abilities, 0, null); 
// Elemento nulo y costo de mana es cero
    }
/**
 * getters y setters
 * @return 
 */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public CardTypes.ElementType getElementType() {
        return elementType;
    }

    public void setElementType(CardTypes.ElementType elementType) {
        this.elementType = elementType;
    }
    
    public int getPrice() {
        // Implementa la lógica para obtener el precio de la carta
        return 0; 
    }

    public String getNombre() {
        return name;
    }

    public int getCostoMana() {
        // Implementa la lógica para obtener el costo de mana de la carta
        return manaCost; 
    }

    boolean getPoder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getVida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}





