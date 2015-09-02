/**
 * Intermediate item class that is subclassed by armors and weapons, which are equipped by the
 * character rather than simply carried around. 
 * Created by Dunhili on 9/2/2015.
 */
public abstract class EquippableItem extends Item {
    /**
     * Creates an equippable item with the given name, sell value, and item ID.
     * @param name name of the item
     * @param value buy and sell value of the item
     * @param id unique item ID
     */
    public EquippableItem(String name, int value, int id) {
        super(name, value, id);
    }
}
