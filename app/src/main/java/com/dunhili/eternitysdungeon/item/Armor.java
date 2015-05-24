package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Armor extends Item {
    private int meleeDefense = 0;
    private int rangeDefense = 0;
    private int spellDefense = 0;

    public Armor(String name, int value, int id, int meleeDefense, int rangeDefense, int spellDefense) {
        super(name, value, id, 1);
        this.meleeDefense = meleeDefense;
        this.rangeDefense = rangeDefense;
        this.spellDefense = spellDefense;
    }

    public int getMeleeDefense() {
        return meleeDefense;
    }

    public int getRangeDefense() {
        return rangeDefense;
    }

    public int getSpellDefense() {
        return spellDefense;
    }

    @Override
    public Item clone() {
        Item armor = new Armor(getName(), getValue(), getId(), getMeleeDefense(), getRangeDefense(), getSpellDefense());
        return armor;
    }

    @Override
    public void use() {
        return;
    }
}
