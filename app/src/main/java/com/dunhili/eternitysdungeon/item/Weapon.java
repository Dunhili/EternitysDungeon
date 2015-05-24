package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Weapon extends Item {
    private int meleeAttack = 0;
    private int rangeAttack = 0;
    private int spellAttack = 0;

    public Weapon(int value, int id, int meleeAttack, int rangeAttack, int spellAttack) {
        super(value, id, 1);
        this.meleeAttack = meleeAttack;
        this.rangeAttack = rangeAttack;
        this.spellAttack = spellAttack;
    }

    public int getMeleeAttack() {
        return meleeAttack;
    }

    public int getRangeAttack() {
        return rangeAttack;
    }

    public int getSpellAttack() {
        return spellAttack;
    }

    @Override
    public Item clone() {
        Item weapon = new Weapon(getValue(), getId(), getMeleeAttack(), getRangeAttack(), getSpellAttack());
        return weapon;
    }

    @Override
    public void use() {
        return;
    }
}
