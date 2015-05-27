package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.utils.Logging;

/**
 * Represents the attributes for the armor a character would wear.
 * Created by Dunhili on 5/23/2015.
 */
public class Armor extends Item {
    private static final String TAG = "Armor";

    private ArmorAttributes armorAttr;

    /**
     * Creates a new Armor with the given attributes.
     * @param armorAttr wrapper for the armor attributes
     * @param name name of the armor
     * @param value value (in gp) of the armor
     * @param id unique ID for the armor
     */
    public Armor(ArmorAttributes armorAttr, String name, int value, int id) {
        super(name, value, id, 1);
        this.armorAttr = armorAttr;
    }

    /**
     * Returns the set of armor attributes.
     * @return armor attributes
     */
    public ArmorAttributes getArmorAttr() {
        Logging.debug(TAG, "getArmorAttr()");
        return armorAttr;
    }

    /**
     * Returns a deep copy of the armor.
     * @return deep copy of the armor
     */
    @Override
    public Item clone() {
        Logging.debug(TAG, "clone()");
        Item armor = new Armor(getArmorAttr(), getName(), getValue(), getId());
        return armor;
    }

    /**
     * Uses the armor, if the armor is listed as consumable, then it is destroyed afterward.
     */
    @Override
    public void use() {
        Logging.debug(TAG, "use()");
        return;
    }
}
