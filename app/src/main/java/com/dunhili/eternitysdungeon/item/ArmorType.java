package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/25/2015.
 */
public enum ArmorType {
    NONE("No armor."),
    ROBE("Very light armor that doesn't impede spell-casting."),
    LIGHT("Armor that allows for greater movement and flexibility."),
    MEDIUM("Armor that offers a compromise of protection and movement."),
    HEAVY("Armor that offers a high amount of protection, but impedes movement."),
    SHIELD("Can be held in the off-hand for increased protection.");

    private String description;

    private ArmorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
