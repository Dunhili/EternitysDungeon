package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.utils.Logging;

/**
 * Represents the attributes for the armor a character would wear.
 * Created by Dunhili on 5/23/2015.
 */
public class Armor extends EquippableItem {
    private static final String TAG = "Armor";

    private ArmorType armorType = ArmorType.NONE;
    private int physicalDefense = 0;
    private int magicDefense = 0;
    private int speedPenalty = 0;

    /**
     * Creates a new Armor with the given attributes.
     * @param armorAttr wrapper for the armor attributes
     * @param name name of the armor
     * @param value value (in gp) of the armor
     * @param id unique ID for the armor
     * @param armorType type of armor
     * @param physicalDefense amount of physical damage that is reduced
     * @param magicDefense amount of magical damage that is reduced
     * @param speedPenalty amount the armor encumbers the user
     */
    public Armor(String name, int value, int id, ArmorType armorType, int physicalDefense, int magicDefense, int speedPenalty) {
        super(name, value, id);
        this.armorType = armorType;
        this.physicalDefense = physicalDefense;
        this.magicDefense = magicDefense;
        this.speedPenalty = speedPenalty;
    }

    /**
     * Returns the type of armor.
     * @return armor type
     */
    public ArmorType getArmorType() {
        return armorType;
    }

    /**
     * Returns the amount of physical damage that is reduced.
     * @return physical damage reduction
     */
    public int getPhysicalDefense() {
        return physicalDefense;
    }

    /**
     * Returns the amount of magical damage that is reduced.
     * @return magical damage reduction
     */
    public int getMagicDefense() {
        return magicDefense;
    }

    /**
     * Returns the amount that this armor reduces the speed by.
     * @return speed reduction amount
     */
    public int getSpeedPenalty() {
        return speedPenalty;
    }

    /**
     * Returns a deep copy of the armor.
     * @return deep copy of the armor
     */
    @Override
    public Item clone() {
        Logging.debug(TAG, "clone()");
        Item armor = new Armor(getName(), getValue(), getId(), getArmorType(), getPhysicalDefense(), getMagicDefense(), getSpeedPenalty());
        return armor;
    }
}
