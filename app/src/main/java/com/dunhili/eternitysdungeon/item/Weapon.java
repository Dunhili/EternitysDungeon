package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.character.Stat;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Weapon extends EquippableItem {
    private static final String TAG = "Weapon";

    private WeaponAttributes weaponAttr;

    public Weapon(WeaponAttributes weaponAttr, String name, int value, int id) {
        super(name, value, id);
        this.weaponAttr = weaponAttr;
    }

    public WeaponAttributes getWeaponAttr() {
        return weaponAttr;
    }

    @Override
    public Item clone() {
        Item weapon = new Weapon(getWeaponAttr(), getName(), getValue(), getId());
        return weapon;
    }
}
