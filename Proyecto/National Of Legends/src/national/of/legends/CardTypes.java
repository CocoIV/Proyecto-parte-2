/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package national.of.legends;

/**
 *
 * @author Diego
 */
/**
 * Calse Cardtypes
 * @author Julieth
 */
public class CardTypes { //especifica el tipo de la carta
    public enum ElementType {
        Comun, Raro, Epico, legendiario, mititco
    }
/**
 * metodos de las cartas segun sus tipos
 */
    private ElementType elementType;

    public CardTypes(ElementType elementType) {
        this.elementType = elementType;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }
}
