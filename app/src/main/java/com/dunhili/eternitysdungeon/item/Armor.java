package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Armor extends Item {
    private int physicalDefense = 0;
    private int spellDefense = 0;

    public Armor(String name, int value, int id, int physicalDefense, int spellDefense) {
        super(name, value, id, 1);
        this.physicalDefense = physicalDefense;
        this.spellDefense = spellDefense;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }


    public int getSpellDefense() {
        return spellDefense;
    }

    @Override
    public Item clone() {
        Item armor = new Armor(getName(), getValue(), getId(), getPhysicalDefense(), getSpellDefense());
        return armor;
    }

    @Override
    public void use() {
        return;
    }
}
