package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.utils.Logging;

/**
 * Wrapper class for the set of attributes specific to {@link Armor}.
 * Created by Dunhili on 5/26/2015.
 */
public class ArmorAttributes {
    private static final String TAG = "ArmorAttributes";

    private ArmorType armorType = ArmorType.NONE;
    private int physicalDefense = 0;
    private int magicDefense = 0;
    private int speedPenalty = 0;

    /**
     * Creates a wrapper for the armor's attributes using the given values.
     * @param armorType type of armor
     * @param physicalDefense amount of physical damage that is reduced
     * @param magicDefense amount of magical damage that is reduced
     * @param speedPenalty amount the armor encumbers the user
     */
    public ArmorAttributes(ArmorType armorType, int physicalDefense, int magicDefense, int speedPenalty) {
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
        Logging.debug(TAG, "getArmorType()");
        return armorType;
    }

    /**
     * Returns the amount of physical damage that is reduced.
     * @return physical damage reduction
     */
    public int getPhysicalDefense() {
        Logging.debug(TAG, "getPhysicalDefense()");
        return physicalDefense;
    }

    /**
     * Returns the amount of magical damage that is reduced.
     * @return magical damage reduction
     */
    public int getMagicDefense() {
        Logging.debug(TAG, "getMagicDefense()");
        return magicDefense;
    }

    /**
     * Returns the amount that this armor reduces the speed by.
     * @return speed reduction amount
     */
    public int getSpeedPenalty() {
        Logging.debug(TAG, "getSpeedPenalty()");
        return speedPenalty;
    }
}
