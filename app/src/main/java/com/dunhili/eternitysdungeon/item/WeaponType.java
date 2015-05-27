package com.dunhili.eternitysdungeon.item;

/**
 * Enum for all the different types of weapons.
 * Created by Dunhili on 5/24/2015.
 */
public enum WeaponType {
    UNARMED("No weapon."),
    DAGGER("Fast, low damage, high crit, one-handed melee weapon."),
    SWORD("Fast, medium damage, one-handed melee weapon."),
    MACE("Medium damage, one-handed melee weapon that is good against heavy armor."),
    LANCE("Long-range melee weapon."),
    AXE("Slow, high damage melee weapon."),
    HANDAXE("High damage, short range throwing weapon."),
    JAVELIN("Medium damage, medium range throwing weapon."),
    BOW("Fast, long range weapon."),
    CROSSBOW("Slow, high damage, long range weapon."),
    STAFF("Slow, two-handed melee weapon that boosts spell damage."),
    TOME("Off-hand that boosts spell damage.");

    private String description;

    private WeaponType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
