package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Weapon extends Item {
    private static final String TAG = "Weapon";

    private WeaponType weaponType = WeaponType.SWORD;
    private int physicalAttack = 0;
    private int spellAttack    = 0;
    private int minRange       = 1;
    private int maxRange       = 1;
    private int critModifier   = 1;
    private int speedModifier  = 1;

    public Weapon(String name, int value, int id, int meleeAttack, int spellAttack) {
        super(name, value, id, 1);
        this.physicalAttack = meleeAttack;
        this.spellAttack = spellAttack;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getPhysicalAttack() { return physicalAttack; }

    public int getSpellAttack() {
        return spellAttack;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public int getSpeedModifier() {
        return speedModifier;
    }

    @Override
    public Item clone() {
        Item weapon = new Weapon(getName(), getValue(), getId(), getPhysicalAttack(), getSpellAttack());
        return weapon;
    }

    @Override
    public void use() {
        return;
    }
}
